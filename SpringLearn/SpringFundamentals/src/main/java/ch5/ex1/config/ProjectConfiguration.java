package ch5.ex1.config;

import ch5.ex1.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfiguration {

    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
