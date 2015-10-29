var m_ita={};
$(function() {
	HotelItemManage.initHotel();
	HotelItemManage.initItemTag();
	HotelItemManage.loadHotelItemList(); 
	$("#addHotelItem").bind("click", HotelItemManage.addHotelItem);
	$("#editHotelItem").bind("click", HotelItemManage.editHotelItem);
	$("#delHotelItem").bind("click", HotelItemManage.delHotelItem);
});

var HotelItemManage = {
		loadHotelItemList : function() {
			$('#hotelItemListGrid').datagrid({
				url : 'hotel/getHotelItemList.do',
				fitColumns : true,
				rownumbers : true,
				pagination : true,
				title:"酒店服务项目",
				pageNumber : 1,
				pageSize : 10,
				nowrap : false,
				idField : 'id',
				singleSelect : true,
				onDblClickRow : HotelItemManage.editHotelItem,
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
				}, {
					title : '酒店名称',
					field : 'hotelName',
					align : 'center',
					width : 100
				}, {
					title : '服务名称',
					field : 'name',
					align : 'center',
					width : 100
				}, {
					title : '备注',
					field : 'note',
					align : 'center',
					width : 100,
				}, {
					title : '电话',
					field : 'tel',
					align : 'center',
					width : 100,
				} ] ]
			});
		},
		initHotel:function(){
			$("#hotelName").combobox({
				url:'hotel/getHotelComboList.do',
				valueField:'id',  
				textField:'name' 
			});
		},
		initItemTag:function(){
			$("#itemName").combobox({
				url:'hotel/getItemTagComboList.do',
				valueField:'id',  
			    textField:'name' 
			});
		},
		initItemTagAssociation:function(itemId){
			$.ajax({
				url : "hotel/getItemTagAssociationList.do?itemId="+itemId,
				type : "POST",
				dataType : "json",
				success : function(req) {
					if (req.isSuccess) { 
						m_ita.ids=req.data.ids;
						m_ita.tagIds=req.data.tagIds;
						$('#itemName').combobox("setValues",m_ita.tagIds);
					}else{
						$.messager.alert("操作提示","失败~","error");
					}
				}
			});
		},
		addHotelItem:function(){
			$("#div_HotelItemInfo p[name='p_img']").hide();
			m_hotelItem_dlg = art
			.dialog({
				id : 'dlgHotelItemInfo',
				title : '新增酒店服务',   
				width: 450, 
				height: 300,
				content : document.getElementById("div_HotelItemInfo"),
				lock : false,
				initFn : function() { 
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 HotelItemManage.saveHotelItemInfo(0);
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消',
		                     callback: function () { 
		                    	 m_hotelItem_dlg.close();
		                    	 HotelItemManage.clearFrom();
		                         return false;
		                     },
		                     focus: true
		                 }
		            ]
			});
		},
		editHotelItem:function(){
			$("#div_HotelItemInfo p[name='p_img']").show();
			var dataRows = $('#hotelItemListGrid').datagrid('getRows');
			if (dataRows.length == 0) {
				$.messager.alert('操作提示', "没有可操作数据！", "warning");
				return;
			}
			var target = $("#hotelItemListGrid").datagrid("getChecked");
			if (!target || target.length == 0) {
				$.messager.alert('操作提示', "请选择操作项!", "warning");
				return;
			} 
			if (target.length > 1) {
				$.messager.alert('操作提示', "只能选择单操作项!", "warning");
				return;
			}
			var id = target[0].id;
			HotelItemManage.initItemTagAssociation(id);
			var hotelId = target[0].hotelId;
			var name = target[0].name;
			var note = target[0].note;
			var tel = target[0].tel;
			var url = target[0].url;
			$("#hotelName").combobox("setValue",hotelId);
			$('#hotelItemName').val(name);
			//$('#itemName').combobox("setValues",m_ita.tagIds);
			$('#itemNote').val(note);
			$('#telphone').val(tel);
			$("#itemPhoto").attr("src",url);
			m_hotelItem_dlg = art
			.dialog({
				id : 'dlghotelItemInfo',
				title : '编辑酒店服务',   
				width: 450, 
				height: 300,
				content : document.getElementById("div_HotelItemInfo"),
				lock : false,
				initFn : function() { 
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 HotelItemManage.saveHotelItemInfo(id);
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消',
		                     callback: function () { 
		                    	 m_hotelItem_dlg.close();
		                    	 HotelItemManage.clearFrom();
		                         return false;
		                     },
		                     focus: true
		                 }
		            ]
			});
		},
		saveHotelItemInfo:function(id){
			var hotelId = $("#hotelName").combobox("getValue");
			var name = $('#hotelItemName').val();
			var tagIds = $('#itemName').combobox("getValues");
			var note = $('#itemNote').val();
			var tel = $('#telphone').val();
			var icon = $("#icon").val();
			if(hotelId == ""){
				$.messager.alert("操作提示", "请选择酒店！", "error");
				return;
			}
			if(name == ""){
				$.messager.alert("操作提示", "请填写酒店服务！", "error");
				return;
			}
			if(tagIds == ""){
				$.messager.alert("操作提示", "请选择项目名称！", "error");
				return;
			}
			if(id==0&&icon == ""){
				$.messager.alert("操作提示", "请选择图片！", "error");
				return;
			}
			
			var m_hotelItem={};
			m_hotelItem.id = id;
			m_hotelItem.hotelId = hotelId;
			m_hotelItem.name = name;
			m_hotelItem.tagIds = tagIds;
			m_hotelItem.note = note;
			m_hotelItem.tel = tel;
			m_hotelItem.isUsed = 1;
			
			m_hotelItem.itaIds = m_ita.ids;
			
//			var ic = document.getElementById("icon");
//			var image = new Image();
//			image.src = icon;
//			document.body.appendChild(image);
//			var width = image.offsetWidth;
			var extname = icon.substring(icon.lastIndexOf(".")+1,icon.length);  
			extname = extname.toLowerCase();//处理了大小写   
		    $.ajaxFileUpload({
				url : "hotel/saveHotelItem.do",
				secureuri:false,                       //是否启用安全提交,默认为false
				fileElementId:'icon',
				type : "POST",
				dataType : "json",
				async : false,
				data : m_hotelItem,
				success : function(req) {
					if (req.isSuccess) {
						HotelItemManage.clearFrom();
						HotelItemManage.closeDialog();
					} else {
						$.messager.alert("系统提示", req.msg, "error");
					}
				},
				failer : function(a, b) {
					$.messager.alert("消息提示", a, "info");
				},
				error : function(a) {
					$.messager.alert("消息提示", a, "error");
				}
			});
		},
		delHotelItem : function() {
			try{
				var dataRows = $('#hotelItemListGrid').datagrid('getRows');
				if (dataRows.length == 0) {
					$.messager.alert('操作提示', "没有可操作数据！", "warning");
					return;
				}
				var target = $("#hotelItemListGrid").datagrid("getChecked");
				if (!target || target.length == 0) {
					$.messager.alert('操作提示', "请选择操作项!", "warning");
					return;
				}
				var id = target[0].id;
				var name = target[0].name;
				if(target != null){
					$.messager.confirm("删除确认", "确认删除酒店服务["+name+"]？", function(r) {
						if (r) {
							HotelItemManage.delHotelItemAction(id);
						}
					});
				}
			}catch (ex){
				$.messager.alert("操作提示", ex.message, "error");
			}
		},
		delHotelItemAction : function(id) {
			$.ajax({
	    		url :  "hotel/deleteHotelItem.do?id="+id,
	    		type : "POST",
	    		dataType : "json",
	    		async : false,
	    		success : function(req) {
	    			if (req.isSuccess) {
	    				$('#hotelItemListGrid').datagrid("reload");
	    			} else {
	    				$.messager.alert('删除失败ʾ', req.msg, "warning");
	    			}
	    		}
	    	});
		},
		clearFrom:function(){
			$("#hotelName").combobox("setValue","");
			$('#hotelItemName').val("");
			$('#itemName').combobox("setValues","");
			$('#itemNote').val("");
			$('#telphone').val("");
			$('#icon').val("");
		},
		closeDialog : function(){
			m_hotelItem_dlg.close();
			$('#hotelItemListGrid').datagrid("reload");
		}
};