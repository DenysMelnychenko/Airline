package com.airlineweb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.airlineweb.model.User;

public class RegistrationCheker {

	private final static Logger logger = Logger.getLogger(User.class);

	public static boolean isEmailValid(String email) {

		Pattern pattern = Pattern.compile("([\\w._]){4,31}@\\w+\\.\\w{2,3}");
		Matcher matcher = pattern.matcher(email);

		logger.debug("Email was cheked");

		return matcher.matches();
	}

	public static boolean isPasswordlValid(String password) {

		Pattern pattern = Pattern.compile(".{5,25}");
		Matcher matcher = pattern.matcher(password);

		logger.debug("Password was cheked");

		return matcher.matches();
	}

	public static boolean isRepeatPasswordValid(String password, String repeatPassword) {

		Pattern pattern = Pattern.compile(".{5,25}");
		Matcher matcher = pattern.matcher(repeatPassword);

		if ((matcher.matches() == true) && repeatPassword.equals(password)) {
			return true;
		}

		logger.debug("Repeated password was cheked");

		return false;
	}
	
	public static boolean isRegistrationValid(String email, String password, String repeatPassword) {
		
		logger.debug("Registration information was checked");
		
		return isEmailValid(email) && isPasswordlValid(password) && isRepeatPasswordValid(password, repeatPassword);
	}

 public static void main(String[] args) {
	 System.out.println(isEmailValid("aspirant_89@gmail.com"));
	 
 }
}
