package org.example.bulletinboard.service;

import org.example.bulletinboard.DTO.FilterDTO;
import org.example.bulletinboard.model.Post;
import org.example.bulletinboard.repos.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;

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
        // 여기서 filterDTO.getPage는 1-based이므로
        Pageable pageable = PageRequest.of(filterDTO.getPage()-1, 10, Sort.by("createTime"));
        return postRepository.findByFilter(filterDTO.getTitle(), filterDTO.getContent(), filterDTO.getWriter(), pageable);
    }

    public long countByFilter(FilterDTO filterDTO) {
        return postRepository.countByFilter(filterDTO.getTitle(), filterDTO.getContent(), filterDTO.getWriter());
    }

    public List<Integer> getPaginationRange(FilterDTO filterDTO) {
        int currentPage = filterDTO.getPage();
        int maxPage = (int)(countByFilter(filterDTO)+9)/10; // +9를 한 이유는 나머지 올림때문에
        List<Integer> range = new ArrayList<>();

        range.add(1); // 1페이지로 바로
        if (currentPage/2 > 1) // 1과 현재페이지의 중간
            range.add(currentPage/2);

        for (int i = currentPage - 1; i <= currentPage + 3; i++) { // 현재 페이지 기준 -2 +2
            if (range.contains(i)) continue;
            if (!(1 <= i && i <= maxPage)) continue;
            range.add(i);
        }

        if ((currentPage+maxPage)/2 > 1 && !range.contains((currentPage+maxPage)/2)) // 현재 페이지와 최대 페이지의 중간
            range.add((currentPage+maxPage)/2);
        if (maxPage != 0 && !range.contains(maxPage) && currentPage != maxPage) // 최대 페이지
            range.add(maxPage);
        return range;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(String id) {
        postRepository.deleteById(id);
    }
}
