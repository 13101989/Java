package ch4.ex2.proxies;

import ch4.ex2.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
