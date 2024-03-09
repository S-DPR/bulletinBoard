package org.example.bulletinboard.controller;

import org.example.bulletinboard.model.User;
import org.example.bulletinboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AccountController {
    private final UserService userService;
    @Autowired
    AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String loginMain() {
        return "login";
    }

    @PostMapping("/validate")
    public String login(@ModelAttribute User user) {
        boolean result = userService.login(user);
        if (!result) return "redirect:/login";
        return "redirect:/";
    }
}
