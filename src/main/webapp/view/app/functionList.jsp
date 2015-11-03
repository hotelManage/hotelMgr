<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>服务项目列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src='<%=basePath%>script/base/ajaxfileupload.js'type='text/javascript'></script>
<script src='<%=basePath%>script/app/functionList.js'
	type='text/javascript'></script>
</head>

<body>
	<div id="functionTb">
		<div>
			<p>
				<a id="addFunction" name="addFunction"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-add"
                    plain="true">新增</a>
                <a id="editFunction" name="editFunction"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-edit"
                    plain="true">修改</a>
                <a id="delFunction" name="delFunction" href="javascript:void(0);" 
                    class="easyui-linkbutton" iconcls="icon-udq-delete"
                    plain="true">删除</a>
			</p>
		</div>
	</div>
	<div id="functionListGrid" style="margin:10px"></div>
	<div style="display:none">
		<div id="div_FunctionInfo" style="width:430px;height:270px">
		<p name="p_img"><img id="functionIcon" style='width:50px;height:50px;float:right;' src="" class="easyui-validatebox" style="width:217px"/></p>
		    <p><label>图&nbsp;&nbsp;标：</label><input type="file" id="icon" name="icon" class="easyui-validatebox" style="width:170px;"/></p>
			<p><label>类&nbsp;&nbsp;型：</label><input type="text" id="functionType" style="width:270px" class="easyui-combobox" data-options="editable:false,valueField:'id',textField:'name',data:[{id: 1,name: '内置功能'},{id: 2,name: '分类查询'}]"/></p>
			<p><label>项&nbsp;&nbsp;目：</label><input type="text" id="functionTag" style="width:270px" class="easyui-combobox" data-options="editable:false"/></p>
			<p><label>位&nbsp;&nbsp;置：</label><input type="text" id="functionSort" style="width:270px" class="easyui-validatebox" /></p>
		</div>
	</div>
</body>
</html>
