package org.example.bulletinboard.DTO;

import lombok.Setter;

@Setter
public class FilterDTO {
    private String title;
    private String content;
    private String writer;
    private Integer page;

    public int getPage() {
        if (page == null)
            return 1;
        return page;
    }

    public String getTitle() {
        if (title == null || title.isEmpty())
            return null;
        return title;
    }

    public String getContent() {
        if (content == null || content.isEmpty())
            return null;
        return content;
    }

    public String getWriter() {
        if (writer == null || writer.isEmpty())
            return null;
        return writer;
    }
}
