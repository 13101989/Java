package ch5.ex6.main;

import ch5.ex6.config.ProjectConfiguration;
import ch5.ex6.services.CommentService;
import ch5.ex6.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var cs1 = context.getBean(CommentService.class);
        var cs2 = context.getBean(UserService.class);

        boolean b1 = cs1.getCommentRepository() == cs2.getCommentRepository();

        System.out.println(b1);

    }
}
