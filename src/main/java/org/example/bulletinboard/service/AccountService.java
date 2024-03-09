package org.example.bulletinboard.service;

import org.example.bulletinboard.model.Account;
import org.example.bulletinboard.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public boolean login(Account account) {
        return accountRepository.findById(account.getId())
                .map(findAccount -> findAccount.getPw().equals(account.getPw()))
                .orElseGet(() -> {
                    save(account); // 빠른 기능 구현을 위해 회원가입 기능 일단은 제외
                    return true;
                });
    }
}
