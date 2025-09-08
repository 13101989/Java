package ch4.ex3.repositories;

import ch4.ex3.model.Comment;


public interface CommentRepository {

    void storeComment(Comment comment);
}
