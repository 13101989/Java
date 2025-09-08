package ch4.ex3.proxies;

import ch4.ex3.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
