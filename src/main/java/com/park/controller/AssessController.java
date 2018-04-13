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
import com.park.entity.Assess;
import com.park.service.AssessService;
import com.park.service.ParkingInfoService;
import com.park.util.ResponseUtil;

@Controller
@RequestMapping("/assess2")
public class AssessController {
	@Autowired
	 AssessService assessService;
	@Autowired
	ParkingInfoService parkingInfoService;
	@RequestMapping("/addAssess")
	//添加评论,返回结果是否成功
	public void addAssess(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  assess_time= sdf.format(now);
		Assess assess=new Assess();
		assess.setAssess_content(new String(request.getParameter("assess_content")));
		assess.setAssess_mark(request.getParameter("assess_mark"));
		assess.setAssess_time(assess_time);
		assess.setParking_id(request.getParameter("parking_id"));
		assess.setPhonenumber(request.getParameter("phonenumber"));
		boolean result2=parkingInfoService.addAssessCount(request.getParameter("parking_id"));
		boolean result=assessService.addAssess(assess);//将数据加入到数据库中
		int thumbs_up=Integer.parseInt(request.getParameter("thumbs_up"));
		if(thumbs_up==1){
			assessService.add_thumbs_up(request.getParameter("parking_id"));
		}
		boolean result3=assessService.add_check(Integer.parseInt(request.getParameter("check_id")));
		json.put("reslut", result&result2&result3);
		
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	@RequestMapping("/getAssess")
	public void getAssess(HttpServletRequest request,HttpServletResponse response){
		JSONObject json=new JSONObject();
		JSONArray JsonArray=new JSONArray();
		List<Assess> assess=assessService.findByParkingId(request.getParameter("parking_id"));
		for(Assess as:assess){
			JsonArray.add(as);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteAssess")
	public void deleteAssess(HttpServletRequest request,HttpServletResponse response){
		JSONObject json=new JSONObject();
		String phonenumber=request.getParameter("phonenumber");
		boolean result=assessService.deleteByPhonenumber(phonenumber);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
}
