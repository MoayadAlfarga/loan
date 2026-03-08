package com.loan.entity;

import com.loan.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loan_status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoanStatusEntity extends Audiate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_status")
    private LoanStatus status;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
