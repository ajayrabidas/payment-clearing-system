package com.pb.payment_system.service;

import com.pb.payment_system.entity.TransactionEntity;
import com.pb.payment_system.producer.KafkaProducerService;
import com.pb.payment_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public TransactionEntity createTransaction(TransactionEntity transactionEntity) {
        transactionEntity.setStatus("PROCESSING");

        TransactionEntity savedTransactionEntity = transactionRepository.save(transactionEntity);
        kafkaProducerService.publish(savedTransactionEntity.getTxnId());
        return savedTransactionEntity;
    }

    public TransactionEntity getTransactionEntity(String txnId) {
        return transactionRepository.findByTxnId(txnId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
