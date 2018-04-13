package com.park.service;

import java.util.List;

import com.park.entity.Collection;
import com.park.entity.ParkinglotInfo;

public interface CollectionService {
	public boolean addCollection(Collection collection);//添加收藏
	public boolean deleteCollection(Collection collection);//删除收藏
	//public List<ParkinglotInfo> getCollection(String phonenumber);//获取某个用户的所有收藏信息
}
