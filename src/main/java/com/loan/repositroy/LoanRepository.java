package com.loan.repositroy;

import com.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByAccountNumber(Long accountNumber);

Optional <Loan> findByLoanNumber(Long loanNumber);
}
