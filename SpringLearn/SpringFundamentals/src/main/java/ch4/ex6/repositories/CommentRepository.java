package ch4.ex6.repositories;

import ch4.ex6.model.Comment;


public interface CommentRepository {

    void storeComment(Comment comment);
}
