package com.park.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.park.dao.UserDao;
import com.park.entity.ParkinglotInfo;
import com.park.entity.User;
import com.park.service.UserService;
import com.park.util.MD5Util;
import com.park.util.MemcachedUtil;

@Repository("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	

	//登录
	public String login(String phonenumber, String password) {
		
		//JSONObject json = new JSONObject();
		int status = 0;
		String token = MD5Util.MD5(phonenumber + password);// + UUID.randomUUID());// 通过用户名和密码和uuid获得token
		//System.out.println("kkk"+token);
		if (MemcachedUtil.get(token) != null){ // 判断memcached中是否存在token,存在提醒用户不可重复登录
			status = 2; //用户已经登陆了
			System.out.println(MemcachedUtil.get(token));
			}
		else {
			// 生成token，将token写入memcached,并将token返回给客户端
			boolean b = userDao.login(phonenumber,password);
			if (b == true) {
				// String quanxian=从数据库中获得用户的权限
				boolean m=MemcachedUtil.add(token, 1);// 将权限写入缓存。
				status = 1;
				User us = userDao.getUserMessage(phonenumber);
				//json.put("nickname", us.getNickname());
				//json.put("avatar", us.getAvatar());// 获得用户头像
				//json.put("license", us.getLicense());
				//json.put("token", token);
				return "success";

			}
			 
		}
		//json.put("status", status);
		//return json.toString();
		return "faile";
		
	}

	public boolean regist(User us) {
		try{
			return userDao.regist(us);
			
		}catch(Exception e){
			System.out.println("主键已经存在了");
			return false;
			
		}
	}

	public User getUserMessage(String phonenumber) {
		try{
			return userDao.getUserMessage(phonenumber);
			
		}catch(Exception e){
			
			return null;
		}
	}

	public boolean updateNickname(String phonenumber, String newNickname) {
		try{
			return userDao.updateNickname(phonenumber, newNickname);
			
		}catch(Exception e){
			
			return false;
			
		}
	}

	public boolean updatePhonenumber(String phonenumber, String newPhonenumber) {
		try {
			return userDao.updatePhonenumber(phonenumber, newPhonenumber);
		
		}catch(Exception e){
			
			return false;
		}
		
	}

	public boolean updatePassword(String phonenumber, String password, String newPassword) {
		try {
			return userDao.updatePassword(phonenumber,password, newPassword);
		
		}catch(Exception e) {
			
			return false;
		}
		
	}

	public boolean updateLicense(String phonenumber, String newLicense) {
		try {
			return userDao.updateLicense(phonenumber, newLicense);
		
		}catch(Exception e) {
			
			return false;
		}
	}

	public List<ParkinglotInfo> getUserCollect(String phonenumber) {
		// TODO Auto-generated method stub
		List<ParkinglotInfo> parkinglotInfos=userDao.getUserCollect(phonenumber);
		return parkinglotInfos; 
	}
	
	
	
	

}
