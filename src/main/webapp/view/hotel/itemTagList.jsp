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
<script src='<%=basePath%>script/hotel/itemTag.js'
	type='text/javascript'></script>
</head>

<body>
	<div id="itemTagTb">
		<div>
			<p>
				<a id="addItemTag" name="addItemTag"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-add"
                    plain="true">新增</a>
                <a id="editItemTag" name="editItemTag"
                    href="javascript:void(0);" class="easyui-linkbutton" iconcls="icon-udq-edit"
                    plain="true">修改</a>
                <a id="delItemTag" name="delItemTag" href="javascript:void(0);" 
                    class="easyui-linkbutton" iconcls="icon-udq-delete"
                    plain="true">删除</a>
			</p>
		</div>
	</div>
	<div id="itemTagListGrid" style="margin:10px"></div>
	<div style="display:none">
		<div id="div_ItemTagInfo" style="width:430px;height:270px">
		    <p name="p_img"><img id="itemTagIcon" style='width:50px;height:50px;float:right;' src="" class="easyui-validatebox" style="width:217px"/></p>
		    <p><label>图&nbsp;&nbsp;标：</label><input type="file" id="icon" name="icon" class="easyui-validatebox" style="width:170px;"/></p>
			<p><label>服务名称：</label><input type="text" id="itemTagName" style="width:270px" class="easyui-validatebox" /></p>
			<p><label>备&nbsp;&nbsp;注：</label><input type="text" id="itemTagNote" style="width:270px" class="easyui-validatebox" /></p>
		</div>
	</div>
</body>
</html>
