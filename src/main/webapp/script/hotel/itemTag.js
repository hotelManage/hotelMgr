$(function() { 
	ItemTagManage.loadItemTagList();
	$("#addItemTag").bind("click", ItemTagManage.addItemTag);
	$("#editItemTag").bind("click", ItemTagManage.editItemTag);
	$("#delItemTag").bind("click", ItemTagManage.delItemTag);
});

var ItemTagManage = {
		loadItemTagList : function() {
			$('#itemTagListGrid').datagrid({
				url : 'hotel/getItemTagList.do',
				fitColumns : true,
				rownumbers : true,
				pagination : true,
				title:"服务项目",
				pageNumber : 1,
				pageSize : 10,
				nowrap : false,
				idField : 'id',
				singleSelect : true,
				onDblClickRow : ItemTagManage.editItemTag,
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
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
				} ] ]
			});
		},
		addItemTag:function(){
			m_itemTagInfo_dlg = art
			.dialog({
				id : 'dlgItemTagInfo',
				title : '新增服务项目',   
				width: 450, 
				height: 300,
				content : document.getElementById("div_ItemTagInfo"),
				lock : false,
				initFn : function() { 
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 ItemTagManage.saveItemTagInfo(0);
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消',
		                     callback: function () { 
		                    	 m_itemTagInfo_dlg.close();
		                    	 ItemTagManage.clearFrom();
		                         return false;
		                     },
		                     focus: true
		                 }
		            ]
			});
		},
		editItemTag:function(){
			var dataRows = $('#itemTagListGrid').datagrid('getRows');
			if (dataRows.length == 0) {
				$.messager.alert('操作提示', "没有可操作数据！", "warning");
				return;
			}
			var target = $("#itemTagListGrid").datagrid("getChecked");
			if (!target || target.length == 0) {
				$.messager.alert('操作提示', "请选择操作项!", "warning");
				return;
			} 
			if (target.length > 1) {
				$.messager.alert('操作提示', "只能选择单操作项!", "warning");
				return;
			}
			var id = target[0].id;
			var name = target[0].name;
			var note = target[0].note;
			$('#itemTagName').val(name);
			$('#itemTagNote').val(note);
			m_itemTagInfo_dlg = art
			.dialog({
				id : 'dlgItemTagInfo',
				title : '编辑服务项目',   
				width: 450, 
				height: 300,
				content : document.getElementById("div_ItemTagInfo"),
				lock : false,
				initFn : function() { 
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 ItemTagManage.saveItemTagInfo(id);
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消',
		                     callback: function () { 
		                    	 m_itemTagInfo_dlg.close();
		                    	 ItemTagManage.clearFrom();
		                         return false;
		                     },
		                     focus: true
		                 }
		            ]
			});
		},
		saveItemTagInfo : function(id){
			var m_itemTag={};
			m_itemTag.id = id;
			m_itemTag.name = $('#itemTagName').val();
			m_itemTag.note = $('#itemTagNote').val();
			m_itemTag.isUsed = 1;
		    $.ajax({
				url : "hotel/saveItemTag.do",
				type : "POST",
				dataType : "json",
				data : m_itemTag,
				success : function(req) {
					if (req.isSuccess) {
						ItemTagManage.clearFrom();
						ItemTagManage.closeDialog();
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
		delItemTag : function() {
			try{
				var dataRows = $('#itemTagListGrid').datagrid('getRows');
				if (dataRows.length == 0) {
					$.messager.alert('操作提示', "没有可操作数据！", "warning");
					return;
				}
				var target = $("#itemTagListGrid").datagrid("getChecked");
				if (!target || target.length == 0) {
					$.messager.alert('操作提示', "请选择操作项!", "warning");
					return;
				}
				var id = target[0].id;
				var name = target[0].name;
				if(target != null){
					$.messager.confirm("删除确认", "确认删除项目["+name+"]？", function(r) {
						if (r) {
							ItemTagManage.delItemTagAction(id);
						}
					});
				}
			}catch (ex){
				$.messager.alert("操作提示", ex.message, "error");
			}
		},
		delItemTagAction : function(id) {
			$.ajax({
	    		url :  "hotel/deleteItemTag.do?id="+id,
	    		type : "POST",
	    		dataType : "json",
	    		async : false,
	    		success : function(req) {
	    			if (req.isSuccess) {
	    				$('#itemTagListGrid').datagrid("reload");
	    			} else {
	    				$.messager.alert('删除失败ʾ', req.msg, "warning");
	    			}
	    		}
	    	});
		},
		clearFrom:function(){
			$("#itemTagName").val("");
			$("#itemTagNote").val("");
		},
		closeDialog : function(){
			m_itemTagInfo_dlg.close();
			$('#itemTagListGrid').datagrid("reload");
		}
};