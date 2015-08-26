package com.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.core.ListResult;
import com.hotel.viewmodel.DeviceVM;

/**
 * 系统管理模块：设备类型
 * @author mrlee
 *
 */
@Controller
@RequestMapping("/system")
public class systemController {
	
	
	/**
	 * 获取酒店列表，以列表形式呈现；
	 */
	@RequestMapping(value = "getDeviceList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getDeviceList(HttpServletRequest request) throws Exception {
		try {
			int count = 0;
			List<DeviceVM> ls = new ArrayList<DeviceVM>();
			DeviceVM d1 = new DeviceVM();
			d1.setId(1);
			d1.setName("空调");
			d1.setNote("空调设备");
			ls.add(d1);
			DeviceVM d2 = new DeviceVM();
			d2.setId(2);
			d2.setName("地暖");
			d2.setNote("地暖设备");
			ls.add(d2);
			DeviceVM d3 = new DeviceVM();
			d3.setId(3);
			d3.setName("灯光");
			d3.setNote("灯光设备");
			ls.add(d3);
			DeviceVM d4 = new DeviceVM();
			d4.setId(4);
			d4.setName("音像");
			d4.setNote("音像设备");
			ls.add(d4);
			DeviceVM d5 = new DeviceVM();
			d5.setId(5);
			d5.setName("窗帘");
			d5.setNote("窗帘设备"); 
			ls.add(d5);
			ListResult<DeviceVM> result=new ListResult<DeviceVM>(count,ls); 
			return result.toJson();
		} catch (Exception ex) {
			ListResult<DeviceVM> rs = new ListResult<DeviceVM>(0, null);
			return rs.toJson();
		}
	}
}
