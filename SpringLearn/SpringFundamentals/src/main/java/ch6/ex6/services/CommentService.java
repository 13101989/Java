package ch6.ex6.services;

import ch6.ex6.annotations.ToLog;
import ch6.ex6.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {

        logger.info("Publishing comment: " + comment.getText());

        return "SUCCESS";
    }
}
