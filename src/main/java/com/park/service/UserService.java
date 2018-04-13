package com.park.service;

import java.util.List;

import com.park.entity.ParkinglotInfo;
import com.park.entity.User;



public interface UserService {
	
	public String login(String phonenumber,String password);//登录
	public boolean regist(User us);//注册
	public User getUserMessage(String phonenumber);//获得用户基本信息
	//public List<ParkinglotInfo> getUserCollect(String phonenumber);//获得用户的收藏信息
	public boolean updateNickname(String phonenumber,String newNickname);//修改昵称
	public boolean updatePhonenumber(String phonenumber,String newPhonenumber);//修改手机号码
	public boolean updatePassword(String phonenumber,String password,String newPassword);//修改用户密码
	public boolean updateLicense(String phonenumber,String newLicense);//修改车牌号
	public List<ParkinglotInfo> getUserCollect(String phonenumber);//返回用户收藏信息


}
