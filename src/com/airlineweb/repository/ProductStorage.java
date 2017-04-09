package com.airlineweb.repository;

import java.util.HashMap;
import java.util.Map;

import com.airlineweb.models.Plane;

public class ProductStorage {
	private static volatile ProductStorage instance;
	private Map<Integer, Plane> storage = new HashMap<>();

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

	public void add(Plane food) {
		storage.put(food.getId(), food);
	}

	public boolean remove(String model, int capacity) {
		for (Map.Entry<Integer, Plane> item : storage.entrySet()) {
			if (item.getValue().getName().equals(model) && item.getValue().getCapacity()==(capacity)) {
				storage.remove(item.getKey());
				return true;
			}
		}
		return false;

	}

	public Plane getByName(String model) {
		for (Map.Entry<Integer, Plane> item : storage.entrySet()) {
			if (item.getValue().getName().equals(model)) {
				return item.getValue();
			}
		}
		return null;
	}

	public Map<Integer, Plane> getAll() {
		return storage;
	}

}
