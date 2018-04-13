package com.park.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.park.entity.CarSpace;
import com.park.entity.Check;
import com.park.service.CarspaceService;
import com.park.service.CheckService;
import com.park.util.ResponseUtil;
import com.park.vo.UserCheck;


/*
 * 车位控制层
 * 负责预约  停车  取车 操作
 * 查询车位一系列信息
 */

@Controller
@RequestMapping("/carspace")
public class CarspaceController {
	
	@Autowired 
	CarspaceService carspaceService;
	
	@Autowired
	CheckService checkService;
	
	//预定车位,便产生一条状态为0的订单信息
	@RequestMapping(value = "/bookCarspace")//预定车位,便产生一条状态为0的订单信息
	public void bookCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  start_time= sdf.format(now);
		CarSpace cp=new CarSpace();
		cp.setSpace_status(1);
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
		cp.setPhonenumber(request.getParameter("phonenumber"));
		cp.setStart_time(start_time);
 		boolean result1=carspaceService.reserveCarspace(cp);//修改车位状态
 		
 		//添加订单
 		Check ck=new Check();
 		ck.setCheckstatus("0");//预定
 		ck.setCheck_start_time(start_time);
 		ck.setParking_id(request.getParameter("parking_id"));
 		ck.setPhonenumber(request.getParameter("phonenumber"));
 		ck.setSpace_location(request.getParameter("space_location"));
 		boolean result2=checkService.addCheck(ck);
 		json.put("result", result1&result2);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	
	}
	
	//停车
	@RequestMapping(value="/parkCarspace")
	public void parkCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject json=new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  start_time= sdf.format(now);
		CarSpace cp=new CarSpace();
		cp.setSpace_status(2);
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
		cp.setPhonenumber(request.getParameter("phonenumber"));
		cp.setStart_time(start_time);
		boolean result=carspaceService.parkCarspace(cp);
		Check check=new Check();
		check.setCheckstatus("1");
		check.setCheck_start_time(start_time);
		check.setParking_id(request.getParameter("parking_id"));
		check.setPhonenumber(request.getParameter("phonenumber"));
		check.setSpace_location(request.getParameter("space_location"));
		boolean result2=checkService.updateCheck1(check);
		json.put("result", result&result2);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}	
		
	}
	
	//取车操作
	@RequestMapping(value="/takeCarspace")
	public void takeCarspace(HttpServletRequest request,HttpServletResponse response)throws IOException {
		JSONObject json=new JSONObject();
		CarSpace car=new CarSpace();
		car.setParking_id(request.getParameter("parking_id"));
		car.setSpace_location(request.getParameter("space_location"));
		car.setPhonenumber(request.getParameter("phonenumber"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String over_time=sdf.format(now);
		car.setSpace_status(0);
		boolean result=carspaceService.takeCarspace(car);
		Check check=new Check();
		check.setCheckstatus("2");
		check.setParking_id(request.getParameter("parking_id"));
		check.setSpace_location(request.getParameter("space_location"));
		check.setPhonenumber(request.getParameter("phonenumber"));
		check.setCheck_over_time(over_time);
		boolean result2=checkService.updateCheck2(check);
//		json.put("result", result&result2);
		UserCheck userCheck;
		JSONArray JsonArray=new JSONArray();
		try {
			userCheck = carspaceService.payCheck(car);
//			json.put("payCheck",userCheck);
			JsonArray.add(userCheck);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
		
	}
	
	
	@RequestMapping(value = "/checkCarspace")//查看车位是否可以预约
	public void checkCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		CarSpace cp=new CarSpace();
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
 		int result=carspaceService.checkCarspace(cp);//查询车位状态
 		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}

	} 
	
	

}
