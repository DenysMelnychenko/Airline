package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.models.Food;
import com.foodapp.repository.ProductStorage;

@WebServlet("/list")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ProductStorage storage = ProductStorage.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		for (Map.Entry<Integer, Food> item : storage.getAll().entrySet()) {
			out.append("ID " + item.getKey() + " Name " + item.getValue().getName() + " Color "
					+ item.getValue().getColor() + " Cost " + item.getValue().getCost());
		}
	}

}
