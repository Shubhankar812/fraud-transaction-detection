package com.fraudDetection.Account.Controller;

import com.fraudDetection.Account.DTO.customerDTO;
import com.fraudDetection.Account.Entity.Account;
import com.fraudDetection.Account.Service.AccountService;
import com.fraudDetection.Account.Service.CustomerClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    private Long accId = null;

    @Autowired
    private CustomerClientImpl customerClient;

    public AccountController(AccountService service) {
        this.accountService = service;
    }

//    public AccountController(CustomerClientImpl cc) {
//        this.customerClient = cc;
//    }

    @GetMapping("/")
    public List<Account> getAccounts() {

        List<Account> account =  accountService.getAllAccount();
        accId = account.get(0).getAccountId();
        return account;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/")
    public Account addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account acc) {
        return accountService.updateAccount(id,acc);
    }

    @GetMapping("/customer/{id}")
    public customerDTO getCustomerDetails(@PathVariable Long id) {
        Long accountId = accId;
        customerDTO dto = customerClient.getCustomerWithAccount(id);

        dto.setAccountId(accountService.getAllAccount().get(0).getAccountId());

        return dto;
    }
}
