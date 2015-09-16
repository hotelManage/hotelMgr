<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>入住记录列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src='<%=basePath%>script/customer/occupancy.js'
	type='text/javascript'></script>
</head>

<body>
	<div id="occupancyTb">
		<div>
			<p>
				<a id="addOccupancy" name="addOccupancy" href="javascript:void(0);" 
					class="easyui-linkbutton" iconcls="icon-udq-add" plain="true">新增</a> 
			</p>
		</div>
	</div>
	<div id="occupancyListGrid" style="margin:10px"></div>
	<div style="display:none">
		<div id="div_newOccupancyInfo" style="width:230px;height:270px">
			<p>
				<label>客户名称：</label><input type="hidden" id="customerId" />
				<input type="text" id="customerName" style="width:100%" readonly="readonly" class="easyui-validatebox" />
				<a id="addCustomer" name="addCustomer" href="javascript:void(0);" 
					class="easyui-linkbutton" iconcls="icon-udq-search" plain="true" onclick="OccupancyManage.selectCustomer();">选择</a> 
			</p>
			<p><label>联系电话：</label><input type="text" id="customerPhone" style="width:100%" readonly="readonly" class="easyui-validatebox" /></p>
			<p><label>酒店名称：</label><input type="text" id="hotelName" data-options="editable:false"  class="easyui-combobox" /></p>
			<p><label>房间门号：</label><input type="text" id="roomName" data-options="editable:false"  class="easyui-combobox" /></p>
			<p><label>入住时间：</label><input  id="startTime" data-options="editable:false"  class="easyui-datebox" /></p>
			<p><label>退房时间：</label><input  id="endTime" data-options="editable:false"  class="easyui-datebox" /></p> 
		</div>
	</div>
	<div style="display:none"> 
		<div id="div_customerList">
			<div id="customerList"></div>
		</div>
	</div>
</body>
</html>
