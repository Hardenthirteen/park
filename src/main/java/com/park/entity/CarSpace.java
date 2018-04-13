package com.park.entity;

import java.io.Serializable;

public class CarSpace implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int space_id;
	private String space_location;
	private int space_status;
	private String phonenumber;
	private String parking_id;
	private String start_time;
	 
 
	public int getSpace_id() {
		return space_id;
	}
	public void setSpace_id(int space_id) {
		this.space_id = space_id;
	}
	public String getSpace_location() {
		return space_location;
	}
	public void setSpace_location(String space_location) {
		this.space_location = space_location;
	}
	public int getSpace_status() {
		return space_status;
	}
	public void setSpace_status(int space_status) {
		this.space_status = space_status;
	}
	 
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

}
