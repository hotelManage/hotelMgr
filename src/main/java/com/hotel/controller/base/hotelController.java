package com.hotel.controller.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hotel.core.GeneralUtil;
import com.hotel.core.ListResult; 
import com.hotel.core.Result;
import com.hotel.dao.base.ItemTagMapper;
import com.hotel.model.base.Hotel;
import com.hotel.model.base.HotelItem;
import com.hotel.model.base.ItemContent;
import com.hotel.model.base.ItemTag;
import com.hotel.model.base.ItemTagAssociation;
import com.hotel.model.base.Occupancy;
import com.hotel.service.base.HotelService;
import com.hotel.test.service.TestService;
import com.hotel.viewmodel.base.HotelItemVM;
import com.hotel.viewmodel.base.HotelVM;
import com.hotel.viewmodel.base.ItemTagAssociationVM;
import com.hotel.viewmodel.base.RoomTypeVM;
import com.hotel.viewmodel.base.RoomVM;

/**
 * 酒店模块：酒店资料、房间信息、房间类型、酒店服务
 * @author mrlee
 *
 */
@Controller
@RequestMapping("/hotel")
public class hotelController {

	@Autowired HotelService hotelService;
	@Autowired TestService testService;
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
	/**
	 * 获取酒店服务列表，以列表形式呈现
	 */
	@RequestMapping(value = "getHotelItemList.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getHotelItemList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request)  throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<HotelItemVM> rs = hotelService.loadHotelItemList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<HotelItemVM> rs = new ListResult<HotelItemVM>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 获取所有服务项目列表，以列表形式呈现
	 */
	@RequestMapping(value = "getItemTagList.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getItemTagList(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			HttpServletRequest request)  throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			page = page == 0 ? 1 : page;
			map.put("pageStart", (page - 1) * rows);
			map.put("pageSize", rows);  
			ListResult<ItemTag> rs = hotelService.loadItemTagList(map);
			return rs.toJson();
		} catch (Exception ex) {
			ListResult<ItemTag> rs = new ListResult<ItemTag>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 加载关联表ItemTagAssociation
	 */
	@RequestMapping(value = "getItemTagAssociationList.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getItemTagAssociationList(
			@RequestParam(value = "itemId", required = false) Integer itemId,
			HttpServletRequest request)  throws Exception {
		try { 
			List<ItemTagAssociation> list = hotelService.loadItemTagAssociationList(itemId);
			ItemTagAssociationVM ita = new ItemTagAssociationVM();
			List ids = new ArrayList();
			List tagIds = new ArrayList();
			for(int i=0;i<list.size();i++){
				ItemTagAssociation obj=list.get(i);
				ids.add(i, obj.getId());
				tagIds.add(i, obj.getTagId());
			}
			ita.setIds(ids);
			ita.setTagIds(tagIds);
			Result<ItemTagAssociationVM> result = new Result<ItemTagAssociationVM>(ita,true,"成功获取");
			return result.toJson();
		} catch (Exception ex) {
			ListResult<ItemTagAssociation> rs = new ListResult<ItemTagAssociation>(0, null);
			return rs.toJson();
		}
	}
	/**
	 * 获取所有服务项目，以下拉 多选列表形式呈现
	 */
	@RequestMapping(value = "getItemTagComboList.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getItemTagComboList(
			HttpServletRequest request)  throws Exception {
		try {
			List<ItemTag> list = hotelService.loadItemTagComboList();
			JSONArray result = JSONArray.fromObject(list);
			return result.toString();
		} catch (Exception ex) {
			return "";
		}
	}
	/**
	 * 项目ItemTag新增、更新
	 * @param item
	 * @param icon
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "saveItemTag.do")
	public @ResponseBody String saveItemTag(ItemTag item,
			@RequestParam MultipartFile icon,HttpServletRequest request) {
		Result<ItemTag> result = new Result<ItemTag>();
		try {
			ItemTag itemTag = hotelService.selectItemTagByName(item.getName());
			String path = getClass().getResource("/").getFile().toString();
			path = path.substring(0, (path.length() - 16))+"icon";
			//以当前日期+时间来命名图标
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
			//如果上传了图片就放到item中，没有上传则新增时就为空，编辑时还是原来的图片
			String fileName = icon.getOriginalFilename();
			if(fileName!=null&&fileName != ""){
				item.setIconUrl(iconUrl);
			}
		
			if (item.getId() > 0) {
				hotelService.updateItemTag(item);
			} else {
				if(itemTag !=null){
					result = new Result<ItemTag>(null,false,
							"The item already exists!");
					return result.toJson();
				}
				hotelService.insertItemTag(item);
			}
			result = new Result<ItemTag>(null, true, false, false,
					path);
			return result.toJson();
		} catch (Exception ex) {
			result = new Result<ItemTag>(null, false, false, false,
					ex.getMessage());
			return result.toJson();
		}
	}
	/**
	 * 酒店item新增、编辑
	 */
	@RequestMapping(value = "saveHotelItem.do")
	public @ResponseBody String saveHotelItem(HotelItemVM item,
			@RequestParam MultipartFile icon,HttpServletRequest request) {
		Result<HotelItemVM> result = new Result<HotelItemVM>(); 
		try {
			String path = getClass().getResource("/").getFile().toString();
			path = path.substring(0, (path.length() - 16))+"photo";
			//以当前日期+时间来命名图片
			Map<String, Object> m = GeneralUtil.getCurrentDate();
			String date = (String) m.get("currentTime");
			String iconName = date+".jpg";
			String iconUrl = "photo/"+iconName;
			Integer height = null;
			Integer width = null;
			if(icon.getSize()>0){
				File targetFile = new File(path, iconName);  
				if(!targetFile.exists()){  
					targetFile.mkdirs();  
				}  
				//保存  
				icon.transferTo(targetFile);  
			
			   /*取图片的尺寸*/
			   File file = new File(path+"/"+iconName);
			   BufferedImage sourceImg =ImageIO.read(new FileInputStream(file));
			   height = sourceImg.getHeight();
			   width = sourceImg.getWidth();
			}
			//如果上传了图片就放到item中，没有上传则新增时就为空，编辑时还是原来的图片
			String fileName = icon.getOriginalFilename();
			if(fileName!=null&&fileName != ""){
				item.setUrl(iconUrl);
			}
			
			ItemContent ic = new ItemContent();
			ic.setFileName(iconName);
			ic.sethPix(height);
			ic.setwPix(width);
			ic.setIndex(1);
			if (item.getId() > 0) {
				hotelService.update(item,ic);
			} else {
				//testService.insertTest(item,ic);
				hotelService.insert(item,ic);
			}
			result = new Result<HotelItemVM>(null, true, false, false,
					path);
			return result.toJson();
		} catch (Exception ex) {
			result = new Result<HotelItemVM>(null, false, false, false,
					ex.getMessage());
			return result.toJson();
		}
	}
	/**
	 * 删除服务项目ItemTag
	 */
	@RequestMapping(value = "deleteItemTag.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteItemTag(
			@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request)  throws Exception {
		Result<ItemTag> result = new Result<ItemTag>();
		try {
			ItemTag item = new ItemTag();
			item.setId(id);
			item.setIsUsed(false);
			hotelService.updateItemTag(item);
			result = new Result<ItemTag>(null,true,"删除成功");
			return result.toJson();
		} catch (Exception ex) {
			result = new Result<ItemTag>(null,true,ex.getMessage());
			return result.toJson();
		}
	}
	/**
	 * 删除酒店服务Item
	 */
	@RequestMapping(value = "deleteHotelItem.do", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteHotelItem(
			@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request)  throws Exception {
		Result<HotelItem> result = new Result<HotelItem>();
		try {
			HotelItem item = new HotelItem();
			item.setId(id);
			item.setIsUsed(false);
			hotelService.updateHotelItem(item);
			result = new Result<HotelItem>(null,true,"删除成功");
			return result.toJson();
		} catch (Exception ex) {
			result = new Result<HotelItem>(null,true,ex.getMessage());
			return result.toJson();
		}
	}
	/**
	 * 保存入住信息
	 */
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
