package org.example.bulletinboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostListController {
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
