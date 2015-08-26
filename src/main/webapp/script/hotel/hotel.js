$(function() { 
	HotelManage.loadHotelList(); 
});

var HotelManage = {
		loadHotelList : function() {
			$('#hotelListGrid').datagrid({
				url : 'hotel/getHotelList.do',
				fitColumns : true,
				rownumbers : true,
				pagination : true,
				title:"酒店资料",
				pageNumber : 1,
				pageSize : 10,
				nowrap : false,
				idField : 'id',
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
				}, {
					title : '酒店名称',
					field : 'name',
					align : 'center',
					width : 100
				}, {
					title : '所在地区',
					field : 'regionName',
					align : 'center',
					width : 100
				}, {
					title : '备注',
					field : 'note',
					align : 'center',
					width : 100,
				}  ] ]
			});
		}
};