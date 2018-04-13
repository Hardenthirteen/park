package com.park.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.entity.CarSpace;
import com.park.entity.ParkinglotInfo;

@Repository
public interface ParkingInfoDao {
	
	public List<ParkinglotInfo> getAllParkinglotInfo();//获取所有停车场信息
	
	public List<ParkinglotInfo> searchParkByName(String parking_name);//根据停车场的名称模糊查找停车场
	
	public List<ParkinglotInfo> searchParkByLocation(String parking_location);//根据城市名模糊查找停车场

	public List<ParkinglotInfo> getParkinglotInfoByThumbs();//好评优先获取停车场信息
	//根据停车场编号获取停车场的空余车位数
	public int emptyCarspace(String parking_id);
	
	//根据停车场编号获取收藏停车场的人数
	public int getCollectUser(String parking_id);
	//获取本地车位信息（未实现）
	public List<ParkinglotInfo>getLocalPark(double longitude,double latitude );
	
	public List<CarSpace> getAllCarspace(String parking_id);
	
	public boolean addAssessCount(String parking_id);//增加评论人数
	
	/*
	 * 1.根据id查看某个停车场的空闲、收藏
	 * 2.根据名称查找停车场
	 */

}
