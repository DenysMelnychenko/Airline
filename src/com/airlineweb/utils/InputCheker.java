package com.airlineweb.utils;

import java.util.Date;

public class InputCheker {

	public static boolean approved(String model, Integer capacity, Date builtDate) {
		if (model != null && capacity != null && capacity > 0 && builtDate != null) {
			if (!model.isEmpty() && !builtDate.equals("")) {
				return true;
			} else
				return false;
		}
		return false;
	}
}
