 
$(function() {    
	$('#treeMenu').tree({
		checkbox : false, 
		onClick : onTreeMenuDblClick
	}); 
	var obj = {};
	obj.text = "房间信息";
	onTreeMenuDblClick(obj);
});

/**
 * 点击树菜单操作功能页面
 */
function onTreeMenuDblClick(row) {
	var src = null;  
	switch (row.text) {
	case "客户资料":
		src = "view/customer/customerList.jsp";
		break;
	case "入住记录":
		src = "view/customer/occupancyList.jsp";
		break; 
	case "操作记录":
		src = "view/customer/operationList.jsp";
		break; 
	case "酒店资料":
		src = "view/hotel/hotelList.jsp";
		break; 
	case "房间信息":
		src = "view/hotel/roomList.jsp";
		break; 
	case "房间类型":
		src = "view/hotel/roomTypeList.jsp";
		break; 
	case "用户资料":
		src = "view/system/userList.jsp";
		break;
	case "区域信息":
		src = "view/system/regionList.jsp";
		break;  
	case "设备类型":
		src = "view/system/deviceList.jsp";
		break; 
	}
	$("#ifrContent").attr("src", src); 
}
 
/**
 * 退出主页面，返回登录页面
 */
function onExit() {
	$.messager.confirm("系统提示", "是否退出主页，返回登录页面？", function(r) {
		if (r) {
			location = "login/onExit.do";
		}
	}); 
}
function iframeSize() {
	var ifm = document.getElementById("ifrContent");
	var subWeb = document.frames ? document.frames["ifrContent"].document
			: ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
		ifm.width = subWeb.body.scrollWidth;
	}
}