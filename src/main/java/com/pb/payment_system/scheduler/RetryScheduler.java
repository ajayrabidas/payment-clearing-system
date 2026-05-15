package com.pb.payment_system.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RetryScheduler {

    @Scheduled(fixedRate = 300000)
    public void retryFailedTransactions() {
        System.out.println("Retrying failed transactions. . . ");
    }
}
