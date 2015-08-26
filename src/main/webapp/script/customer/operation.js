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
				title:"客户操作记录",
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
					field : 'roomName',
					align : 'center',
					width : 100
				}, {
					title : '酒店名称',
					field : 'hotelName',
					align : 'center',
					width : 100
				}, {
					title : '楼层',
					field : 'floor',
					align : 'center',
					width : 100
				},  {
					title : '操作时间',
					field : 'stateTime',
					align : 'center',
					width : 100,
				}, {
					title : '操作设备',
					field : 'deviceType',
					align : 'center',
					width : 100,
					formatter:function(value,rowData,index){
						if(value==1||value=="1"){
							return "空调设备";
						}else if(value==2||value=="2"){
							return "地暖设备";
						}else if(value==3||value=="3"){
							return "窗帘设备";
						}else if(value==4||value=="4"){
							return "灯光设备";
						}else if(value==5||value=="5"){
							return "音像设备";
						}
					}
				}, {
					title : '操作结果',
					field : 'value',
					align : 'center',
					width : 100,
					formatter:function(value,rowData,index){
						if(value==0||value=="0"){
							return "关闭设备";
						}else if(value==1||value=="1"){
							return "开启设备";
						}else if(value==2||value=="2"){
							return "调节空调温度";
						}else if(value==3||value=="3"){
							return "调节窗帘设备";
						}else if(value==4||value=="4"){
							return "调节灯光设备";
						}else if(value==5||value=="5"){
							return "调节音像设备";
						}else if(value==6||value=="6"){
							return "调节空调设备";
						}
					}
				}, {
					title : '操作类型',
					field : 'ctlType',
					align : 'center',
					width : 100,
					formatter:function(value,rowData,index){
						if(value==1||value=="1"){
							return "App控制";
						}else{
							return "RCU上传";
						}
					}
				}, {
					title : 'RCU编号',
					field : 'rcuNo',
					align : 'center',
					width : 100
				} ] ]
			});
		}
};