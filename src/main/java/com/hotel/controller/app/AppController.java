package com.hotel.controller.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.service.base.CustomerService;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "login.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request, HttpServletResponse response
			) throws Exception{ 
		

		
		
		return null;
	}
	
}
