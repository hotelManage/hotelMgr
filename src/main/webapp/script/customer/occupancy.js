$(function() { 
	OccupancyManage.loadOccupancyList(); 
	$("#addOccupancy").bind("click",OccupancyManage.addNewOccupancy());
});
var m_OccupancyInfo_dlg;
var m_customer_dlg;
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
				singleSelect:true,
				toolbar: "#occupancyTb",
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
		},
		addNewOccupancy:function(){
			m_OccupancyInfo_dlg = art
			.dialog({
				id : 'dlgOccupancyInfo',
				title : '新增入住记录',   
				width: 250, 
				height: 300,
				content : document.getElementById("div_newOccupancyInfo"),
				lock : false,
				initFn : function() { 
					$("#hotelName").combobox({
						url:'hotel/getHotelComboList.do',  
					    valueField:'id',  
					    textField:'text' ,
					    onSelect:OccupancyManage.loadRoomList
					}); 
					$('#customerList').datagrid({
						url : 'customer/getCustomerList.do',
						fitColumns : true,
						rownumbers : true,
						title:"客户资料",
						pagination : true,
						pageNumber : 1,
						pageSize : 10,
						singleSelect:true,
						onDblClickRow : OccupancyManage.selectCustomerAction,
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
						} ] ]
					});
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 OccupancyManage.selectCustomerAction();
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消'
		                 }
		            ]
			});
		},
		loadRoomList:function(record){
			$("#roomName").combobox({
				url:'hotel/getRoomListByHotleId.do?id='+record.id,  
			    valueField:'id',  
			    textField:'text' 
			}); 
		},
		selectCustomer:function(){
			m_customer_dlg = art
			.dialog({
				id : 'dlgOccupancyInfo',
				title : '客户选择',   
				width: 250, 
				height: 300,
				content : document.getElementById("div_customerList"),
				lock : false,
				initFn : function() {  
				},
		        button: [
		                 {
		                     name: '确定',
		                     callback: function () { 
		                    	 OccupancyManage.selectCustomerAction();
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消'
		                 }
		            ]
			});
		},
		selectCustomerAction:function(){
			var dataRows = $('#customerList').datagrid('getRows');
			if (dataRows.length == 0) {
				$.messager.alert('操作提示', "没有可选择客户", "warning");
				return;
			}
			var target = $("#customerList").datagrid("getChecked");
			if (!target || target.length == 0) {
				$.messager.alert('操作提示', "请选择入住的客户!", "warning");
				return;
			} 
			if (target.length > 0) {
				$.messager.alert('操作提示', "只能选择单个客户!", "warning");
				return;
			}
			var customerId = target[0].id;
			var customerName = target[0].name;
			var customerPhone = target[0].mobile;
			$("#customerId").val(customerId);
			$("#customerName").val(customerName);
			$("#customerPhone").val(customerPhone);
			m_customer_dlg.close();
		},
		saveOccupancyInfo:function(){
			var occupancy ={};
			occupancy.id = 0;
			occupancy.customerId = $("#customerId").val();
			occupancy.roomId = $("#roomName").combobox("getValue");
			occupancy.certificatesKey = "111111";
			occupancy.checkinTime = $("#startTime").datebox("getValue");
			occupancy.checkoutTime = $("#endTime").datebox("getValue");
			$.ajax({
				url : "hotel/saveOccupancy.do",
				type : "POST",
				dataType : "json",  
				data:occupancy,
				success : function(req) {
					if (req.isSuccess) { 
						$.messager.alert("操作提示","保存成功~","info"); 
						$('#occupancyListGrid').datagrid("reload");
					}else{
						$.messager.alert("操作提示","保存失败~","error");
					}
				}
			});
		}
};