package com.fraudDetection.Transaction.Controller;

import com.fraudDetection.Transaction.Entity.TransactionDB;
import com.fraudDetection.Transaction.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService ts) {
        this.transactionService = ts;
    }

    @GetMapping("/")
    public List<TransactionDB> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionDB getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/")
    public TransactionDB addTransaction(@RequestBody TransactionDB transaction) {
        return transactionService.addTransaction(transaction);
    }

    @PutMapping("/{id}")
    public TransactionDB updateTransaction(@PathVariable Long id, @RequestBody TransactionDB transactionDB) {
        return transactionService.updateTransaction(id,transactionDB);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}