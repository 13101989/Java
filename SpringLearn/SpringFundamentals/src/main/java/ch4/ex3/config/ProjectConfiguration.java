package ch4.ex3.config;

import ch4.ex3.proxies.CommentNotificationProxy;
import ch4.ex3.proxies.EmailCommentNotificationProxy;
import ch4.ex3.repositories.CommentRepository;
import ch4.ex3.repositories.DBCommentRepository;
import ch4.ex3.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfiguration {

    @Bean
    public CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentService commentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(commentRepository, commentNotificationProxy);
    }
}
