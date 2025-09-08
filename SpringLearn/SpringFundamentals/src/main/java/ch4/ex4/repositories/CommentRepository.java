package ch4.ex4.repositories;

import ch4.ex4.model.Comment;


public interface CommentRepository {

    void storeComment(Comment comment);
}
