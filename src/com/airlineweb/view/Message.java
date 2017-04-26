package com.airlineweb.view;

public enum Message {
	AIRCRAFT_STORAGE_IS_EMPTY("STORAGE IS EMPTY!"),
	THE_AIRCRAFT_WAS_NOT_FOUND("THE AIRCRAFT WAS NOT FOUND!!!"),
	 PLANE_WAS_SUCCESSFULLY_ADDED("PLANE WAS SUCCESFULLY ADDED!"),
	 WRONG_INPUT("SOMETHING WENT WRONG! CHECK YOUR INPUT PLEASE!"),
	 DELETED("SUCCESSFULLY DELETED");
	
	private String value;
	
	private Message(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
