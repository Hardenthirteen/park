package com.park.entity;

public class Collection {
	private int user_park_id;
	public int getUser_park_id() {
		return user_park_id;
	}
	public void setUser_park_id(int user_park_id) {
		this.user_park_id = user_park_id;
	}
	private String phonenumber;
	private String parking_id;
	public Collection(String phonenumber, String parking_id) {
		super();
		this.phonenumber = phonenumber;
		this.parking_id = parking_id;
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
}
