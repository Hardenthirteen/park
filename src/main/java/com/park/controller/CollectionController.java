package com.park.controller;
import com.park.util.*;
import java.io.IOException;
import java.util.List;
import com.github.pagehelper.PageHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.park.entity.Collection;
import com.park.entity.ParkinglotInfo;
import com.park.service.CollectionService;
import com.park.util.ResponseUtil;

@Controller
@RequestMapping("/collection")
public class CollectionController {
	@Autowired
	CollectionService collectionService;
	
	@RequestMapping("/addCollection")
	public void addCollection(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject();
		String phonenumber=request.getParameter("phonenumber");
		String parking_id=request.getParameter("parking_id");
		Collection collection=new Collection(phonenumber,parking_id);
		boolean result=collectionService.addCollection(collection);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteCollection")
	public void deleteCollection(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject();
		String phonenumber=request.getParameter("phonenumber");
		String parking_id=request.getParameter("parking_id");
		Collection collection=new Collection(phonenumber,parking_id);
		boolean result=collectionService.deleteCollection(collection);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	/*@RequestMapping("/getCollection")
	public void getCollection(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject();
		Integer page=Integer.parseInt(request.getParameter("page"));//当前页
		Integer rows=5;//Integer.parseInt(request.getParameter("rows"));//每页显示的数量
		int intPage = page == null ||  page <= 0 ? 1 : page;//当前页
	    int intPageSize = rows == null || rows <= 0 ? 10 : rows; // 设置每页显示的数量
	    PageParameter page1 = new PageParameter();
		String phonenumber=request.getParameter("phonenumber");
		page1.setCurrentPage(intPage);
		page1.setPageSize(intPageSize);
		PageHelper.startPage(intPage,intPageSize);
		List<ParkinglotInfo> parkinglotInfos=collectionService.getCollection(phonenumber);
		
		for(ParkinglotInfo parkinglotInfo:parkinglotInfos){
			json.put(String.valueOf(parkinglotInfo.getParking_id()), parkinglotInfo);
		}
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}*/

}
