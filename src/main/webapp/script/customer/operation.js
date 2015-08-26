$(function() { 
	OperationManage.loadOperationList(); 
});

var OperationManage = {
		loadOperationList : function() {
			$('#operationListGrid').datagrid({
				url : 'customer/getOperationList.do',
				fitColumns : true,
				rownumbers : true,
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
					field : 'customerName',
					align : 'center',
					width : 100
				}, {
					title : '房间号',
					field : 'roomNo',
					align : 'center',
					width : 100
				}, {
					title : '入住时间',
					field : 'checkInTime',
					align : 'center',
					width : 100,
				}, {
					title : '退房时间',
					field : 'checkOutTime',
					align : 'center',
					width : 100
				} ] ]
			});
		}
};