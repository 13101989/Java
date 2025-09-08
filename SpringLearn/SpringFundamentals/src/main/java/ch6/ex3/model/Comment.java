package ch6.ex3.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private String text;
    private String author;

    @Override
    public String toString() {
        return "Comment{text=" + text + ", author=" + author + "}";
    }
}
