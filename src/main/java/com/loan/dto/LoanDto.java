package com.loan.dto;

import com.loan.entity.Loan;
import com.loan.enums.LoanStatus;
import com.loan.enums.LoanType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoanDto {
    private Long id;
    private Long accountNumber;
    private LoanType loanType;
    private LoanStatus loanStatus;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private Integer loanTermInMonths;
    private BigDecimal outstandingBalance;
    private String firstNameBeneficiary;
    private String secondNameBeneficiary;
    private String lastNameBeneficiary;
    private String emailBeneficiary;
    private LocalDate startDate;
    private LocalDate endDate;
    public static LoanDto fromEntity(Loan loanEntity) {
        return LoanDto.builder()
                .id(loanEntity.getId())
                .accountNumber(loanEntity.getAccountNumber())
                .loanType(loanEntity.getLoanType())
                .loanStatus(loanEntity.getStatus() != null ? loanEntity.getStatus().getStatus() : null)
                .principalAmount(loanEntity.getPrincipalAmount())
                .interestRate(loanEntity.getInterestRate())
                .loanTermInMonths(loanEntity.getLoanTermInMonths())
                .outstandingBalance(loanEntity.getOutstandingBalance())
                .firstNameBeneficiary(loanEntity.getFirstNameBeneficiary())
                .secondNameBeneficiary(loanEntity.getSecondNameBeneficiary())
                .lastNameBeneficiary(loanEntity.getLastNameBeneficiary())
                .emailBeneficiary(loanEntity.getEmailBeneficiary())
                .startDate(loanEntity.getStartDate())
                .endDate(loanEntity.getEndDate())
                .build();
    }
}
