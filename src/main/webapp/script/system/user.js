$(function() {
	//getCurrentUser();
	UserManage.loadUserList();
});
var UserManage = {
	loadUserList : function() {
		$('#userListGrid').datagrid({
			url : 'user/getUserList.do',
			title :"管理用户列表",
			fitColumns : true,
			rownumbers : true,
			pagination : true,
			pageNumber : 1,
			pageSize : 10,
			nowrap : false,
			idField : 'id',
			singleSelect : true,
			//onDblClickRow : UserManage.editUser,
			//toolbar : "#userTb",
			columns : [ [ {
				title : 'id',
				field : 'id',
				hidden : true
			}, {
				title : '用户名',
				field : 'name',
				align : 'center',
				width : 150,
			},{
				title : '用户类型',
				field : 'userType',
				align : 'center',
				width : 150,
				formatter:function(value,rowData,index){
					if(value==1||value=="1"){
						return "超级管理员";
					}else if(value==2||value=="2"){
						return "普通管理员";
					}else if(value==3||value=="3"){
						return "员工 ";
					}else{
						return "普通管理员";
					}
				}
			}, {
				title : '所属酒店',
				field : 'hotelName',
				align : 'center',
				width : 150
			} 
			] ]
		});
	}
};
