package com.foodapp.models;

public class Food {
private String name;
private String  color;
private int cost;
private static Integer id = 0;

public Food(String name, String color, int cost) {
	this.setName(name);
	this.setColor(color);
	this.setCost(cost);
	setId(getId() + 1); 
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}

public Integer getId() {
	return id;
}

public static void setId(Integer id) {
	Food.id = id;
}

}
