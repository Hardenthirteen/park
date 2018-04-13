package com.park.vo;

import java.io.Serializable;



public class ParkingInformation  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String parking_id;
	private String parking_name;
	private String parking_location;
	private int car_number;
	private int emptyCarspace;
	private int collectnum;
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
	public String getParking_location() {
		return parking_location;
	}
	public void setParking_location(String parking_location) {
		this.parking_location = parking_location;
	}
	public int getCar_number() {
		return car_number;
	}
	public void setCar_number(int car_number) {
		this.car_number = car_number;
	}
	public int getEmptyCarspace() {
		return emptyCarspace;
	}
	public void setEmptyCarspace(int emptyCarspace) {
		this.emptyCarspace = emptyCarspace;
	}
	public int getCollectnum() {
		return collectnum;
	}
	public void setCollectnum(int collectnum) {
		this.collectnum = collectnum;
	}
	public ParkingInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParkingInformation(String parking_id, String parking_name, String parking_location, int car_number,
			int emptyCarspace, int collectnum) {
		super();
		this.parking_id = parking_id;
		this.parking_name = parking_name;
		this.parking_location = parking_location;
		this.car_number = car_number;
		this.emptyCarspace = emptyCarspace;
		this.collectnum = collectnum;
	}
	

}
