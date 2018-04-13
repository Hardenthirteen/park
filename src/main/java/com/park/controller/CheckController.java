package com.park.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.park.entity.Check;
import com.park.service.CheckService;
import com.park.util.ResponseUtil;

/*
 * 订单控制层
 * 负责完成订单与取消订单
 * 根据电话号获取订单与用户部分信息
 */

@Controller
@RequestMapping("/check")
public class CheckController {
	@Autowired
	CheckService checkService;
	
	//查询所有订单
	@RequestMapping(value="/findcheck")
	public void findcheck(HttpServletRequest request,HttpServletResponse response)throws IOException {
	
		JSONObject json=new JSONObject ();
		JSONArray JsonArray=new JSONArray();
		Check check=new Check();
		check.setParking_id(request.getParameter("parking_id"));
		List<Check> checks=checkService.findAllCheck(check);
		for(Check ch:checks) {
			//System.out.println("输出"+ch.getPhonenumber());
			JsonArray.add(ch);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/findCheckstatus")
	public void findCheckstatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		JSONObject json=new JSONObject ();
		JSONArray JsonArray=new JSONArray();
		Check check=new Check();
		check.setParking_id(request.getParameter("parking_id"));
		check.setCheckstatus(request.getParameter("checkstatus"));
		List<Check> checks=checkService.findParkingStatus(check);
		for(Check ch:checks) {
			JsonArray.add(ch);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/quitCheck")
	//用户取消订单，状态为5
	public void deleteCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject json=new JSONObject ();
		JSONArray JsonArray=new JSONArray();
		Check check=new Check();
		int check_id=Integer.parseInt(request.getParameter("check_id"));
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String  start_time= sdf.format(now);
//		//String checkTime=sdf.format(checkService.getDate(license));
//		Date now =new Date();
//		String license=request.getParameter("license");
//		Date checkTime=checkService.getDate(license);
		boolean result=checkService.quitCheck(check_id);
		try {
			json.put("result", result);
			ResponseUtil.write(response, json.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getLatestCheck")
	//获取用户最新订单
	public void getLatestCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject json=new JSONObject();
		String phonenumber=request.getParameter("phonenumber");
		JSONArray JsonArray=new JSONArray();
		List<Check> checks=checkService.getLatestCheck(phonenumber);
	/*	int now=Integer.parseInt(request.getParameter("nowPage"));
		int pageCounts=5;//每页显示的记录数
	
		PageHelper.startPage(now,pageCounts);
		
		int rows=checks.size();//总记录数
		
		
		int page=(rows-1)/pageCounts+1;
		if(now>page) 
			{
			json.put("1", "已经到最后啦!");
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
		else{}*/
		//	Page<Check> listCheck=(Page<Check>)checks;
			for(Check check:checks){
				JsonArray.add(check);
			}
			try {
				ResponseUtil.write(response, JsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			
		}
		
	}
	
	@RequestMapping("/getNotAssessCheck")
	//获取用户未评价订单
	public void getNotAssessCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		JSONObject json=new JSONObject();
		JSONArray JsonArray=new JSONArray();
		String phonenumber=request.getParameter("phonenumber");
		List<Check> checks=checkService.getNotAssessCheck(phonenumber);
		for(Check check:checks){
			JsonArray.add(check);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getServeCheck")
	//获取用户退款/售后订单
	public void getAssessCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONArray JsonArray=new JSONArray();
		JSONObject json=new JSONObject();
		String phonenumber=request.getParameter("phonenumber");
		List<Check> checks=checkService.getServeCheck(phonenumber);
		for(Check check:checks){
			JsonArray.add(check);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getReserveCheck")
	//获取用户预订未使用订单
	public void getPayedCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONArray JsonArray=new JSONArray();
		JSONObject json=new JSONObject();
		String phonenumber=request.getParameter("phonenumber");
		List<Check> checks=checkService.getReserveCheck(phonenumber);
		for(Check check:checks){
			JsonArray.add(check);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getNotPayCheck")
	//获取用户未付款订单
	public void getNotPayCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject json=new JSONObject();
		JSONArray JsonArray=new JSONArray();
		String phonenumber=request.getParameter("phonenumber");
		List<Check> checks=checkService.getNotPayCheck(phonenumber);
		for(Check check:checks){
			JsonArray.add(check);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/toPayCheck")
	//去付款
	public void toPayCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		JSONObject json=new JSONObject();
		int check_id=Integer.parseInt(request.getParameter("check_id"));
		boolean result=checkService.toPayCheck(check_id);
		json.put("result",result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	@RequestMapping("/getUserCheck")
	public void getUserCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JSONObject json=new JSONObject ();
		Check check=new Check();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  over_time= sdf.format(now);
		
	}
	*/

}
