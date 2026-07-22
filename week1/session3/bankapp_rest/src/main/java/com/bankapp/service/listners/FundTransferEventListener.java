package com.bankapp.service.listners;

import com.bankapp.events.FundTransferredEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class FundTransferEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void auditBeforeCommit(FundTransferredEvent event) {
        System.out.println("-----------------------------------------------");
        System.out.println("Audit before commit: " + event);
    }
}
