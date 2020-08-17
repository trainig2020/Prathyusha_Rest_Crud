package org.prathyusha.messenger.service;

import java.util.List;

import org.prathyusha.messenger.dao.CommentDao;
import org.prathyusha.messenger.dao.CommentDaoImpl;
import org.prathyusha.messenger.model.Comment;

public class CommentService {
	private CommentDaoImpl commentDao = new CommentDao();

	public List<Comment> getAllComment(long msgId) {

		return commentDao.getAllComment(msgId);

	}

	public Comment getComment(long msgId, long id) {
		return commentDao.getCommentById(msgId, id);
	}

	public Comment addComment(long msgId, Comment comment) {
		return commentDao.insertComment(msgId, comment);
	}

	public Comment updateComment(long msgId, Comment comment) {
		if (comment.getId() <= 0) {
			return null;
		}
		return commentDao.updateComment(msgId, comment);
	}

	public void removeComment(long msgId, long id) {
		commentDao.deleteComment(msgId, id);
	}

}