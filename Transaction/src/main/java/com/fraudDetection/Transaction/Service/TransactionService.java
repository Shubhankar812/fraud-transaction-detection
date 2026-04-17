package com.fraudDetection.Transaction.Service;

import com.fraudDetection.Transaction.Entity.TransactionDB;
import com.fraudDetection.Transaction.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository tr) {
        this.transactionRepository = tr;
    }

    public List<TransactionDB> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionDB getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public TransactionDB addTransaction(TransactionDB transactionDB) {
        return transactionRepository.save(transactionDB);
    }

    public TransactionDB updateTransaction(Long transactionId, TransactionDB updatedTransaction) {

        TransactionDB existingTransactionDB = transactionRepository.findById(transactionId)
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found with id: " + transactionId));

        existingTransactionDB.setFromAccountId(updatedTransaction.getFromAccountId());
        existingTransactionDB.setToAccountId(updatedTransaction.getToAccountId());
        existingTransactionDB.setAmount(updatedTransaction.getAmount());
        existingTransactionDB.setTransactionType(updatedTransaction.getTransactionType());
        existingTransactionDB.setStatus(updatedTransaction.getStatus());
        existingTransactionDB.setTransactionTime(updatedTransaction.getTransactionTime());

        return transactionRepository.save(existingTransactionDB);
    }

    public void deleteTransaction(Long id) {
        TransactionDB transactionDB = transactionRepository.findById(id).orElse(null);

        transactionRepository.delete(transactionDB);
    }
}
