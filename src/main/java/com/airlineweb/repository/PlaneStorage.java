package com.airlineweb.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.airlineweb.model.Plane;

public class PlaneStorage {
	private final static Logger logger = Logger.getLogger(PlaneStorage.class);
	private static volatile PlaneStorage instance;
	private Map<Integer, Plane> storage = new HashMap<>();

	private PlaneStorage() {
	}

	public static PlaneStorage getInstance() {
		if (instance == null) {
			synchronized (PlaneStorage.class) {
				if (instance == null) {
					instance = new PlaneStorage();
				}
			}
		}
		return instance;
	}

	public void add(Plane plane) {
		storage.put(plane.getId(), plane);
		logger.info("Plane " + plane.getName() + " was added to storage");
	}

	public boolean remove(String model, int capacity) {
		for (Map.Entry<Integer, Plane> item : storage.entrySet()) {
			if (item.getValue().getName().equals(model) && item.getValue().getCapacity() == (capacity)) {
				storage.remove(item.getKey());
				logger.info("Plane " + item.getValue().getName() + " was deleted from storage");
				return true;
			}
		}
		return false;

	}

	public Map<Integer, Plane> SearchByModel(String name) {
			Map<Integer, Plane> result = new HashMap<>(); 
		for (Map.Entry<Integer, Plane> plane : storage.entrySet()) {
			Plane desiredPlane = plane.getValue();
			String modelName = desiredPlane.getName();
			Integer id = plane.getKey();
			if (modelName.equals(name)) {
				result.put(id, desiredPlane);
			}
		}
		return result;
	}

	public boolean contains(String model) {
		for (Map.Entry<Integer, Plane> item : storage.entrySet()) {
			if (item.getValue().getName().equals(model)) {
				return true;
			}
		}
		return false;
	}

	public Map<Integer, Plane> getAll() {
		return storage;
	}

}
