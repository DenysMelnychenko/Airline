package com.airlineweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
	private  ProductStorage storage = ProductStorage.getInstance();

	public Add() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String indexPage = "add.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(indexPage);
		rd.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String model = request.getParameter("model");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int date = Integer.parseInt(request.getParameter("date"));
		Plane plane = new Plane(model, capacity, date);
		storage.add(plane);
		out.append(plane.getName() + " was added!");
	}

}
