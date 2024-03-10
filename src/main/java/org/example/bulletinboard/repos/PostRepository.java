package org.example.bulletinboard.repos;

import org.example.bulletinboard.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    @Query("SELECT p FROM Post p " +
            "WHERE (:title IS NULL OR p.title LIKE %:title%) " +
            "AND (:content IS NULL OR p.content LIKE %:content%) " +
            "AND (:writer IS NULL OR p.writer = :writer)")
    Page<Post> findByFilter(@Param("title") String title,
                            @Param("content") String content,
                            @Param("writer") String writer,
                            Pageable pageable);

    @Query("SELECT COUNT(p) FROM Post p " +
            "WHERE (:title IS NULL OR p.title LIKE %:title%) " +
            "AND (:content IS NULL OR p.content LIKE %:content%) " +
            "AND (:writer IS NULL OR p.writer = :writer)")
    long countByFilter(@Param("title") String title,
                            @Param("content") String content,
                            @Param("writer") String writer);
}

