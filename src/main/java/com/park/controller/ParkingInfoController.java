package com.park.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.park.entity.CarSpace;
import com.park.entity.ParkinglotInfo;
import com.park.service.ParkingInfoService;
import com.park.util.ResponseUtil;
import com.park.vo.ParkingInformation;


/*
 * 停车场控制层
 * 实现查询每个停车场的具体信息
 */
@Controller
@RequestMapping("/parkinglot")
public class ParkingInfoController {
	
	@Autowired
	ParkingInfoService parkingService;
	
	@RequestMapping(value = "/searchParkByName")//根据停车场名字附近停车场的信息***加上分页
	public void searchParkByName(HttpServletRequest request,HttpServletResponse response ){
	String parking_name = request.getParameter("parking_name");
	JSONObject json = new JSONObject();
	JSONArray JsonArray=new JSONArray();
	List<ParkingInformation> pl = parkingService.searchParkByName(parking_name);
	for (ParkingInformation p : pl) {
		JsonArray.add(p);
		}
	try {
		ResponseUtil.write(response, JsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/searchAllStatus")
	public void searchAllStatus(HttpServletRequest request,HttpServletResponse response ) {
		JSONArray JsonArray=new JSONArray();
		
		String parking_id=request.getParameter("parking_id");
		System.out.println(parking_id);
		
		List<CarSpace> carspaces=parkingService.getAllCarspace(parking_id);
		for(CarSpace carspace:carspaces) {
			JSONObject json=new JSONObject();
			json.put("space_location", carspace.getSpace_location());
			json.put("space_status", carspace.getSpace_status());
			JsonArray.add(json);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	//获取停车场信息
	@RequestMapping("/getParkinglotInfo")
	public void getAllParkinglotInfo(HttpServletRequest request,HttpServletResponse response ) {
		
		JSONArray JsonArray=new JSONArray();
		List<ParkinglotInfo> ParkinglotInfos=parkingService.getAllParkinglotInfo();
		for(ParkinglotInfo ParkinglotInfo:ParkinglotInfos){
			JsonArray.add(ParkinglotInfo);
		}
	
		try {
			//ResponseUtil.write(response, json.toString());
			ResponseUtil.write(response, JsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	//根据城市名模糊查找停车场信息
	@RequestMapping("/parking_location")
	public void getParkByLocation(HttpServletRequest request,HttpServletResponse response ) {
		
		String parking_location=request.getParameter("parking_location");
		List<ParkinglotInfo> ParkinglotInfos=parkingService.searchParkByLocation(parking_location);
		JSONArray JsonArray=new JSONArray();
		for(ParkinglotInfo ParkinglotInfo:ParkinglotInfos){
			JsonArray.add(ParkinglotInfo);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	//根据好评优先获取停车场信息
	@RequestMapping("/getParkinglotInfoByThumbsUp")
	public void getParkinglotInfoByThumbsUp(HttpServletRequest request,HttpServletResponse response ) {
		int i=1;
		List<ParkinglotInfo> ParkinglotInfos=parkingService.getParkinglotInfoByThumbs();
		JSONArray JsonArray=new JSONArray();
		for(ParkinglotInfo ParkinglotInfo:ParkinglotInfos){
			JsonArray.add(ParkinglotInfo);
		}
		try {
			ResponseUtil.write(response, JsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
