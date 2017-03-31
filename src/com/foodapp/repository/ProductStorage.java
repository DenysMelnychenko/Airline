package com.foodapp.repository;

import java.util.HashMap;
import java.util.Map;

import com.foodapp.models.Food;

public class ProductStorage {
	private static volatile ProductStorage instance;
	private Map<Integer, Food> storage = new HashMap<>();

	private ProductStorage() {
	}

	public static ProductStorage getInstance() {
		if (instance == null) {
			synchronized (ProductStorage.class) {
				if (instance == null) {
					instance = new ProductStorage();
				}
			}
		}
		return instance;
	}

	public void add(Food food) {
		storage.put(food.getId(), food);
	}

	public boolean remove(String food, String color) {
		for (Map.Entry<Integer, Food> item : storage.entrySet()) {
			if (item.getValue().getName().equals(food) && item.getValue().getColor().equals(color)) {
				storage.remove(item.getKey());
				return true;
			} 
		}
		 return false;

	}

	public Food getByName(String name) {
		for (Map.Entry<Integer, Food> item : storage.entrySet()) {
			if (item.getValue().getName().equals(name)) {
				return item.getValue();
			}
		}
		return null;
	}

	public Map<Integer, Food> getAll() {
		return storage;
	}

}
