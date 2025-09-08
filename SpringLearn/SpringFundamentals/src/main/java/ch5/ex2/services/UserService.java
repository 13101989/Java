package ch5.ex2.services;

import ch5.ex2.repositories.CommentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Service
public class UserService {

    @Autowired
    private CommentRepository commentRepository;
}
