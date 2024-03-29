package org.example.bulletinboard.controller;

import org.example.bulletinboard.DTO.FilterDTO;
import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.service.AccountSessionService;
import org.example.bulletinboard.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String mainPage(@ModelAttribute FilterDTO filterDTO, Model model) {
        Page<Post> posts = postService.findByFilter(filterDTO);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("pagination", postService.getPaginationRange(filterDTO));
        model.addAttribute("activatedFilter", filterDTO.getActivatedFilter());
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
    public String submitWritePost(@Validated @ModelAttribute Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("post", post);
            return "/postWrite";
        }
        postService.save(post);
        return "redirect:/" + post.getId();
    }

    @GetMapping("/{id}")
    public String readContent(@PathVariable String id, Model model) {
        Post findPost = postService.findById(id).orElse(null);
        if (findPost == null) return "index";
        String currentAccountId = accountSessionService.getCurrentAccountSession().getId();
        model.addAttribute("post", findPost);
        model.addAttribute("reader", currentAccountId);
        return "read";
    }
}
