package org.example.bulletinboard.controller;

import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PostListController {
    private final PostService postService;
    PostListController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/postWrite")
    public String writePost(Model model) {
        model.addAttribute("post", new Post());
        return "postWrite";
    }

    @GetMapping("/postWrite/{id}")
    public String writePost(@PathVariable String id, Model model) {
        Post findPost = postService.findById(id).orElse(null);
        if (findPost == null) return "index";
        model.addAttribute("post", findPost);
        return "postWrite";
    }
}
