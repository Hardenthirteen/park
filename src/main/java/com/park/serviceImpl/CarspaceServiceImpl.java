package com.park.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.CarspaceDao;
import com.park.entity.CarSpace;
import com.park.service.CarspaceService;
import com.park.vo.UserCheck;

@Repository("carspaceService")
public class CarspaceServiceImpl  implements CarspaceService{

	@Autowired
	CarspaceDao carspaceDao;

	
	//预定车位  若为空闲态，修改车位状态 完成该预约操作
	public boolean reserveCarspace(CarSpace car) {
		try{
			if(carspaceDao.findStatus(car.getParking_id(), car.getSpace_location())==0)
			return carspaceDao.reserveCarspace(car);
			else
				return false;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}
	
	//停车操作 查询是否被预约或者空闲
	public boolean parkCarspace(CarSpace car) {
		
		try {
			if((carspaceDao.findStatus(car.getParking_id(), car.getSpace_location())==0)||
					(carspaceDao.compareCarspace(car)==1)
					){
				
				return carspaceDao.parkCarspace(car);
			}else {
			return false;
			}
			
			//return carspaceDao.parkCarspace(car);
		}catch(Exception e) {
		
			return false;
		}
	}
	
	//取车操作
	public boolean takeCarspace(CarSpace car) {
		try {
			if(carspaceDao.compareCarspace(car)==2) {
				return carspaceDao.takeCarspace(car);
			}else {
				return false;
			}
				
		}catch(Exception e) {
			
			return false;
		}
		
	}
	
	
	//查询车位状态
		public int checkCarspace(CarSpace car) {
			try{
				
				return carspaceDao.findStatus(car.getParking_id(), car.getSpace_location());
				
			}catch(Exception e){
				e.printStackTrace();
				return -1;
			}
			
		}

		public UserCheck payCheck(CarSpace carspace) throws ParseException {
			// TODO Auto-generated method stub
			UserCheck userCheck=carspaceDao.payCheck(carspace);
			userCheck.setSpace_location(carspace.getSpace_location());
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dstart=df.parse(userCheck.getCheck_start_time());
			Date dover=df.parse(userCheck.getCheck_over_time());
			long diff=dover.getTime()-dstart.getTime();
			long days=diff/(1000*60*60*24);
			long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
		    long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
			String parking_time=days+"天"+hours+"小时"+minutes+"分";
			userCheck.setParking_time(parking_time);
			return userCheck;
		}
	
	
	

	
	

}
