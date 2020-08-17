package org.prathyusha.messenger.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.prathyusha.messenger.connection.Connection;
import org.prathyusha.messenger.model.Comment;

public class CommentDao implements CommentDaoImpl {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getAllComment(long msgId) {

		Session session = Connection.getSession();
		session.beginTransaction();
		List<Comment> list =  session.createQuery("from Comment where messageId=" + msgId).list();

		System.out.println("All details of Comments are displayed");

		return list;

	}

	@Override
	public Comment insertComment(long msgId, Comment comment) {

		Transaction transaction = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			List<Comment> lst =  session.createQuery("from Comment where messageId=" + msgId).list();
			session.save(comment);
			System.out.println("Data Inserted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return comment;

	}
	
	@Override
	public Comment updateComment(long msgId,Comment comment) {

		Transaction transaction = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			List<Comment> lst =  session.createQuery("from Comment where messageId=" + msgId).list();
			session.update(comment);
			System.out.println("Data Updated");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return comment;

	}
	
	
	@Override
	public void deleteComment(long msgId,long id) {

		Transaction transaction = null;
		Comment comment = null;

		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			comment = (Comment) session.get(Comment.class, id);
			List<Comment> lst =  session.createQuery("from Comment where messageId=" + msgId).list();
			session.delete(comment);
			System.out.println("Data Deleted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		

	}
	
	
	@Override
	public Comment getCommentById(long msgId,long id) {

		Transaction transaction = null;
		Comment comment = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			comment = (Comment) session.get(Comment.class, id);
			List<Comment> lst =  session.createQuery("from Comment where messageId=" + msgId).list();
			System.out.println("Datas Deleted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return comment;
		

	}
	

}