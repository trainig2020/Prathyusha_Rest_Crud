package org.prathyusha.messenger.dao;

import java.util.List;

import org.prathyusha.messenger.model.Comment;

public interface CommentDaoImpl {

	List<Comment> getAllComment(long msgId);

	Comment insertComment(long msgId, Comment cmt);

	Comment updateComment(long msgId, Comment cmt);

	void deleteComment(long msgId, long id);

	Comment getCommentById(long msgId, long id);

}