package com.airlineweb.utils;

public class InputCheker {

	public static boolean approve(String model, Integer capacity, String builtDate) {
		if (model != null && capacity != null && capacity > 0 && builtDate != null) {
			if (!model.isEmpty() && !builtDate.isEmpty()) {
				return true;
			} else
				return false;
		}
		return false;
	}
}
