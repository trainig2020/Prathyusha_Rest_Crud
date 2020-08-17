package org.prathyusha.messenger.service;

import java.util.List;

import org.prathyusha.messenger.dao.MessageDao;
import org.prathyusha.messenger.dao.MessageDaoImpl;
import org.prathyusha.messenger.model.Message;

public class MessageService {

	private MessageDaoImpl messageDao = new MessageDao();

	public List<Message> getAllMessages() {

		return messageDao.getAllMessage();

	}

	public Message getMessages(long id) {
		return messageDao.getMessageById(id);
	}

	public Message addMessage(Message message) {
		return messageDao.insertMessage(message);
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		return messageDao.updateMessage(message);
	}

	public void removeMessage(long id) {
		messageDao.deleteMessage(id);
	}

}
