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
				title : '�û�����',
				field : 'name',
				align : 'center',
				width : 150,
			},{
				title : '�û�����',
				field : 'userType',
				align : 'center',
				width : 150
			}, {
				title : '�Ƶ����',
				field : 'hotelName',
				align : 'center',
				width : 150
			} 
			] ]
		});
	}
};
