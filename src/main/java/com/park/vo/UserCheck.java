package com.park.vo;

import java.io.Serializable;

public class UserCheck implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String parking_id;
	private String parking_name;
	private String space_location;
	private String check_money;
	private String check_start_time;
	private String check_over_time;
	private String phonenumer;
	private String parking_time;
	public UserCheck(String parking_id, String parking_name,
			String space_location, String check_money, String check_start_time,
			String check_over_time, String phonenumer, String parking_time) {
		super();
		this.parking_id = parking_id;
		this.parking_name = parking_name;
		this.space_location = space_location;
		this.check_money = check_money;
		this.check_start_time = check_start_time;
		this.check_over_time = check_over_time;
		this.phonenumer = phonenumer;
		this.parking_time = parking_time;
	}
	public UserCheck(){}
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public String getParking_name() {
		return parking_name;
	}
	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}
	public String getSpace_location() {
		return space_location;
	}
	public void setSpace_location(String space_location) {
		this.space_location = space_location;
	}
	public String getCheck_money() {
		return check_money;
	}
	public void setCheck_money(String check_money) {
		this.check_money = check_money;
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
	public String getPhonenumer() {
		return phonenumer;
	}
	public void setPhonenumer(String phonenumer) {
		this.phonenumer = phonenumer;
	}
	public String getParking_time() {
		return parking_time;
	}
	public void setParking_time(String parking_time) {
		this.parking_time = parking_time;
	}
}
