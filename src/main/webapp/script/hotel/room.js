$(function() { 
	RoomManage.loadRoomList(); 
});

var RoomManage = {
		loadRoomList : function() {
			$('#roomListGrid').datagrid({
				url : 'hotel/getRoomList.do',
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
					title : '房间号',
					field : 'name',
					align : 'center',
					width : 100
				}, {
					title : '所在楼层',
					field : 'floor',
					align : 'center',
					width : 100,
				}, {
					title : '酒店名称',
					field : 'hotelName',
					align : 'center',
					width : 100
				} , {
					title : '描述说明',
					field : 'note',
					align : 'center',
					width : 100
				}  ] ]
			});
		}
};