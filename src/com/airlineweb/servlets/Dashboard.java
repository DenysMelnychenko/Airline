package com.airlineweb.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.models.Plane;
import com.airlineweb.repository.ProductStorage;
import com.airlineweb.view.Message;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String dashboardPageUrl = "/dashboard.jsp";
	private ProductStorage storage = ProductStorage.getInstance();
	private Message message = Message.AIRCRAFT_STORAGE_IS_EMPTY;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Map<Integer, Plane> aircrafts = storage.getAll();
		if (aircrafts.isEmpty()) {
			request.setAttribute("Is empty", message.getValue());

		} else {
			request.setAttribute("planes", aircrafts);
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(dashboardPageUrl);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
