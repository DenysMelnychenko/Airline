package com.airlineweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.airlineweb.model.User;

public class UserStorage {

	private final static Logger logger = Logger.getLogger(UserStorage.class);
	private static volatile UserStorage instance;
	private List<User> storage = new ArrayList<>();

	private UserStorage() {
	}

	public static UserStorage getInstance() {
		if (instance == null) {
			synchronized (UserStorage.class) {
				if (instance == null) {
					instance = new UserStorage();
				}
			}
		}
		return instance;
	}

	public void add(User user) {
		storage.add(user);
		logger.info("User " + user.getUserName() + " was added to storage");
	}

	public boolean remove(String userName) {
		for (User user : storage) {
			if (user.getUserName().equals(userName)) {
				storage.remove(user);
				logger.info("User " + user.getUserName() + " was deleted from storage");
				return true;
			}
		}
		return false;

	}

	public List<User> SearchByModel(String searchedName) {
		List<User> result = new ArrayList<>();
		for (User user : storage) {
			String userName = user.getUserName();
			if (userName.equals(searchedName)) {
				result.add(user);
			}
		}
		return result;
	}

	public List<User> getAll() {
		return storage;
	}
}
