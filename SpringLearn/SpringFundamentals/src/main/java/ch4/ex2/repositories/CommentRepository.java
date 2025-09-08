package ch4.ex2.repositories;

import ch4.ex2.model.Comment;


public interface CommentRepository {

    void storeComment(Comment comment);
}
