package com.fraudDetection.Account.Service;

import com.fraudDetection.Account.Entity.Account;
import com.fraudDetection.Account.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    public AccountService(AccountRepository ar) {
        this.accountRepository = ar;
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteById(Long id) {
        Account acc = accountRepository.findById(id).orElse(null);
        if(acc != null) {
            accountRepository.delete(acc);
        }

    }
    public Account updateAccount(Long accountId, Account updatedAccount) {

        Account existingAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));

        existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
        existingAccount.setAccountHolderName(updatedAccount.getAccountHolderName());
        existingAccount.setBalance(updatedAccount.getBalance());
        existingAccount.setAccountType(updatedAccount.getAccountType());

        return accountRepository.save(existingAccount);
    }
}
