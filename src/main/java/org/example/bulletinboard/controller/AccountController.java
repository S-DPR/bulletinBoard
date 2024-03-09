package org.example.bulletinboard.controller;

import jakarta.servlet.http.HttpSession;
import org.example.bulletinboard.model.Account;
import org.example.bulletinboard.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public String loginMain() {
        return "login";
    }

    @PostMapping("/validate")
    public String login(@ModelAttribute Account account, HttpSession session) {
        boolean result = accountService.login(account);
        if (!result) return "redirect:/login";
        session.setAttribute("login", account);
        return "redirect:/";
    }
}
