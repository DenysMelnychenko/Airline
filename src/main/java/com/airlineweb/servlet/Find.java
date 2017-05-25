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
import com.airlineweb.repository.PlaneStorage;

@WebServlet("/find")
public class Find extends HttpServlet {

	private final static Logger logger = Logger.getLogger(Find.class);

	private static final long serialVersionUID = 1L;
	private PlaneStorage storage = PlaneStorage.getInstance();
	private static final String DASHBOARD_PAGE_URL = "/dashboard.jsp";
	private static final String SEARCH = "search";
	private static final String NOT_FOUND = "notfound";
	private static final String PLANES = "planes";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		logger.debug("POST request was recieved from " + request.getRemoteAddr());

		String name = request.getParameter(SEARCH);

		if (!name.equals(null)) {

			logger.debug("Searching appropriate planes");

			Map<Integer, Plane> planes = storage.SearchByModel(name);

			if (planes.isEmpty()) {

				logger.debug("Approropriate planes not found");

				request.setAttribute(NOT_FOUND, Message.THE_AIRCRAFT_WAS_NOT_FOUND.getValue());

				logger.debug("The attribute " + NOT_FOUND + " was specified with value - "
						+ Message.THE_AIRCRAFT_WAS_NOT_FOUND.getValue());

			} else {

				request.setAttribute(PLANES, planes);

				logger.debug("Returned found planes");
			}
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(DASHBOARD_PAGE_URL);
		requestDispatcher.forward(request, response);

		logger.debug("Sent redirect to the " + DASHBOARD_PAGE_URL);
	}
}
