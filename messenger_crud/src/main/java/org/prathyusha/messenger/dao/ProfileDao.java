package org.prathyusha.messenger.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.prathyusha.messenger.connection.Connection;
import org.prathyusha.messenger.model.Profile;

public class ProfileDao {
	
	@SuppressWarnings("unchecked")
	public List<Profile> getAllProfile() {

		Session session = Connection.getSession();
		session.beginTransaction();

		List<Profile> listOfProfile = session.createQuery("from Profile").list();

		System.out.println("All details of Profiles are displayed");

		return listOfProfile;

	}
	
	public Profile insertProfile(Profile profile) {

		Transaction transaction = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			session.save(profile);
			System.out.println("Data Inserted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return profile;

	}
	
	public Profile updateProfile(Profile profile) {

		Transaction transaction = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			session.update(profile);
			System.out.println("Data Updated");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return profile;

	}
	
	
	public void deleteProfile(String profileName) {

		Transaction transaction = null;
		Profile profile = null;

		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			profile = (Profile) session.get(Profile.class, profileName);
			session.delete(profile);
			System.out.println("Data Deleted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		

	}
	
	
	public Profile getProfile(String profileName) {

		Transaction transaction = null;
		Profile profile = null;
		try {
			Session session = Connection.getSession();

			transaction = session.beginTransaction();
			profile = (Profile) session.get(Profile.class, profileName);
			System.out.println("Datas Deleted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return profile;
		

	}

}
