package com.park.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.CollectionDao;
import com.park.entity.Collection;
import com.park.entity.ParkinglotInfo;
import com.park.service.CollectionService;
@Repository("collectionService")
public class CollectionServiceImpl implements CollectionService{
	@Autowired
	public CollectionDao collectionDao;
	public boolean addCollection(Collection collection) {
		// TODO Auto-generated method stub
		boolean result=collectionDao.addCollection(collection);
		return result;
	}

	public boolean deleteCollection(Collection collection) {
		// TODO Auto-generated method stub
		boolean result=collectionDao.deleteCollection(collection);
		return result;
	}
	/*
	@Override
	public List<ParkinglotInfo> getCollection(String phonenumber) {
		// TODO Auto-generated method stub
		List<ParkinglotInfo> parkinglotInfos=collectionDao.getCollection(phonenumber);
		return parkinglotInfos;
	}
	*/
}
