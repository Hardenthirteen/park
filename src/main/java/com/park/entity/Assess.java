package com.park.entity;

public class Assess {
	private int assess_id;
	public int getAssess_id() {
		return assess_id;
	}
	public void setAssess_id(int assess_id) {
		this.assess_id = assess_id;
	}
	private String assess_mark;
	private String assess_content;
	private String assess_time;
	private String phonenumber;
	private String parking_id;
	//private String thumbs_up;

	public Assess( String assess_mark, String assess_content,
			String assess_time, String phonenumber, String parking_id) {
		super();
	
		this.assess_mark = assess_mark;
		this.assess_content = assess_content;
		this.assess_time = assess_time;
		this.phonenumber = phonenumber;
		this.parking_id = parking_id;
	}
	public Assess() {
		// TODO Auto-generated constructor stub
	}

	public String getAssess_mark() {
		return assess_mark;
	}
	public void setAssess_mark(String assess_mark) {
		this.assess_mark = assess_mark;
	}
	public String getAssess_content() {
		return assess_content;
	}
	public void setAssess_content(String assess_content) {
		this.assess_content = assess_content;
	}
	public String getAssess_time() {
		return assess_time;
	}
	public void setAssess_time(String assess_time) {
		this.assess_time = assess_time;
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
