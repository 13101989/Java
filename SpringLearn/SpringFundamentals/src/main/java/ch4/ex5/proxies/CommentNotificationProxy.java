package ch4.ex5.proxies;

import ch4.ex5.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
