package com.airlineweb.models;

public class Plane {
	
	private String model;
	private int capacity;
	private String builtDate;
	private static Integer id = 0;

	public Plane(String name, int capacity, String builtDate) {
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
		return builtDate;
	}

	public void setBuiltDate(String builtDAte) {
		this.builtDate = builtDAte;
	}

	public Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		Plane.id = id;
	}

}
