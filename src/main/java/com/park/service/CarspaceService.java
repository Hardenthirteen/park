package com.park.service;

import java.text.ParseException;

import com.park.entity.CarSpace;
import com.park.vo.UserCheck;

public interface CarspaceService {
	
	public boolean reserveCarspace(CarSpace car);
	
	public int checkCarspace(CarSpace car);
	
	public boolean parkCarspace(CarSpace car);
	
	public boolean takeCarspace(CarSpace car);
	
	public UserCheck payCheck(CarSpace carspace) throws ParseException;
}
