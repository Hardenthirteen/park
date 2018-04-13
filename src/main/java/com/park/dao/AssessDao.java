package com.park.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.entity.Assess;

@Repository
public interface AssessDao {
	public List<Assess> find_ParkingId(String parkingId);//查找所有评论
	public boolean add(Assess assess);		//添加评论
	public boolean delete_phonenumber(String phonenumber);	//删除某个用户的所有评论
	public boolean add_thumbs_up(String parking_id);//给某停车场点赞
	
	public boolean add_check(int check_id);//修改订单评价状态
	
}
