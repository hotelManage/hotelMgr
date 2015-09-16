<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script src='<%=basePath%>script/system/linkInfo.js' 	type='text/javascript'></script> 
    <title>连接信息</title>

  </head>
  
  <body>
  <div id="consoleTab" >  
                <a id="linkBtn" name="linkBtn" href="javascript:void(0);" class="easyui-linkbutton" onclick="LinkInfoManage.onConnection()"
                    iconcls="icon-udq-add" plain="true">连接</a>
                <label id="lblInfo">未连接</label>
                
    </div>
    <div id="linkGrd"  style="margin:10px"></div>  
  </body>
</html>