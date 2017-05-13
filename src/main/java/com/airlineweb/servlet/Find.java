package com.airlineweb.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.message.Message;
import com.airlineweb.model.Plane;
import com.airlineweb.repository.Storage;

@WebServlet("/find")
public class Find extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Storage storage = Storage.getInstance();
	private static final String DASHBOARD_PAGE_URL = "/dashboard.jsp";
	private static final String SEARCH = "search";
	private static final String NOT_FOUND = "notfound";
	private static final String PLANES = "planes";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter(SEARCH);
		if (!name.equals(null)) {
			Map<Integer, Plane> planes = storage.SearchByModel(name);

			if (planes.isEmpty()) {
				request.setAttribute(NOT_FOUND, Message.THE_AIRCRAFT_WAS_NOT_FOUND.getValue());

			} else {

				request.setAttribute(PLANES, planes);
			}
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(DASHBOARD_PAGE_URL);
		requestDispatcher.forward(request, response);
	}
}
