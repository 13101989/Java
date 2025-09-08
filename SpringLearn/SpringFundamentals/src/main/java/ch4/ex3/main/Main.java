package ch4.ex3.main;

import ch4.ex3.config.ProjectConfiguration;
import ch4.ex3.model.Comment;
import ch4.ex3.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Valentin");
        comment.setText("a comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
