package com.park.entity;

import java.io.Serializable;

public class Check implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int check_id;
	private String check_start_time;
	private String check_over_time;
	private double check_money;
	private String phonenumber;
	private String space_location;
	private String parking_id;
	private String checkstatus;

	 
	public int getCheck_id() {
		return check_id;
	}
	public void setCheck_id(int check_id) {
		this.check_id = check_id;
	}
	public String getCheck_start_time() {
		return check_start_time;
	}
	public void setCheck_start_time(String check_start_time) {
		this.check_start_time = check_start_time;
	}
	public String getCheck_over_time() {
		return check_over_time;
	}
	public void setCheck_over_time(String check_over_time) {
		this.check_over_time = check_over_time;
	}
	public double getCheck_money() {
		return check_money;
	}
	public void setCheck_money(double check_money) {
		this.check_money = check_money;
	}
	
	
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	

	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	 
	 
	public String getSpace_location() {
		return space_location;
	}
	public void setSpace_location(String space_location) {
		this.space_location = space_location;
	}
	
	public String getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}

}
