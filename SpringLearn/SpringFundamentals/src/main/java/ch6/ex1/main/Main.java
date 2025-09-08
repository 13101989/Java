package ch6.ex1.main;

import ch6.ex1.config.ProjectConfig;
import ch6.ex1.model.Comment;
import ch6.ex1.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Valentin");

        s.publishComment(comment);
    }
}
