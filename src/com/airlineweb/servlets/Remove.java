package com.airlineweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.repository.ProductStorage;
import com.airlineweb.view.Message;

@WebServlet("/remove")
public class Remove extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private Message message = Message.DELETED;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String model = request.getParameter("model");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		storage.remove(model, capacity);
		request.setAttribute("deleted", message.getValue());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/dashboard");
		requestDispatcher.forward(request, response);
	}
}
