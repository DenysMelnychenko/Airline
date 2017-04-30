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
import com.airlineweb.repository.ProductStorage;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private static final String DASHBOARD_PAGE_URL = "/dashboard.jsp";
	private static final String IS_EMPTY = "Is empty";
	private static final String PLANES = "planes";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Map<Integer, Plane> planes = storage.getAll();
		if (planes.isEmpty()) {
			request.setAttribute(IS_EMPTY, Message.AIRCRAFT_STORAGE_IS_EMPTY.getValue());

		} else {
			request.setAttribute(PLANES, planes);
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(DASHBOARD_PAGE_URL);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
