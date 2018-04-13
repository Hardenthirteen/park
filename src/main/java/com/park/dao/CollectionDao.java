package com.park.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.entity.Collection;
import com.park.entity.ParkinglotInfo;
@Repository
public interface CollectionDao {
	public boolean addCollection(Collection collection);//添加收藏
	public boolean deleteCollection(Collection collection);//删除收藏
}
