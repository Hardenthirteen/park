package com.park.service;

import java.util.List;

import com.park.entity.Assess;

public interface AssessService {
	public List<Assess> findByParkingId(String parking_id);//查找某个停车场的所有评论
	public boolean addAssess(Assess assess); //添加评论
	public boolean deleteByPhonenumber(String phonenumber);//删除某个用户的所有评论
	public boolean add_thumbs_up(String parking_id);//给某停车场点赞
	public boolean add_check(int check_id);//修改订单评价状态

}
