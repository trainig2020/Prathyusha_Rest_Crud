package org.prathyusha.messenger.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.prathyusha.messenger.connection.Connection;
import org.prathyusha.messenger.model.Message;

public class MessageDao implements MessageDaoImpl {

	@Override
	@SuppressWarnings("unchecked")
	public List<Message> getAllMessage() {

		Session session = Connection.getSession();
		session.beginTransaction();

		List<Message> listOfMsg = session.createQuery("from Message").list();

		System.out.println("All details of Messages are displayed");

		return listOfMsg;

	}

	@Override
	public Message insertMessage(Message message) {

		Transaction transaction = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			session.save(message);
			System.out.println("Data Inserted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return message;

	}

	@Override
	public Message updateMessage(Message message) {

		Transaction transaction = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			session.update(message);
			System.out.println("Data Updated");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return message;

	}

	@Override
	public void deleteMessage(long id) {

		Transaction transaction = null;
		Message message = null;

		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			message = (Message) session.get(Message.class, id);
			session.delete(message);
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
	public Message getMessageById(long id) {

		Transaction transaction = null;
		Message message = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			message = (Message) session.get(Message.class, id);
			System.out.println("Data Deleted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return message;

	}

}
