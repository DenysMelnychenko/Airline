package com.airlineweb.servlet;

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

import com.airlineweb.message.Message;
import com.airlineweb.model.Plane;
import com.airlineweb.repository.Storage;
import com.airlineweb.util.InputCheker;

@WebServlet("/add")
public class Add extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Storage storage = Storage.getInstance();
	private static final String ADD_PAGE_URL = "/add.jsp";
	private static final String ADDED = "added";
	private static final String WRONG_INPUT = "wronginput";
	private static final String MODEL = "model";
	private static final String CAPACITY = "capacity";
	private static final String DATE = "date";
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(ADD_PAGE_URL);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try {
			String model = request.getParameter(MODEL);
			Integer capacity = Integer.parseInt(request.getParameter(CAPACITY));
			Date builtDate = new SimpleDateFormat(DATE_FORMAT_PATTERN).parse(request.getParameter(DATE));

			if (InputCheker.approved(model, capacity, builtDate)) {

				Plane newPlane = new Plane(model, capacity, builtDate);
				storage.add(newPlane);
				request.setAttribute(ADDED, Message.PLANE_WAS_SUCCESSFULLY_ADDED.getValue());
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(ADD_PAGE_URL);
				requestDispatcher.forward(request, response);
				
			} else {

				request.setAttribute(WRONG_INPUT, Message.WRONG_INPUT.getValue());
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(ADD_PAGE_URL);
				requestDispatcher.forward(request, response);
			}
		} catch (IllegalArgumentException e) {

			request.setAttribute(WRONG_INPUT, Message.WRONG_INPUT.getValue());
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(ADD_PAGE_URL);
			requestDispatcher.forward(request, response);
		} catch (ParseException e) {

			request.setAttribute(WRONG_INPUT, Message.WRONG_INPUT.getValue());
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(ADD_PAGE_URL);
			requestDispatcher.forward(request, response);
		}

	}
}
