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
import com.hotel.model.Customer;
import com.hotel.service.CustomerService;  
import com.hotel.viewmodel.OccupancyVM;
import com.hotel.viewmodel.OperationVM;

/**
 * 客户模块：客户资料、入住记录、操作记录
 * @author mrlee
 *
 */
@Controller
@RequestMapping("/customer")
public class customerController {

	@Autowired CustomerService customerService;
	/**
	 * 获取客户列表，以列表形式呈现；
	 */
	@RequestMapping(value = "getCustomerList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getCustomerList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<Customer> rs = customerService.loadCustomerList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<Customer> rs = new ListResult<Customer>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 获取客户入住记录，以列表形式呈现；
	 */
	@RequestMapping(value = "getOccupancyList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getOccupancyList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<OccupancyVM> rs = customerService.loadOccupancyVMList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<OccupancyVM> rs = new ListResult<OccupancyVM>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 获取客户操作记录，以列表形式呈现；
	 */
	@RequestMapping(value = "getOperationList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getOperationList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<OperationVM> rs = customerService.loadOperationVMList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<OperationVM> rs = new ListResult<OperationVM>(0, null);
			return rs.toJson();
		}
	}
}
