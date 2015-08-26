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
				title : '管理员姓名',
				field : 'name',
				align : 'center',
				width : 150,
			},{
				title : '管理员类型',
				field : 'userType',
				align : 'center',
				width : 150
			}, {
				title : '酒店名称',
				field : 'hotelName',
				align : 'center',
				width : 150
			} 
			] ]
		});
	}
};
