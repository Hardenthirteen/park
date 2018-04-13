package com.park.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.park.entity.CarSpace;
import com.park.entity.Check;
import com.park.vo.UserCheck;


public interface CheckService {
	
	public boolean addCheck(Check check);
	
	public boolean updateCheck1(Check check);
	
	public boolean updateCheck2(Check check);
	
	public List<Check> findAllCheck(Check check);
public List<Check> getUserAllCheck(String phonenumber);//返回用户所有订单
	
	public List<Check> getLatestCheck(String phonenumber);//给用户返回最新的订单
	
	public List<Check> getNotPayCheck(String phonenumber);//获取用户未付款订单，状态为1
	
	public List<Check> getNotAssessCheck(String phonenumber);//获取用户未评价订单，状态为2
	
	public List<Check> getServeCheck(String phonenumber);//获取用户退款/售后订单，状态为3
	
	public List<Check> getReserveCheck(String phonenumber);//获取用户预定未使用订单，状态为0
	

	public boolean toPayCheck(int check_id);//付款

	public List<Check> findParkingStatus(Check check);
	
	public boolean quitCheck(int check_id);//取消订单
	
	public Date getDate(String license);
	
	public UserCheck payCheck(CarSpace carspace) throws ParseException;

}
