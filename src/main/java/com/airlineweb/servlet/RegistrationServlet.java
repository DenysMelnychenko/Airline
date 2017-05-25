package com.airlineweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.airlineweb.model.User;
import com.airlineweb.repository.UserStorage;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private final static Logger logger = Logger.getLogger(RegistrationServlet.class);

	private static final long serialVersionUID = 1L;
	private UserStorage storage = UserStorage.getInstance();
	private static final String REGISTRATION_FORM = "/registrationForm.jsp";
	private static final String HOME_PAGE_URL = "/index.jsp";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("GET request was recieved from " + request.getRemoteAddr());

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_FORM);
		requestDispatcher.forward(request, response);

		logger.debug("Sent redirect to the " + REGISTRATION_FORM);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		
		User user = new User(email, password);
		storage.add(user);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(HOME_PAGE_URL);
		requestDispatcher.forward(request, response);
		
		logger.debug("Sent redirect to the " + HOME_PAGE_URL);
	}

}
