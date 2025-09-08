package ch4.ex6.proxies;

import ch4.ex6.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
