package com.park.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.park.entity.ParkinglotInfo;
import com.park.entity.User;
import com.park.service.UserService;
import com.park.util.ResponseUtil;

/*
 * 用户控制层
 * 负责用户的登录 注册 修改信息
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@RequestMapping(value = "/login")
	// 根据手机号密码登录
	public void login(HttpServletRequest request, HttpServletResponse response) {
		//JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		System.out.println(phonenumber);
		String password = request.getParameter("password");
		System.out.println(password);
	 	try {
	 		String result=userService.login(phonenumber, password);
	 		ResponseUtil.write(response, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/returnMessage")
	// 根据手机号返回用户基本信息
	public void returnMessage(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		JSONArray JsonArray=new JSONArray();
		String phonenumber = request.getParameter("phonenumber");
		User us = userService.getUserMessage(phonenumber);
		us.setPassword(null);
		JsonArray.add(us);
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/regist")
	// 用户注册
	public void regist(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		int status = 0;
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String license=request.getParameter("license");
		//	String validate = request.getParameter("validate");
		// 判断用户是否已经被注册过。
		// if(map.get(phonenumber)!=null&&map.get(phonenumber).equals(validate)){
		User us = new User();
		us.setPhonenumber(phonenumber);
		us.setPassword(password);
		us.setNickname(nickname);
		us.setRole_id(3);
		us.setLicense(license);
		boolean result = userService.regist(us);
		if (result == true)// 用户注册成功
			status = 2;
		else {// 用户名已经存在了
			status = 1;//
			
		}
		json.put("status", status);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updateNickname")
	// 修改昵称
	public void updateNickname(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String newNickname = request.getParameter("newNickname");
		boolean result = userService.updateNickname(phonenumber, newNickname);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updatePhonenumber")
	// 修改已绑定的手机号码
	public void updatePhonenumber(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String newPhonenumber = request.getParameter("newPhonenumber");
		boolean result = userService.updatePhonenumber(phonenumber, newPhonenumber);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updatePassword")
	// 修改密码
	public void updatePassword(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String password=request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		boolean result = userService.updatePassword(phonenumber,password, newPassword);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updateLicense")
	// 修改车牌号
	public void updateLicense(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String newLicense=request.getParameter("newLicense");
		boolean result = userService.updateLicense(phonenumber, newLicense);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getUserCollection")
	//获取收藏信息
	public void getCollection(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray JsonArray =new JSONArray();
		String phonenumber=request.getParameter("phonenumber");
		List<ParkinglotInfo> parkinglotInfos=userService.getUserCollect(phonenumber);
		for(ParkinglotInfo parkinglotInfo:parkinglotInfos) {
			JsonArray.add(parkinglotInfo);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	@RequestMapping("/getCheck")
	//获取个人订单
	public void getCheck(HttpServletRequest request,
			HttpServletResponse response) {
		
	}
	*/

}
