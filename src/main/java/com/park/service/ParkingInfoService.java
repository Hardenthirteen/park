package com.park.service;

import java.util.List;

import com.park.entity.CarSpace;
import com.park.entity.ParkinglotInfo;
import com.park.vo.ParkingInformation;



public interface ParkingInfoService {
	public List<ParkinglotInfo>getLocalPark(double longitude,double latitude );
	public ParkinglotInfo getParking_Information(String parking_id);
	public List<ParkinglotInfo> getParkinglotInfoByThumbs();//好评优先获取停车场信息
	public List<ParkingInformation>searchParkByName(String parking_name);//根据停车场的名称模糊查找停车场
	public List<ParkinglotInfo> searchParkByLocation(String parking_location);//根据城市名模糊查找停车场
	public int getEmptyCarSpace(String parking_id);
	public int getCollectUser(String parking_id);
	public List<CarSpace> getAllCarspace(String parking_id);//返回停车场车位信息
	public boolean addAssessCount(String parking_id);//增加评论人数
	public List<ParkinglotInfo> getAllParkinglotInfo();//获取所有停车场信息
}
