 
$(function() {    
	var userObj = getCurrentUser();
	if(userObj){
		$("#userName").text(userObj.name);
		var value = userObj.userType;
		if(value==1||value=="1"){
			$("#userType").text("超级管理员");
		}else if(value==2||value=="2"){
			$("#userType").text("普通管理员");
		}else if(value==3||value=="3"){
			$("#userType").text("员工 ");
		}else{
			$("#userType").text("普通管理员");
		} 
	}else{
		location = "login/onExit.do";
	}
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
	case "服务项目":
		src = "view/hotel/itemTagList.jsp";
		break; 
	case "酒店服务":
		src = "view/hotel/hotelItemList.jsp";
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
	case "控制台":
		src = "view/system/linkInfo.jsp";
		break; 
	case "菜单":
		src = "view/app/functionList.jsp";
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