<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>酒店项目列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src='<%=basePath%>script/base/ajaxfileupload.js'type='text/javascript'></script>
<script src='<%=basePath%>script/hotel/hotelItem.js'
	type='text/javascript'></script>
</head>

<body>
	<div id="hotelItemTb">
		<div>
			<p>
				<a id="addHotelItem" name="addHotelItem"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-add"
                    plain="true">新增</a>
                <a id="editHotelItem" name="editHotelItem"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-edit"
                    plain="true">修改</a>
                <a id="delHotelItem" name="delHotelItem" href="javascript:void(0);" 
                    class="easyui-linkbutton" iconcls="icon-udq-delete"
                    plain="true">删除</a>
			</p>
		</div>
	</div>
	<div id="hotelItemListGrid" style="margin:10px"></div>
	<div style="display:none">
		<div id="div_HotelItemInfo" style="width:430px;height:270px">
		    <p name="p_img"><img id="itemPhoto" style='width:40px;height:50px;float:right;' src="" class="easyui-validatebox" style="width:217px"/></p>
		    <p><label>酒店名称：</label><input type="text" id="hotelName" style="width:270px" data-options="editable:false" class="easyui-combobox" /></p>
		    <p><label>图&nbsp;&nbsp;片：</label><input type="file" id="icon" name="icon" class="easyui-validatebox" style="width:170px;"/></p>
			<p><label>酒店服务：</label><input type="text" id="hotelItemName" style="width:270px" class="easyui-validatebox" /></p>
			<p><label>项目名称：</label><input id="itemName" style="width:270px" multiple="true" data-options="editable:false" class="easyui-combobox" /></p>
			<p><label>备&nbsp;&nbsp;注：</label><input type="text" id="itemNote" style="width:270px" class="easyui-validatebox" /></p>
			<p><label>电&nbsp;&nbsp;话：</label><input type="text" id="telphone" style="width:270px" class="easyui-validatebox" /></p>
		</div>
	</div>
</body>
</html>
