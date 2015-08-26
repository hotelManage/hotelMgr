package com.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.core.ListResult; 
import com.hotel.model.Hotel;
import com.hotel.service.HotelService; 
import com.hotel.viewmodel.HotelVM;
import com.hotel.viewmodel.RoomTypeVM;
import com.hotel.viewmodel.RoomVM;

/**
 * 酒店模块：酒店资料、房间信息、房间类型
 * @author mrlee
 *
 */
@Controller
@RequestMapping("/hotel")
public class hotelController {

	@Autowired HotelService hotelService;
	/**
	 * 获取酒店列表，以列表形式呈现；
	 */
	@RequestMapping(value = "getHotelList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getHotelList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<HotelVM> rs = hotelService.loadHotelList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<Hotel> rs = new ListResult<Hotel>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 获取房间信息记录，以列表形式呈现；
	 */
	@RequestMapping(value = "getRoomList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getRoomList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<RoomVM> rs = hotelService.loadRoomList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<RoomVM> rs = new ListResult<RoomVM>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 获取客户入住记录，以列表形式呈现；
	 */
	@RequestMapping(value = "getRoomTypeList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getRoomTypeList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<RoomTypeVM> rs = hotelService.loadRoomTypeList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<RoomTypeVM> rs = new ListResult<RoomTypeVM>(0, null);
			return rs.toJson();
		}
	}
}
