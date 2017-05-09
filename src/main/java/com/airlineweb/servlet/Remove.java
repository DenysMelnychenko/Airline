package com.airlineweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.message.Message;
import com.airlineweb.repository.ProductStorage;



@WebServlet("/remove")
public class Remove extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private static final String DASHBOARD_PAGE_URL = "/dashboard.jsp";
	private static final String DELETED = "deleted";
	private static final String MODEL = "model";
	private static final String CAPACITY = "capacity";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String model = request.getParameter(MODEL);
		int capacity = Integer.parseInt(request.getParameter(CAPACITY));
		storage.remove(model, capacity);
		
		request.setAttribute(DELETED, Message.DELETED.getValue());
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(DASHBOARD_PAGE_URL);
		requestDispatcher.forward(request, response);
	}
}
