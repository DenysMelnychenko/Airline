package com.foodapp.repository;

import java.util.HashMap;
import java.util.Map;

import com.foodapp.models.Food;

public class ProductStorage {
	private static Map<Integer, Food> holder = new HashMap<>();

	public void add(Food food) {
		holder.put(food.getId(), food);
	}

	public void remove(String food, String color) {
		for (Map.Entry<Integer, Food> item : holder.entrySet()) {
			if (item.getValue().getName().equals(food) && item.getValue().getColor().equals(color)) {
				holder.remove(item.getKey());
			} 
		}
		
	}

public Food getByName(String name) {
	for(Map.Entry<Integer, Food> item : holder.entrySet()) {
		if(item.getValue().getName().equals(name)) {
			 return item.getValue();
		}
	}
	return null;
}
		
public Map<Integer, Food> getAll() {
	return holder;
}
	
}

