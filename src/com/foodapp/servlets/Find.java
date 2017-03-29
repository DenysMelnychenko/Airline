package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.models.Food;
import com.foodapp.repository.ProductStorage;

@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ProductStorage storage = ProductStorage.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		Food food = storage.getByName(name);
		out.append("Item name " + food.getName() + " Color is " + food.getColor() + " Cost is " + food.getCost());
	}

}
