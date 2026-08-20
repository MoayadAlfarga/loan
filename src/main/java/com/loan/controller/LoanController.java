package com.loan.controller;

import com.loan.dto.LoanDto;
import com.loan.payload.UpdateLoanRequest;
import com.loan.payload.CreateLoanRequest;
import com.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanDto> createLoan(@RequestBody CreateLoanRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(request));
    }

    @GetMapping("account-number/{accountNumber}")
    public ResponseEntity<LoanDto> getLoanByAccountNumber(@PathVariable(name = "accountNumber") Long accountNumber) {
        return ResponseEntity.ok(loanService.getLoanByAccountNumber(accountNumber));
    }
    @GetMapping("number/{loanNumber}")
    public ResponseEntity<LoanDto> getLoanByNumber(@PathVariable(name = "loanNumber") Long accountNumber) {
        return ResponseEntity.ok(loanService.
                getLoanByLoanNumber(accountNumber));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> getLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanDto> updateLoan(@PathVariable Long id, @RequestBody UpdateLoanRequest request) {
        return ResponseEntity.ok(loanService.updateLoanInformation(id, request));
    }
}
