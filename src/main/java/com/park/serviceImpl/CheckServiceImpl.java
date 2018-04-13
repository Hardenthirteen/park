package com.park.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.CheckDao;
import com.park.entity.CarSpace;
import com.park.entity.Check;
import com.park.service.CheckService;
import com.park.vo.UserCheck;

@Repository("checkService")
public class CheckServiceImpl implements CheckService {

	
	@Autowired
	CheckDao checkDao;
	
	public boolean addCheck(Check check) {
		try{
			return checkDao.addCheck(check);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}
	
	public boolean updateCheck1(Check check) {
		try {
			if((checkDao.findChecktatus(check)).equals("0")==true) {
			return checkDao.updateCheck1(check);
			}else {
				return checkDao.addCheck(check);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateCheck2(Check check) {
		try {
			return checkDao.updateCheck2(check);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Check> findAllCheck(Check check) {
		try {
			return checkDao.findAllCheck(check);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public boolean quitCheck(int check_id) {
		// TODO Auto-generated method stub
		boolean result=checkDao.quitCheck(check_id);
		return result;
	}

	public List<Check> findParkingStatus(Check check) {
		
		try {
			return checkDao.findParkingStatus(check);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Date getDate(String license) {
		try {
			return checkDao.getDate();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/*
	@Override
	public UserCheck payCheck(CarSpace carspace) throws ParseException {
		// TODO Auto-generated method stub
		UserCheck userCheck=checkDao.payCheck(carspace);
		userCheck.setSpace_location(carspace.getSpace_location());
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dstart=df.parse(userCheck.getCheck_start_time());
		Date dover=df.parse(userCheck.getCheck_over_time());
		long diff=dover.getTime()-dstart.getTime();
		long days=diff/(1000*60*60*24);
		long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
	    long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
		String parking_time=days+"澶�"+hours+"灏忔椂"+minutes+"鍒�";
		userCheck.setParking_time(parking_time);
		return userCheck;
	}
	*/

	public UserCheck payCheck(CarSpace carspace) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Check> getLatestCheck(String phonenumber) {
		// TODO Auto-generated method stub
		List<Check> checks=checkDao.getLatestCheck(phonenumber);
		return checks;
	}

	public List<Check> getNotAssessCheck(String phonenumber) {
		// TODO Auto-generated method stub
		List<Check> checks=checkDao.getNotAssessCheck(phonenumber);
		return checks;
	}

	public List<Check> getServeCheck(String phonenumber) {
		// TODO Auto-generated method stub
		List<Check> checks=checkDao.getServeCheck(phonenumber);
		return checks;
	}

	public List<Check> getNotPayCheck(String phonenumber) {
		// TODO Auto-generated method stub
		List<Check> checks=checkDao.getNotPayCheck(phonenumber);
		return checks;
	}

	public List<Check> getReserveCheck(String phonenumber) {
		// TODO Auto-generated method stub
		List<Check> checks=checkDao.getReserveCheck(phonenumber);
		return checks;
	}

	public boolean toPayCheck(int check_id) {
		// TODO Auto-generated method stub
		boolean result=checkDao.toPayCheck(check_id);
		return result;
	}

	public List<Check> getUserAllCheck(String phonenumber) {
		// TODO Auto-generated method stub
		List<Check> checks=checkDao.getUserAllCheck(phonenumber);
		return null;
	}

	
	



	

}
