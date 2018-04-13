package com.park.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.AssessDao;
import com.park.entity.Assess;
import com.park.service.AssessService;
@Repository("assessService")
public class AssessServiceImpl implements AssessService{
	
	@Autowired
	public  AssessDao assessDao;
	public List<Assess> findByParkingId(String parking_id) {
		try{
			return assessDao.find_ParkingId(parking_id);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addAssess(Assess assess) {
		// TODO Auto-generated method stub
		try{
			return assessDao.add(assess);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public boolean deleteByPhonenumber(String phonenumber) {
		// TODO Auto-generated method stub
		try{
			return assessDao.delete_phonenumber(phonenumber);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	public boolean add_thumbs_up(String parking_id) {
		// TODO Auto-generated method stub
		boolean result=assessDao.add_thumbs_up(parking_id);
		return result;
	}

	public boolean add_check(int check_id) {
		// TODO Auto-generated method stub
		boolean result=assessDao.add_check(check_id);
		return result;
	}

}
