package org.example.bulletinboard.controller;

import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class PostController {
    private final PostService postService;
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
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
