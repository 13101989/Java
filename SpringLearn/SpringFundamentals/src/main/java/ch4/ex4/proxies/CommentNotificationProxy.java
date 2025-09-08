package ch4.ex4.proxies;

import ch4.ex4.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
