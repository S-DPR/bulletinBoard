package org.example.bulletinboard.restController;

import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/post")
public class PostRestController extends GenericRestController {
    private final PostService postService;

    PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ResponseEntity getAllPost() {
        return response(postService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity createPost(@RequestBody Post post) {
        return response(postService.save(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable String id) {
        postService.delete(id);
        return response("200");
    }
}
