<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/view/lib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<script src='<%=basePath%>script/base/index.js' 	type='text/javascript'></script>
    <title>搜奇合创</title>
    
</head> 
<body id="cc" class="easyui-layout"  style="width:100%;height:100%; overflow: hidden;" oncontextmenu=self.event.returnValue=false>
	<div region="north" style="background-color: #ffffff; height: 80px; overflow:hidden">
		<div style="float: left; padding-left: 15px;">
			<img height="75px" src="resource/icon/login/logo1.png" />
		</div>
		<div>
			<div style="float: right; padding-top: 54px; padding-right: 12px;">
				<!--<a href="javascript:void(0);" class="easyui-linkbutton"  plain="true" style="color: black;" onclick="onChangePwd()">修改密码</a>  -->
				<a href="javascript:void(0);" class="easyui-linkbutton"  plain="true"  onclick="onExit()" style="color: black;">退出</a> 
			</div>
		</div> 
	</div>
	<div region="west" title="功能菜单" split=true style="width:220px;">
		<ul id="treeMenu">
			<li>
				<span>客户</span>
					<ul>
						<li>
							<span>客户资料</span>
						</li>
						<li>
							<span>入住记录</span>
						</li> 
						<li>
							<span>操作记录</span>
						</li> 
					</ul> 
			</li>
			<li>
				<span>酒店</span>
					<ul>
						<li>
							<span>服务项目</span>
						</li>
						<li>
							<span>酒店资料</span>
						</li>
						<li>
							<span>房间信息</span>
						</li>
						<li>
							<span>房间类型</span>
						</li>
						<li>
							<span>酒店服务</span>
						</li>
					</ul> 
			</li>
			<li>
				<span>系统</span>
					<ul>
						<li>
							<span>用户资料</span>
						</li>
						<li>
							<span>区域信息</span>
						</li>  
						<li>
							<span>设备类型</span>
						</li> 
						<li>
							<span>控制台</span>
						</li> 
					</ul> 
			</li>
			
		</ul>
	</div> 
	<div region=center title="业务" > 
		<iframe id="ifrContent" frameborder='0'  style="width:100%;height:98%;" onLoad="iframeSize()">
		</iframe>
	</div> 
	<div region="south"  style="background-color: #4974a4; height: 30px; overflow:hidden">
		<table style="padding-top: 4px;">
			<tr>
				<td style="padding-left: 40px;">
					<label style="font-size: 13px; color: white;">当前用户：</label>
				</td>
				<td>
					<label style="font-size: 13px; color: white;" id='userName'>
					</label> 
				</td>
				<td style="padding-left: 40px;">
					<label style="font-size: 13px; color: white;">用户类型：</label>
				</td>
				<td>
					<label style="font-size: 13px; color: white;" id='userType'>
					</label> 
				</td>
			</tr>
		</table>
	</div>
<!-- 修改密码对话框 -->

<!-- <div id="div_changePwd" style="display:none">
	<form action="index/changePwdAction.do" method="post">
		<table style="margin: 20px;">
			<tr style="height: 40px;">
				<td align="right" style="font-size: 12px;">原密码：</td>
				<td><input id="txtOldPassword" type="password" name="password" /></td>
			</tr>
			<tr style="height: 40px;">
				<td align="right" style="font-size: 12px;">新密码：</td>
				<td><input id="txtNewPassword" type="password" name="newPassword" /></td>
			</tr>
			<tr style="height: 40px;">
				<td align="right" style="font-size: 12px;">确认密码：</td>
				<td><input id="txtTooNewPassword" type="password" name="TooNewPassword" /></td>
			</tr>
			<tr style="height: 40px;">
				<td align="center" style="font-size: 12px;"><input type="reset" class="easyui-linkbutton" value="重置" /></td>
				<td align="center" style="font-size: 12px;"><input type="submit" class="easyui-linkbutton" value="确定" /></td>
			</tr>
		</table>
	</form>
</div> -->
</body>
</html>
