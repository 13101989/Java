package ch4.ex1.main;

import ch4.ex1.config.ProjectConfiguration;
import ch4.ex1.model.Comment;
import ch4.ex1.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

//        var commentRepository = new DBCommentRepository();
//        var commentNotificationProxy = new EmailCommentNotificationProxy();

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Valentin");
        comment.setText("a comment");

//        var commentService = new CommentService(commentRepository, commentNotificationProxy);
//        commentService.publishComment(comment);

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
