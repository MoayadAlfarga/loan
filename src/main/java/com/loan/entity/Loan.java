package com.loan.entity;

import com.loan.enums.LoanStatus;
import com.loan.enums.LoanType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Loan extends Audiate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name_beneficiary")
    private String firstNameBeneficiary;
    @Column(name = "second_name_beneficiary")
    private String secondNameBeneficiary;
    @Column(name = "last_name_beneficiary")
    private String lastNameBeneficiary;
    @Column(name = "email_beneficiary")
    private String emailBeneficiary;
    @Column(name = "account_number")
    private Long accountNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "loan_type")
    private LoanType loanType;

    @Column(name = "principal_amount")
    private BigDecimal principalAmount;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    @Column(name = "loan_term_in_months")
    private Integer loanTermInMonths;
    @Column(name = "outstanding_balance")
    private BigDecimal outstandingBalance;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "loan_number")
    private Long loanNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private LoanStatusEntity status;
}
