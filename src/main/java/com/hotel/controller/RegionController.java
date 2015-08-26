package com.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.service.RegionService;
import com.hotel.viewmodel.RegionVM;

@Controller
@RequestMapping("/region")
public class RegionController {

	@Autowired RegionService regionService;
	
	@RequestMapping(value = "getRegionList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String getRegionList(
			@RequestParam(value = "id", required = false) Integer hybrid_id,
			@RequestParam(value = "parentid", required = false) Integer parentid,
			HttpServletRequest request, HttpServletResponse response
			){
		Integer pid = null;  
		List<RegionVM> ls = new ArrayList<RegionVM>();
		List<RegionVM> list = new ArrayList<RegionVM>();
		if (hybrid_id != null) {
			pid = hybrid_id;  
		} else {
			pid = parentid;
		}   
		ls = regionService.getRegionList(pid); 
		list = getNodes(ls,pid);
		JSONArray  json = JSONArray.fromObject(list);
		String resutl  = json.toString();
		return resutl;
	}
	private List<RegionVM> getNodes(List<RegionVM> ls, Integer pid) {
		// TODO Auto-generated method stub
		List<RegionVM> list = new ArrayList<RegionVM>(); 
		for(RegionVM o :ls ){
			if(o.getParentId() == pid){
				RegionVM v = new RegionVM();
				v.setId(o.getId());
				v.setPath(o.getPath());
				v.setParentId(o.getParentId()); 
				v.setLevel(o.getLevel());
				v.setName(o.getName());
				List<RegionVM> l = getItemByParentId(o.getId());
				if(l.size()>0){ 
					v.setChildren(getNodes(l,o.getId())); 
				}else{
					v.setChildren(null); 
				}
				list.add(v);
			}
		}
		return list;
	}
	private List<RegionVM> getItemByParentId(Integer id) {
		// TODO Auto-generated method stub
		List<RegionVM> ls = regionService.getRegionList(id); 
		return ls;
	}
}
