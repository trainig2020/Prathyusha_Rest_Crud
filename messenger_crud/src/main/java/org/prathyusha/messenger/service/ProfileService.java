package org.prathyusha.messenger.service;

import java.util.List;

import org.prathyusha.messenger.dao.ProfileDao;
import org.prathyusha.messenger.model.Profile;

public class ProfileService {
	private ProfileDao profileDao = new ProfileDao();

	public List<Profile> getAllProfile() {

		return profileDao.getAllProfile();

	}

	public Profile getProfile(String profileName) {
		return profileDao.getProfile(profileName);
	}

	public Profile addProfile(Profile profile) {

		return profileDao.insertProfile(profile);
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		return profileDao.updateProfile(profile);
	}

	public void removeProfile(String profileName) {
		profileDao.deleteProfile(profileName);
	}

}
