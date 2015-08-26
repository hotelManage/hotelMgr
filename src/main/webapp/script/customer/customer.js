$(function() { 
	CustomerManage.loadCustomerList(); 
});

var CustomerManage = {
		loadCustomerList : function() {
			$('#customerListGrid').datagrid({
				url : 'customer/getCustomerList.do',
				fitColumns : true,
				rownumbers : true,
				title:"入住客户资料",
				pagination : true,
				pageNumber : 1,
				pageSize : 10,
				nowrap : false,
				idField : 'id',
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
				}, {
					title : '客户',
					field : 'name',
					align : 'center',
					width : 100
				}, {
					title : '性别',
					field : 'sex',
					align : 'center',
					width : 100
				}, {
					title : '身份证号',
					field : 'idcard',
					align : 'center',
					width : 100,
				}, {
					title : '手机',
					field : 'mobile',
					align : 'center',
					width : 100
				}, {
					title : '注册时间',
					field : 'regTime',
					align : 'center',
					width : 100
				} ] ]
			});
		}
};