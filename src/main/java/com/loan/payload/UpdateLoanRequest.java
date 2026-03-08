package com.loan.payload;

import com.loan.enums.LoanStatus;
import com.loan.enums.LoanType;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateLoanRequest {
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
}
