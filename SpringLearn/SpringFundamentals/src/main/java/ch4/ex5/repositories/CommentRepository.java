package ch4.ex5.repositories;

import ch4.ex5.model.Comment;


public interface CommentRepository {

    void storeComment(Comment comment);
}
