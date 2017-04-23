package com.airlineweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.models.Plane;
import com.airlineweb.repository.ProductStorage;
import com.airlineweb.utils.InputCheker;

@WebServlet("/add")
public class Add extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private String addPageUrl = "/add.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(addPageUrl);
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		try {
			String model = request.getParameter("model");
			Integer capacity = Integer.parseInt(request.getParameter("capacity"));
			String builtDate = request.getParameter("date");
			Plane newPlane = new Plane(model, capacity, builtDate);

			if (InputCheker.approve(model, capacity, builtDate)) {
				storage.add(newPlane);
				request.setAttribute("successfully", "successfully added");
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("error", "error");
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
				requestDispatcher.forward(request, response);
			}
		} catch (IllegalArgumentException e) {
			request.setAttribute("error", "error");
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
			requestDispatcher.forward(request, response);
		}

	}
}
