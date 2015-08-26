$(function() { 
	DeviceManage.loadDeviceList(); 
});

var DeviceManage = {
		loadDeviceList : function() {
			$('#deviceListGrid').datagrid({
				url : 'system/getDeviceList.do',
				fitColumns : true,
				rownumbers : true,
				title:"酒店设备类型",
				pagination : false,
				nowrap : false,
				idField : 'id',
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
				}, {
					title : '设备类型名称',
					field : 'name',
					align : 'center',
					width : 100
				}, {
					title : '备注说明',
					field : 'note',
					align : 'center',
					width : 100
				} ] ]
			});
		}
};