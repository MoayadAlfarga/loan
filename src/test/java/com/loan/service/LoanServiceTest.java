package com.loan.service;

import com.loan.dto.LoanDto;
import com.loan.entity.Loan;
import com.loan.enums.LoanStatus;
import com.loan.enums.LoanType;
import com.loan.payload.CreateLoanRequest;
import com.loan.payload.UpdateLoanRequest;
import com.loan.repositroy.LoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class LoanServiceTest {
//    @Mock
//    private LoanRepository loanRepository;
//    @InjectMocks
//    private LoanService loanService;
//
//
//    public CreateLoanRequest fillRequestCreateNewLoan() {
//
//        return CreateLoanRequest.builder()
//                .loanType(LoanType.PERSONAL)
//                .accountNumber(1234567890L)
//                .principalAmount(new BigDecimal("10000.00"))
//                .interestRate(new BigDecimal("5.5"))
//                .loanTermInMonths(24)
//                .firstNameBeneficiary("Moayad")
//                .secondNameBeneficiary("Doe")
//                .lastNameBeneficiary("Smith")
//                .emailBeneficiary("moayad.doe@example.com")
//                .build();
//
//    }
//
//    @Test
//    public void create_Success_New_Loan() {
//        // Arrange
//        CreateLoanRequest newRequest = fillRequestCreateNewLoan();
//        Assertions.assertNotNull(newRequest);
//        when(loanRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
//
//        // Act
//        LoanDto loanDto = loanService.createLoan(newRequest);
//
//        // Assert
//        log.info("LoanDto: {}", loanDto);
//        Assertions.assertNotNull(loanDto);
//    }
//
//    @Test
//    public void create_Throws_Loan_AlreadyExists_Exception() {
//        CreateLoanRequest newRequest = fillRequestCreateNewLoan();
//        when(loanRepository.findByAccountNumber(newRequest.getAccountNumber())).thenReturn(Optional.of(new Loan()));
//        when(loanRepository.save(any(Loan.class))).thenAnswer(invocation -> invocation.getArgument(0));
//        LoanDto loanDto = loanService.createLoan(newRequest);
//        Assertions.assertNotNull(loanDto);
//        Assertions.assertEquals(newRequest.getAccountNumber(), loanDto.getAccountNumber());
//    }
//
//    public void getLoanByAccountNumber_Success() {
//        Long accountNumber = 1234567890L;
//        when(loanRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(new Loan()));
//        LoanDto loanDto = loanService.getLoanByAccountNumber(accountNumber);
//        log.info("LoanDto: {}", loanDto);
//        Assertions.assertNotNull(loanDto);
//        Assertions.assertEquals(accountNumber, loanDto.getAccountNumber());
//    }
//
//    @Test
//    public void get_All_Loans_Success_Return_List_LoanDto() {
//        when(loanRepository.findAll()).thenReturn(java.util.List.of(new Loan()));
//        Assertions.assertNotNull(loanService.getAllLoans());
//    }
//
//    public UpdateLoanRequest fillRequestUpdateLoan() {
//        return UpdateLoanRequest.builder()
//                .loanStatus(LoanStatus.ACTIVE)
//                .firstNameBeneficiary("John")
//                .build();
//    }
//
//    @Test
//    public void updateLoan_Success() {
//        UpdateLoanRequest updateLoanRequest = fillRequestUpdateLoan();
//        when(loanRepository.findByAccountNumber(1234567890L)).thenReturn(Optional.of(new Loan()));
//        when(loanRepository.save(any(Loan.class))).thenAnswer(invocation -> invocation.getArgument(0));
//        LoanDto loanDto = loanService.updateLoanInformation(1234567890L, updateLoanRequest);
//        Assertions.assertNotNull(loanDto);
//        Assertions.assertEquals(LoanStatus.ACTIVE, loanDto.getLoanStatus());
//    }
}
