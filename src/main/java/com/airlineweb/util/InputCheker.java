package com.airlineweb.util;

import java.util.Date;

public class InputCheker {
	
	public static boolean approved(String model, Integer capacity, Date builtDate) {

		return model != null && capacity != null && capacity > 0 && builtDate != null && !model.isEmpty()
				&& !builtDate.equals("");
		
	}
}
