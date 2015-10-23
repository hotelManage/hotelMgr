package com.hotel.controller.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.core.ListResult; 
import com.hotel.core.Result;
import com.hotel.model.base.Hotel;
import com.hotel.model.base.Occupancy;
import com.hotel.service.base.HotelService;
import com.hotel.viewmodel.base.HotelVM;
import com.hotel.viewmodel.base.RoomTypeVM;
import com.hotel.viewmodel.base.RoomVM;

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
	/**
	 * 获取酒店列表，以下拉列表形式呈现；
	 */
	@RequestMapping(value = "getHotelComboList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getHotelComboList() throws Exception {
		try {
			List<HotelVM> list = hotelService.loadHotelComboList();
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}
	/**
	 * 获取房间列表，以下拉列表形式呈现；传入参数为酒店id
	 */
	@RequestMapping(value = "getRoomListByHotleId.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getRoomListByHotleId(
			@RequestParam(value = "id", required = false) Integer id) throws Exception {
		try {
			List<RoomVM> list = hotelService.loadRoomComboList(id);
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}
	@RequestMapping(value = "saveOccupancy.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String saveOccupancy(HttpServletRequest request, Occupancy occupancy)  throws Exception {
		try {
			boolean isSuccess = false;
			String msg = "";    
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			occupancy.setCheckinTime(sdf.parse(occupancy.getCheckInTimeStr()));
			occupancy.setCheckoutTime(sdf.parse(occupancy.getCheckOutTimeStr()));
			int itemId = 0;
			itemId = hotelService.insertOccupancy(occupancy);
			if (itemId > 0) { 
				isSuccess = true;
				msg = "保存成功";
			}
			Result<Occupancy> result = new Result<Occupancy>(occupancy, isSuccess,
					msg);
			return result.toJson();
		} catch (Exception ex) {
			Result<Occupancy> result = new Result<Occupancy>(null, false,
					ex.getMessage());
			return result.toJson();
		}
	}
	
}
