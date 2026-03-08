package com.loan.payload;

import com.loan.enums.LoanType;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateLoanRequest {
    private LoanType loanType;
    private Long accountNumber;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private Integer loanTermInMonths;
    private String firstNameBeneficiary;
    private String secondNameBeneficiary;
    private String lastNameBeneficiary;
    private String emailBeneficiary;
}
