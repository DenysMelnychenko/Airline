package com.airlineweb.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plane {

	private String model;
	private int capacity;
	private Date builtDate;
	private static Integer id = 0;

	public Plane(String name, int capacity, Date builtDate) {
		this.model = name;
		this.capacity = capacity;
		this.builtDate = builtDate;
		id++;
	}

	public String getName() {
		return model;
	}

	public void setName(String name) {
		this.model = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getBuiltDate() {
		return new SimpleDateFormat("dd-MM-yyyy").format(builtDate);
	}

	public void setBuiltDate(Date builtDAte) {
		this.builtDate = builtDAte;
	}

	public Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		Plane.id = id;
	}

}
