package com.park.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.ParkingInfoDao;
import com.park.entity.CarSpace;
import com.park.entity.ParkinglotInfo;
import com.park.service.ParkingInfoService;
import com.park.vo.ParkingInformation;

@Repository("parkingInfoService")
public class ParkingInfoServiceImpl implements ParkingInfoService {

	
	@Autowired
	ParkingInfoDao parkingInfoDao;
	

	public List<ParkingInformation> searchParkByName(String parking_name) {
		List<ParkinglotInfo> parkinglot=parkingInfoDao.searchParkByName(parking_name);
		List<ParkingInformation> parkingInformation=new ArrayList<ParkingInformation>();
		ParkingInformation pf=null;
		for(ParkinglotInfo pl:parkinglot){
			int collect_number=parkingInfoDao.getCollectUser(pl.getParking_id());
			int emptyCarSpace=parkingInfoDao.emptyCarspace(pl.getParking_id());
			pf=new ParkingInformation(pl.getParking_id(), pl.getParking_name(), pl.getParking_location(), pl.getCar_number(), collect_number, emptyCarSpace);
			parkingInformation.add(pf);
		}
		return parkingInformation;
	}

	public ParkinglotInfo getParking_Information(String parking_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ParkinglotInfo> getLocalPark(double longitude, double latitude) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEmptyCarSpace(String parking_id) {
		try {
			return parkingInfoDao.emptyCarspace(parking_id);
		}catch(Exception e) {
			return 0;
		}
		
	}

	public int getCollectUser(String parking_id) {
	
		return 0;
	}

	public List<CarSpace> getAllCarspace(String parking_id) {
		List<CarSpace> carspaces=parkingInfoDao.getAllCarspace(parking_id);
		try {
			return carspaces;
		}catch(Exception e) {
			return null;
		}
		
	}

	public boolean addAssessCount(String parking_id) {
		// TODO Auto-generated method stub
		boolean result=parkingInfoDao.addAssessCount(parking_id);
		return result;
	}

	public List<ParkinglotInfo> getAllParkinglotInfo() {
		// TODO Auto-generated method stub
		List<ParkinglotInfo> ParkinglotInfos=parkingInfoDao.getAllParkinglotInfo();
		return ParkinglotInfos;
	}

	public List<ParkinglotInfo> getParkinglotInfoByThumbs() {
		// TODO Auto-generated method stub
		List<ParkinglotInfo> ParkinglotInfos=parkingInfoDao.getParkinglotInfoByThumbs();
		return ParkinglotInfos;
	}

	//根据城市名模糊查找停车场
	public List<ParkinglotInfo> searchParkByLocation(String parking_location) {
		// TODO Auto-generated method stub
		List<ParkinglotInfo> ParkinglotInfos=parkingInfoDao.searchParkByLocation(parking_location);
		
		return ParkinglotInfos;
	}

	
}
	
