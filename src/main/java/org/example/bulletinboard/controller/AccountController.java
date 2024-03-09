package org.example.bulletinboard.controller;

import org.example.bulletinboard.model.Account;
import org.example.bulletinboard.service.AccountService;
import org.example.bulletinboard.service.AccountSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AccountController {
    private final AccountService accountService;
    private final AccountSessionService accountSessionService;
    @Autowired
    AccountController(AccountService accountService, AccountSessionService accountSessionService) {
        this.accountService = accountService;
        this.accountSessionService = accountSessionService;
    }

    @GetMapping("")
        public String loginMain() {
        Account currentAccount = accountSessionService.getCurrentAccountSession();
        return currentAccount == null ? "login" : "redirect:/";
    }

    @PostMapping("")
    public String login(@ModelAttribute Account account) {
        boolean result = accountService.login(account);
        if (!result) return "redirect:/login";
        accountSessionService.setAccountSession(account);
        return "redirect:/";
    }
}
