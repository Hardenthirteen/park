package com.park.entity;

import java.io.Serializable;

public class User implements Serializable {
	 
	 
	private static final long serialVersionUID = -3313085052878558859L;
	private String phonenumber;
	private String password;
	private String nickname;
	private int role_id;
	private String license;//车牌号
	
	 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String phonenumber, String password, String nickname, int role_id, String license) {
		super();
		this.phonenumber = phonenumber;
		this.password = password;
		this.nickname = nickname;
		this.role_id = role_id;
		this.license = license;
	}
	@Override
	public String toString() {
		return "User [phonenumber=" + phonenumber + ", password=" + password + ", nickname=" + nickname + ", role_id="
				+ role_id + ", license=" + license + "]";
	}
	
	
	
	
	

}
