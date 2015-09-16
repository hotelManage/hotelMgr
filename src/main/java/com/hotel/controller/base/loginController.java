package com.hotel.controller.base;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.core.Result;
import com.hotel.model.base.User;
import com.hotel.service.base.CustomerService;
import com.hotel.service.base.LoginService;
import com.hotel.service.base.RoomService;
import com.hotel.viewmodel.base.CustomerRoomInfo;
import com.hotel.viewmodel.base.RoomVM;
 

/**
 * 登录、注销
 * @author mrlee
 *
 */
@Controller
@RequestMapping("/login")
public class loginController {

	@Autowired CustomerService customerService;
	@Autowired LoginService loginService;
	@Autowired RoomService roomService;
	
	@RequestMapping(value = "login.do", produces = "application/json;charset=UTF-8")
	 @ResponseBody
	public void login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request, HttpServletResponse response
			) throws Exception{ 
		try {
			
			CustomerRoomInfo c = customerService.loadInfoByMobileAndPsd("13981970816", "96e79218965eb72c92a549dd5a330112");
			
			if (username.isEmpty()) {
				response.sendRedirect("../login.jsp?optType=0");
				return;
			}
			if (password.isEmpty()) {
				response.sendRedirect("../login.jsp?optType=1");
				return;
			}
			HttpSession session = request.getSession();
			if (username.trim().length() == 0) {
				response.sendRedirect("../login.jsp?optType=0");
				return;
			}
			if (password.trim().length() == 0) {
				response.sendRedirect("../login.jsp?optType=1");
				return;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			String nPwd = encryption(password);
			map.put("name", username);
			map.put("psd", nPwd);
			User u = loginService.loadUserByNameAndPwd(map);
			if (u != null) {
				session.setAttribute("user", u);
				response.sendRedirect("../index.jsp");
			} else {
				response.sendRedirect("../login.jsp?optType=3");
				return;
			}
		}catch(Exception ex){ 
			response.sendRedirect("../login.jsp?optType=4");
			return;
		}
	}	
	
	
	/**
	 * 退出主页，返回登录页面
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "onExit.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	void onExit(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.getSession().invalidate();// 清除当前用户相关的session对象
		response.sendRedirect("../login.jsp"); 
	}
	
	/**
	 * 退出主页，返回登录页面
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "getCurrentUser.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getCurrentUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try{
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			
			String message="";
			boolean isSessionExpired = false;
			boolean isSuccess = true;
			if(user == null)
			{
				isSessionExpired = true;
				isSuccess = false;
				message = "Session过期，请重新登录";
			}
			Result<User> s = new Result<User>(user, isSuccess,
					isSessionExpired, false, message);
			return s.toJson();
		} catch (Exception ex) {
			String message = "Session过期，请重新登录";
			Result<User> s = new Result<User>(null, false, true,
					false, message);
			return s.toJson();
		}
	}
	
	/**
	 * 
	 * @param plainText
	 *            明文
	 * @return 32位密文
	 */
	public String encryption(String plainText) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}
}
