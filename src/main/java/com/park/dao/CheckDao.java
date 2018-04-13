package com.park.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.entity.CarSpace;
import com.park.entity.Check;
import com.park.vo.UserCheck;


/*
 * 订单状态：0：已预订，未支付，1：正在使用，未支付
 * 			2：已支付，待评价，3：已支付，已评价)
 */

/*
 * 
 */
@Repository
public interface CheckDao {
	
	public boolean addCheck(Check check);
	
	public boolean updateCheck1(Check check);
	
	public boolean updateCheck2(Check check);
	
	public boolean quitCheck(int check_id);//取消订单
	
	public String findChecktatus(Check check);
	
	
	public List<Check> findAllCheck(Check check);
	
	public List<Check> findParkingStatus(Check check);
	
	public List<Check> getUserAllCheck(String phonenumber);//返回用户所有订单
	
	public List<Check> getLatestCheck(String phonenumber);//给用户返回最新的订单
	
	public List<Check> getNotPayCheck(String phonenumber);//获取用户未付款订单，状态为1
	
	public List<Check> getNotAssessCheck(String phonenumber);//获取用户未评价订单，状态为2
	
	public List<Check> getServeCheck(String phonenumber);//获取用户退款/售后订单，状态为3
	
	public List<Check> getReserveCheck(String phonenumber);//获取用户预定未使用订单，状态为0
	
	public boolean toPayCheck(int check_id);//付款
	//public UserCheck payCheck(CarSpace carspace);

	public Date getDate();
}
