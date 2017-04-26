package com.airlineweb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.models.Plane;
import com.airlineweb.repository.ProductStorage;
import com.airlineweb.utils.InputCheker;
import com.airlineweb.view.Message;

@WebServlet("/add")
public class Add extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();
	private String addPageUrl = "/add.jsp";
	private Message addMessage = Message.PLANE_WAS_SUCCESSFULLY_ADDED;
	private Message wrongInputMessage = Message.WRONG_INPUT;

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
			Date builtdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));

			Plane newPlane = new Plane(model, capacity, builtdate);

			if (InputCheker.approved(model, capacity, builtdate)) {
				storage.add(newPlane);
				request.setAttribute("added", addMessage.getValue());
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("wrong input", wrongInputMessage.getValue());
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
				requestDispatcher.forward(request, response);
			}
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrong input", wrongInputMessage.getValue());
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
			requestDispatcher.forward(request, response);
		} catch (ParseException e) {
			request.setAttribute("wrong input", wrongInputMessage.getValue());
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(addPageUrl);
			requestDispatcher.forward(request, response);
		}

	}
}
