package com.hotel.controller.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hotel.core.GeneralUtil;
import com.hotel.core.ListResult;
import com.hotel.core.Result;
import com.hotel.model.base.HotelItem;
import com.hotel.model.base.ItemContent;
import com.hotel.model.base.ItemTag;
import com.hotel.model.base.MainFunction;
import com.hotel.service.base.CustomerService;
import com.hotel.service.base.MainFunctionService;
import com.hotel.viewmodel.base.HotelItemVM;
import com.hotel.viewmodel.base.MainFunctionVM;

@Controller
@RequestMapping("/app")
public class FunctionController {
	@Autowired MainFunctionService functionService;
	
	/**
	 * 加载菜单列表，以列表形式呈现
	 * @param function
	 * @param icon
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getFunctionList.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String getFunctionList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request)  throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<MainFunctionVM> rs = functionService.loadFunctionList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<MainFunctionVM> rs = new ListResult<MainFunctionVM>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 菜单新增、编辑
	 */
	@RequestMapping(value = "saveFunction.do")
	public @ResponseBody String saveHotelItem(MainFunction function,
			@RequestParam MultipartFile icon,HttpServletRequest request) {
		Result<MainFunction> result = new Result<MainFunction>(); 
		try {
			String path = getClass().getResource("/").getFile().toString();
			path = path.substring(0, (path.length() - 16))+"icon";
			//以当前日期+时间来命名图片
			Map<String, Object> m = GeneralUtil.getCurrentDate();
			String date = (String) m.get("currentTime");
			String iconName = date+".jpg";
			String iconUrl = "icon/"+iconName;
			if(icon.getSize()>0){
				File targetFile = new File(path, iconName);  
				if(!targetFile.exists()){  
					targetFile.mkdirs();  
				}  
				//保存  
				icon.transferTo(targetFile);
			}
			//如果上传了图标就放到function中，没有上传则新增时就为空，编辑时还是原来的图片
			String fileName = icon.getOriginalFilename();
			if(fileName!=null&&fileName != ""){
				function.setIconUrl(iconUrl);
			}
			if (function.getId() > 0) {
				functionService.updateFunction(function);
			} else {
				functionService.insertFuncton(function);
			}
			result = new Result<MainFunction>(null, true, false, false,
					path);
			return result.toJson();
		} catch (Exception ex) {
			result = new Result<MainFunction>(null, false, false, false,
					"保存失败!");
			return result.toJson();
		}
	}
	/**
	 * 删除菜单
	 */
	@RequestMapping(value = "deleteFunction.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteFunction(
			@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request)  throws Exception {
		Result<MainFunction> result = new Result<MainFunction>();
		try {
			functionService.deleteFunction(id);
			result = new Result<MainFunction>(null,true,"删除成功");
			return result.toJson();
		} catch (Exception ex) {
			result = new Result<MainFunction>(null,true,"删除失败");
			return result.toJson();
		}
	}

}
