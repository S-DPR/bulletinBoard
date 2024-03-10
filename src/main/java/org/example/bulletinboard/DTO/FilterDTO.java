package org.example.bulletinboard.DTO;

import lombok.Setter;

import java.util.List;

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

    public List<String> getActivatedFilter() {
        if (getTitle() != null) return List.of("title", title);
        if (getContent() != null) return List.of("content", content);
        if (getWriter() != null) return List.of("writer", writer);
        return List.of("title", "");
    }
}
