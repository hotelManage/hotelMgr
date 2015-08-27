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
					width : 100,
					formatter:function(value,rowData,index){
						if(value||value==1||value==0){
							return "男";
						}else{
							return "女";
						}
					}
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
					title : '记录时间',
					field : 'regTime',
					align : 'center',
					width : 100
				} ] ]
			});
		}
};