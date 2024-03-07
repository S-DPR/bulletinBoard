package org.example.bulletinboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private Timestamp createTime;
    private Timestamp editTime;
}
