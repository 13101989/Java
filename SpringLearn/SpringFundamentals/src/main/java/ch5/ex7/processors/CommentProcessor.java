package ch5.ex7.processors;

import ch5.ex7.model.Comment;
import ch5.ex7.repositories.CommentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

    @Autowired
    private CommentRepository commentRepository;

    private Comment comment;

    public void processComment() {
        // changing the comment attribute
    }

    public void validateComment() {
        // validating and changing the comment attribute
    }
}
