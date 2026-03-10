package com.loan.service;

import com.loan.dto.LoanDto;
import com.loan.entity.Loan;
import com.loan.entity.LoanStatusEntity;
import com.loan.enums.LoanStatus;
import com.loan.exception.LoanAlreadyExistsException;
import com.loan.exception.ResourceNotFoundException;
import com.loan.payload.UpdateLoanRequest;
import com.loan.payload.CreateLoanRequest;
import com.loan.repositroy.LoanStatusRepository;
import com.loan.repositroy.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {
    private final LoanRepository loanRepository;
    private final LoanStatusRepository loanStatusRepository;

    @Transactional
    public LoanDto createLoan(CreateLoanRequest request) {
        log.info("Creating Loan for accountNumber: {}", request.getAccountNumber());
        validationIfExistsLoan(request);
        Loan loan = buildCreateLoanInformation(request);
        LoanStatusEntity loanStatus = fillStatusLoan(loan);
        loan.setStatus(loanStatus);
        Loan savedLoan = saveLoanInternal(loan);
        return LoanDto.fromEntity(savedLoan);
    }

    private void validationIfExistsLoan(CreateLoanRequest request) {
        loanRepository.findByAccountNumber(request.getAccountNumber()).ifPresent(loan -> {
            throw new LoanAlreadyExistsException("Loan", "accountNumber", request.getAccountNumber().toString());
        });
    }

    private Loan saveLoanInternal(Loan loan) {
        return loanRepository.save(loan);
    }

    @Transactional
    public LoanDto updateLoanInformation(Long id, UpdateLoanRequest request) {
        Loan loan = findById(id);
        fillUpdateInformation(loan, request);
        Loan savedLoan = saveLoanInternal(loan);
        return LoanDto.fromEntity(savedLoan);
    }

    public LoanDto getLoanByAccountNumber(Long accountNumber) {
        return LoanDto.fromEntity(findLoanByAccountNumber(accountNumber));
    }

    private void fillUpdateInformation(Loan loan, UpdateLoanRequest request) {
        if (request == null) {
            return;
        }
        Optional.ofNullable(request.getLoanType()).ifPresent(loan::setLoanType);
        if (request.getLoanStatus() != null) {
            if (loan.getStatus() != null) {
                loan.getStatus().setStatus(request.getLoanStatus());
            } else {
                loan.setStatus(fillStatusLoan(loan, request.getLoanStatus()));
            }
        }
        Optional.ofNullable(request.getPrincipalAmount()).ifPresent(loan::setPrincipalAmount);
        Optional.ofNullable(request.getInterestRate()).ifPresent(loan::setInterestRate);
        Optional.ofNullable(request.getLoanTermInMonths()).ifPresent(loan::setLoanTermInMonths);
        Optional.ofNullable(request.getOutstandingBalance()).ifPresent(loan::setOutstandingBalance);
        Optional.ofNullable(request.getFirstNameBeneficiary()).ifPresent(loan::setFirstNameBeneficiary);
        Optional.ofNullable(request.getSecondNameBeneficiary()).ifPresent(loan::setSecondNameBeneficiary);
        Optional.ofNullable(request.getLastNameBeneficiary()).ifPresent(loan::setLastNameBeneficiary);
        Optional.ofNullable(request.getEmailBeneficiary()).ifPresent(loan::setEmailBeneficiary);
    }

    private Loan buildCreateLoanInformation(CreateLoanRequest request) {
        return Loan.builder()
                .loanType(request.getLoanType())
                .accountNumber(request.getAccountNumber())
                .principalAmount(request.getPrincipalAmount())
                .interestRate(request.getInterestRate())
                .loanTermInMonths(request.getLoanTermInMonths())
                .outstandingBalance(request.getPrincipalAmount()) // Initially same as principal
                .firstNameBeneficiary(request.getFirstNameBeneficiary())
                .secondNameBeneficiary(request.getSecondNameBeneficiary())
                .lastNameBeneficiary(request.getLastNameBeneficiary())
                .emailBeneficiary(request.getEmailBeneficiary())
                .loanNumber(generateAccountNumber())
                .build();
    }

    private Long generateAccountNumber() {
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        log.info("created Account Number {}", randomLoanNumber);
        return randomLoanNumber;
    }

    public LoanDto getLoanById(Long id) {
        return LoanDto.fromEntity(findById(id));
    }

    public List<LoanDto> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(LoanDto::fromEntity)
                .toList();
    }

    private Loan findById(Long id) {
        return loanRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "id", id.toString())
        );
    }

    private Loan findLoanByAccountNumber(Long accountNumber) {
        return loanRepository.findByAccountNumber(accountNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "accountNumber", accountNumber.toString())
        );
    }

    private LoanStatusEntity fillStatusLoan(Loan loan) {
        return LoanStatusEntity.builder()
                .status(LoanStatus.PENDING)
                .loan(loan)
                .build();
    }

    private LoanStatusEntity fillStatusLoan(Loan loan, LoanStatus status) {
        return LoanStatusEntity.builder()
                .status(status)
                .loan(loan)
                .build();
    }
}


