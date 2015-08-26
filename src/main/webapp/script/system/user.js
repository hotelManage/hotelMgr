$(function() {
	//getCurrentUser();
});
var UserManage = {
	loadUserList : function() {
		$('#userListGrid').datagrid({
			url : 'user/getUserList.do',
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
				title : '用户姓名',
				field : 'name',
				align : 'center',
				width : 150,
			},{
				title : '用户类型',
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
