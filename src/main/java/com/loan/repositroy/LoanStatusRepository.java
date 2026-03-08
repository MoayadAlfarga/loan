package com.loan.repositroy;

import com.loan.entity.LoanStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanStatusRepository extends JpaRepository<LoanStatusEntity, Long> {
}
