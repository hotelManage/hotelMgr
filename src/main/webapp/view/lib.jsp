<%@ page language="java" pageEncoding="utf-8"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/"; 
%>
   
<link href='<%=basePath%>css/easyui/icon.css'	media='all' rel='stylesheet' type='text/css' />
<link href='<%=basePath%>css/jquery.loadmask.css'	media='all' rel='stylesheet' type='text/css' />
<link href='<%=basePath%>css/easyui/bootstrap/easyui.css'	media='all' rel='stylesheet' type='text/css' /> 
<link href='<%=basePath%>css/fontawesome/css/font-awesome.min.css'	media='all' rel='stylesheet' type='text/css' />  
<link href='<%=basePath%>css/dialog.default.css'	media='all' rel='stylesheet' type='text/css' /> 

<script src='<%=basePath%>script/base/jquery-1.11.1.min.js'	type='text/javascript'></script>
<script src='<%=basePath%>script/easyui/jquery.easyui.1.4.1.min.js'	type='text/javascript'></script>
<script src='<%=basePath%>script/base/jquery.loadmask/jquery.loadmask.min.js'	type='text/javascript'></script>
<script src='<%=basePath%>script/base/jquery.artDialog.js'	type='text/javascript'></script>

<script src='<%=basePath%>script/base/json2.js' type='text/javascript'></script>
<script src='<%=basePath%>script/easyui/easyui-lang-zh_CN.js' type='text/javascript'></script> 
<script src='<%=basePath%>script/base/common.js' type='text/javascript'></script> 



