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

@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String indexPage = "dashboard.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(indexPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		try {
			Plane food = storage.getByName(name);
			out.append("Item name " + food.getName() + " Color is " + food.getCapacity() + " Cost is " + food.getBuiltDate());
		} catch (NullPointerException e) {
			out.append(name + " not found ");
		}
	}
}
