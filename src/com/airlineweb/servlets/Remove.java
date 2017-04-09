package com.airlineweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.repository.ProductStorage;

@WebServlet("/remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String model = request.getParameter("model");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		boolean removed = storage.remove(model, capacity);
		if(removed) {
			out.append("Product was remowed");
		} else
			out.append(model + " is not in list!");
		
	}

}
