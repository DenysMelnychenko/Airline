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

@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private String addPage = "add.jsp";

	public Add() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(addPage);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String model = request.getParameter("model");
		Integer capacity = Integer.parseInt(request.getParameter("capacity"));
		String builtDate = request.getParameter("date");
		Plane newPlane = new Plane(model, capacity, builtDate);
		if (model != null && capacity != null && capacity > 0 && builtDate != null) {
			if (model != "" && builtDate != "") {
				storage.add(newPlane);
				request.setAttribute("successfully", "successfully added");
				RequestDispatcher rd = request.getRequestDispatcher(addPage);
				rd.forward(request, response);
			} else {
				request.setAttribute("error", "error");
				RequestDispatcher rd = request.getRequestDispatcher(addPage);
				rd.forward(request, response);
			}

		} else {
			request.setAttribute("error", "error");
			RequestDispatcher rd = request.getRequestDispatcher(addPage);
			rd.forward(request, response);
		}

	}
}
