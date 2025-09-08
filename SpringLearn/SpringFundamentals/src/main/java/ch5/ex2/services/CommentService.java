package ch5.ex2.services;


import ch5.ex2.repositories.CommentRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;


@Getter
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
