package org.example.bulletinboard.Model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Post {
    private String title;
    private String content;
    private Timestamp createTime;
    private Timestamp editTime;
}
