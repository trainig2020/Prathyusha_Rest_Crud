package org.prathyusha.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.prathyusha.messenger.model.Message;
import org.prathyusha.messenger.model.Profile;

public class DataBaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
