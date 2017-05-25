package com.airlineweb.model;

import org.apache.log4j.Logger;

public class User {

	private final static Logger logger = Logger.getLogger(User.class);
	
	private String userName;
	private String password;

	public User(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
		
		logger.debug("New user : " + userName +" created");
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return password;
	}
}
