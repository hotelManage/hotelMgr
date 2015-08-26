<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>房间类型列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src='<%=basePath%>script/hotel/roomType.js'
	type='text/javascript'></script>
</head>

<body>
	<div id="roomTypeTb">
		<div>
			<p>
				<a id="showAuto" name="showAuto" href="javascript:void(0);" 
					class="easyui-linkbutton" iconcls="icon-udq-show" plain="true">查看</a> 
			</p>
		</div>
	</div>
	<div id="roomTypeListGrid" style="margin:10px"></div>
</body>
</html>
