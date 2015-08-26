package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.RegionMapper;
import com.hotel.model.Region;

@Service
public class RegionService {

	@Autowired RegionMapper regionMapper; 
	
	public List<Region> getRegionList(Integer pid) {
		// TODO Auto-generated method stub
		return regionMapper.getRegionList(pid);
	}

}
