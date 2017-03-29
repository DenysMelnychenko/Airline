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

@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductStorage holder = new ProductStorage();

	public Add() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		int cost = Integer.parseInt(request.getParameter("cost"));
		Food food = new Food(name, color, cost);
		holder.add(food);
		out.append(food.getName() + " was added!");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
