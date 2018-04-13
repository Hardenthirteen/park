package com.park.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.entity.Check;
import com.park.entity.ParkinglotInfo;
import com.park.entity.User;


@Repository
public interface UserDao {
	
	public boolean login(String phonenumber,String password);//登录
	public boolean regist(User us);//注册
	public User getUserMessage(String phonenumber);//获得用户信息
	public List<Check> getUserCheck(String phonenumber);//获取用户订单
	public List<ParkinglotInfo> getUserCollect(String phonenumber);//返回用户收藏信息
	public boolean updateNickname(String phonenumber,String newNickname);//修改昵称
	public boolean updatePhonenumber(String phonenumber,String newPhonenumber);//修改手机号码
	public boolean updatePassword(String phonenumber,String paassword,String newPassword);//修改用户密码
	public boolean updateLicense(String phonenumber,String newLicense); //修改车牌号
	
}
