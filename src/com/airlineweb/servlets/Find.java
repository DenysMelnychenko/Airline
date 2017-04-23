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

@WebServlet("/find")
public class Find extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private String dashboardPageUrl = "/dashboard.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter("search");

		Map<Integer, Plane> planes = storage.SearchByModel(name);
		if (planes.isEmpty()) {
			request.setAttribute("error", "error");
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(dashboardPageUrl);
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("planes", planes);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(dashboardPageUrl);
			requestDispatcher.forward(request, response);
		}
	}
}
