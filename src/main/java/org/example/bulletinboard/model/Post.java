package org.example.bulletinboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_generator")
    @SequenceGenerator(name="post_seq_generator", sequenceName = "post_SEQ", allocationSize = 1)
    private Long id;
    @Size(min = 1, message = "제목을 입력해주세요.")
    private String title;
    @Size(min = 1, message = "내용을 입력해주세요.")
    private String content;
    private String writer;
    @CreatedDate
    private Timestamp createTime;
    @LastModifiedDate
    private Timestamp updateTime;
}
