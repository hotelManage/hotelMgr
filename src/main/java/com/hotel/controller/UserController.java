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
import com.hotel.service.UserService;
import com.hotel.viewmodel.UserVM;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService userService;
	
	@RequestMapping(value = "getUserList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String getUserList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);
			ListResult<UserVM> res = userService.loadUserlist(map);
			return res.toJson();
		} catch (Exception ex) {
			ListResult<UserVM> result = new ListResult<UserVM>(0, null);
			return result.toJson();
		}
	}

}
