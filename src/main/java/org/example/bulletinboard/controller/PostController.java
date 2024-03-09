package org.example.bulletinboard.controller;

import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.service.AccountSessionService;
import org.example.bulletinboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class PostController {
    private final PostService postService;
    private final AccountSessionService accountSessionService;
    PostController(PostService postService, AccountSessionService accountSessionService) {
        this.postService = postService;
        this.accountSessionService = accountSessionService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/postWrite")
    public String writePost(Model model) {
        String currentAccountId = accountSessionService.getCurrentAccountSession().getId();
        Post post = new Post();
        post.setWriter(currentAccountId);
        model.addAttribute("post", post);
        return "postWrite";
    }

    @GetMapping("/postWrite/{postId}")
    public String writePost(@PathVariable String postId, Model model) {
        Post findPost = postService.findById(postId).orElse(null);
        if (findPost == null) return "index";
        model.addAttribute("post", findPost);
        return "postWrite";
    }

    @PostMapping("/postWrite")
    public String submitWritePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/" + post.getId();
    }

    @GetMapping("/{id}")
    public String readContent(@PathVariable String id, Model model) {
        Post findPost = postService.findById(id).orElse(null);
        if (findPost == null) return "index";
        model.addAttribute("post", findPost);
        return "read";
    }
}
