package com.airlineweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.airlineweb.message.Message;
import com.airlineweb.repository.PlaneStorage;



@WebServlet("/remove")
public class Remove extends HttpServlet {

	private final static Logger logger = Logger.getLogger(Home.class);
	
	private static final long serialVersionUID = 1L;
	private PlaneStorage storage = PlaneStorage.getInstance();
	private static final String DASHBOARD_PAGE_URL = "/dashboard.jsp";
	private static final String DELETED = "deleted";
	private static final String MODEL = "model";
	private static final String CAPACITY = "capacity";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		logger.debug("POST request was recieved from " + request.getRemoteAddr());

		String model = request.getParameter(MODEL);
		int capacity = Integer.parseInt(request.getParameter(CAPACITY));
		storage.remove(model, capacity);
		
		request.setAttribute(DELETED, Message.DELETED.getValue());
		
		logger.debug("The attribute " + DELETED + " was specified with value - "
				+ Message.DELETED.getValue());
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(DASHBOARD_PAGE_URL);
		requestDispatcher.forward(request, response);
		
		logger.debug("Sent redirect to the " + DASHBOARD_PAGE_URL);
	}
}
