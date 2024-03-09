package org.example.bulletinboard.restController;

import org.example.bulletinboard.model.Account;
import org.example.bulletinboard.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.PackedColorModel;

@RestController
@RequestMapping("/sys/login")
public class AccountRestController extends GenericRestController {
    private final AccountService accountService;

    @Autowired
    AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/validate")
    public ResponseEntity login(@ModelAttribute Account account) {
        return response(accountService.login(account));
    }

    @PostMapping("/")
    public ResponseEntity save(@ModelAttribute Account account) {
        return response(accountService.save(account));
    }
}
