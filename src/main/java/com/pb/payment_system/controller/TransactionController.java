package com.pb.payment_system.controller;

import com.pb.payment_system.entity.TransactionEntity;
import com.pb.payment_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionEntity> create(@RequestBody TransactionEntity transactionEntity) {
        return ResponseEntity.ok(transactionService.createTransaction(transactionEntity));
    }

    @GetMapping("/{txnId}")
    public ResponseEntity<TransactionEntity> get(@PathVariable String txnId) {
        return ResponseEntity.ok(transactionService.getTransactionEntity(txnId));
    }

}
