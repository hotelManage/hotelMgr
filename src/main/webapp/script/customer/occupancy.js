$(function() { 
	OccupancyManage.loadOccupancyList(); 
});

var OccupancyManage = {
		loadOccupancyList : function() {
			$('#occupancyListGrid').datagrid({
				url : 'customer/getOccupancyList.do',
				fitColumns : true,
				rownumbers : true,
				title:"客户入住记录",
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
					title : '酒店名称',
					field : 'hotelName',
					align : 'center',
					width : 100
				},  {
					title : '楼层号',
					field : 'floor',
					align : 'center',
					width : 100
				},  {
					title : '房间号',
					field : 'roomName',
					align : 'center',
					width : 100
				}, {
					title : '入住时间',
					field : 'checkinTime',
					align : 'center',
					width : 100,
				}, {
					title : '退房时间',
					field : 'checkoutTime',
					align : 'center',
					width : 100
				} ] ]
			});
		}
};