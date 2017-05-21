package com.airlineweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/home")
public class Home extends HttpServlet {
	
	private final static Logger logger = Logger.getLogger(Home.class);
	
	private static final long serialVersionUID = 1L;
	private static final String HOME_PAGE_URL = "/index.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.debug("GET request was recieved from " + request.getRemoteAddr());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(HOME_PAGE_URL);
		requestDispatcher.forward(request, response);
		
		logger.debug("Sent redirect to the " + HOME_PAGE_URL);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
