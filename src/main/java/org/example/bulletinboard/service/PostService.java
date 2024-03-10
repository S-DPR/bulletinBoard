package org.example.bulletinboard.service;

import org.example.bulletinboard.DTO.FilterDTO;
import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.repos.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(String id) {
        return postRepository.findById(id);
    }

    public Page<Post> findByFilter(FilterDTO filterDTO) {
        Pageable pageable = PageRequest.of(filterDTO.getPage(), 10, Sort.by("createTime"));
        return postRepository.findByFilter(filterDTO.getTitle(), filterDTO.getContent(), filterDTO.getWriter(), pageable);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(String id) {
        postRepository.deleteById(id);
    }
}
