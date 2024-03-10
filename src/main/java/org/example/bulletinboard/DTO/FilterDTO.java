package org.example.bulletinboard.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDTO {
    private String title;
    private String content;
    private String writer;
    private int page;
}
