<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script src='<%=basePath%>script/system/region.js' 	type='text/javascript'></script> 
    <title>区域列表</title>

  </head>
  
  <body>
  <div id="regionTb" style="display:none">  
                <a id="addRegion" name="AddRegion" href="javascript:void(0);" class="easyui-linkbutton"
                    iconcls="icon-udq-add" plain="true">新增</a> 
                <a id="editRegion" name="EditRegion"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-edit"
                    plain="true">编辑</a>
                <a id="delRegion" name="Delregion"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-delete"
                    plain="true">删除</a> 
    </div>
    <div id="RegionTree"  style="margin:10px"></div>  
  </body>
</html>
