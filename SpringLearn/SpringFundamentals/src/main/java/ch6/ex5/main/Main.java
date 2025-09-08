package ch6.ex5.main;

import ch6.ex5.config.ProjectConfig;
import ch6.ex5.model.Comment;
import ch6.ex5.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Valentin");

        s.publishComment(comment);
        s.editComment(comment);
        s.deleteComment(comment);

    }
}
