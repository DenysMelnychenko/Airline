package com.airlineweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlineweb.models.Plane;
import com.airlineweb.repository.ProductStorage;

@WebServlet("/list")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductStorage storage = ProductStorage.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Map<Integer, Plane> products = storage.getAll();
		if (products.isEmpty()) {
			out.append("List is empty");
		} else
			for (Map.Entry<Integer, Plane> item : products.entrySet()) {
				out.append("ID " + item.getKey() + " Name " + item.getValue().getName() + " Color "
						+ item.getValue().getCapacity() + " Cost " + item.getValue().getBuiltDate() + "\n");
			}
	}

}
