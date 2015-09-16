package com.hotel.controller.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.core.Result;
import com.hotel.model.base.Customer;
import com.hotel.service.base.CustomerService;
import com.hotel.viewmodel.base.CustomerRoomInfo;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private CustomerService customerService;
	
	/**
	 * app用户登录
	 * @param mobile
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "login.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(
			@RequestParam(value = "mobile", required = true) String mobile,
			@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request, HttpServletResponse response
			) throws Exception{ 
		
		CustomerRoomInfo cri=customerService.loadInfoByMobileAndPsd(mobile, password);
		
		Result<CustomerRoomInfo> result=new Result<CustomerRoomInfo>(cri);
		
		return result.toJson();
	}
	
}
