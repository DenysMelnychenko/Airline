package com.airlineweb.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.airlineweb.message.Message;
import com.airlineweb.model.Plane;
import com.airlineweb.repository.Storage;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

	private final static Logger logger = Logger.getLogger(Dashboard.class);

	private static final long serialVersionUID = 1L;
	private Storage storage = Storage.getInstance();
	private static final String DASHBOARD_PAGE_URL = "/dashboard.jsp";
	private static final String IS_EMPTY = "isempty";
	private static final String PLANES = "planes";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		logger.debug("GET request was recieved from " + request.getRemoteAddr());

		Map<Integer, Plane> planes = storage.getAll();
		if (planes.isEmpty()) {

			logger.debug("Storage is empty");

			request.setAttribute(IS_EMPTY, Message.AIRCRAFT_STORAGE_IS_EMPTY.getValue());

			logger.debug("The attribute " + IS_EMPTY + " was specified with value - "
					+ Message.AIRCRAFT_STORAGE_IS_EMPTY.getValue());

		} else {

			logger.debug("Storage is not empty");

			request.setAttribute(PLANES, planes);

			logger.debug("Returned planes");

		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(DASHBOARD_PAGE_URL);
		requestDispatcher.forward(request, response);

		logger.debug("Sent redirect to the " + DASHBOARD_PAGE_URL);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
