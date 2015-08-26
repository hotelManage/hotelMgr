$(function() { 
	RoomTypeManage.loadRoomTypeList(); 
});

var RoomTypeManage = {
		loadRoomTypeList : function() {
			$('#roomTypeListGrid').datagrid({
				url : 'hotel/getRoomTypeList.do',
				fitColumns : true,
				rownumbers : true,
				pagination : true,
				title:"房间类型",
				pageNumber : 1,
				pageSize : 10,
				nowrap : false,
				idField : 'id',
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
				}, {
					title : '房间类型',
					field : 'name',
					align : 'center',
					width : 100
				}, {
					title : '详细描述',
					field : 'note',
					align : 'center',
					width : 100,
				}, {
					title : '酒店名称',
					field : 'hotelName',
					align : 'center',
					width : 100
				}  ] ]
			});
		}
};