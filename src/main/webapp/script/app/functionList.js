$(function() { 
	FunctionManage.loadFunctionList();
	FunctionManage.initFunction();
	$("#addFunction").bind("click", FunctionManage.addFunction);
	$("#editFunction").bind("click", FunctionManage.editFunction);
	$("#delFunction").bind("click", FunctionManage.delFunction);
});

var FunctionManage = {
		initFunction:function(){
			$("#functionTag").combobox({
				url:'hotel/getItemTagComboList.do',
				valueField:'id',  
			    textField:'name' 
			});
		},
		loadFunctionList : function() {
			$('#functionListGrid').datagrid({
				url : 'app/getFunctionList.do',
				fitColumns : true,
				rownumbers : true,
				pagination : true,
				title:"菜单图标",
				pageNumber : 1,
				pageSize : 10,
				nowrap : false,
				idField : 'id',
				singleSelect : true,
				onDblClickRow : FunctionManage.editFunction,
				columns : [ [ {
					title : 'id',
					field : 'id',
					hidden : true
				}, {
					title : '图标',
					field : 'iconUrl',
					align : 'center',
					//width : 100,
					formatter : function(value, rowData, index) {
						return "<img style='width:30px;height:30px;' src='"+rowData.iconUrl+"'/>";
					}
				}, {
					title : '类型',
					field : 'functionType',
					align : 'center',
					width : 100,
					formatter : function(value, rowData, index) {
						if (value == 1 || value == "1") {
							return "内置功能";
						} else if (value == 2 || value == "2") {
							return "分类查询";
						} 
					}
				}, {
					title : '项目',
					field : 'tagName',
					align : 'center',
					width : 100,
				},{
					title : '位置',
					field : 'sort',
					align : 'center',
					width : 100,
				} ] ]
			});
		},
		addFunction:function(){
			$("#div_FunctionInfo p[name='p_img']").hide();
			m_functionInfo_dlg = art
			.dialog({
				id : 'dlgFunctionInfo',
				title : '新增菜单',   
				width: 450, 
				height: 300,
				content : document.getElementById("div_FunctionInfo"),
				lock : false,
				initFn : function() { 
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 FunctionManage.saveFunctionInfo(0);
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消',
		                     callback: function () { 
		                    	 m_functionInfo_dlg.close();
		                    	 FunctionManage.clearFrom();
		                         return false;
		                     },
		                     focus: true
		                 }
		            ]
			});
		},
		editFunction:function(){
			$("#div_FunctionInfo p[name='p_img']").show();
			var dataRows = $('#functionListGrid').datagrid('getRows');
			if (dataRows.length == 0) {
				$.messager.alert('操作提示', "没有可操作数据！", "warning");
				return;
			}
			var target = $("#functionListGrid").datagrid("getChecked");
			if (!target || target.length == 0) {
				$.messager.alert('操作提示', "请选择操作项!", "warning");
				return;
			} 
			if (target.length > 1) {
				$.messager.alert('操作提示', "只能选择单操作项!", "warning");
				return;
			}
			var id = target[0].id;
			var functionType = target[0].functionType;
			var itemTagId = target[0].itemTagId;
			var sort = target[0].sort;
			var iconUrl = target[0].iconUrl;
			$('#functionType').combobox("setValue",functionType);
			$('#functionSort').val(sort);
			$('#functionTag').combobox("setValue",itemTagId);
			$("#functionIcon").attr("src",iconUrl);
			m_functionInfo_dlg = art
			.dialog({
				id : 'dlgFunctionInfo',
				title : '编辑菜单',   
				width: 450, 
				height: 300,
				content : document.getElementById("div_FunctionInfo"),
				lock : false,
				initFn : function() { 
				},
		        button: [
		                 {
		                     name: '保存',
		                     callback: function () { 
		                    	 FunctionManage.saveFunctionInfo(id);
		                         return false;
		                     },
		                     focus: true
		                 },
		                 {
		                     name: '取消',
		                     callback: function () { 
		                    	 m_functionInfo_dlg.close();
		                    	 FunctionManage.clearFrom();
		                         return false;
		                     },
		                     focus: true
		                 }
		            ]
			});
		},
		saveFunctionInfo : function(id){
			var functionType = $('#functionType').combobox("getValue");
			var itemTagId = $('#functionTag').combobox("getValue");
			var sort = $('#functionSort').val();
			var icon = $("#icon").val();
			if(functionType == ""){
				$.messager.alert("操作提示", "请选择类型！", "error");
				return;
			}
			if(id==0&&icon == ""){
				$.messager.alert("操作提示", "请选择图标！", "error");
				return;
			}
			var m_function={};
			m_function.id = id;
			m_function.functionType = functionType;
			m_function.itemTagId = itemTagId;
			m_function.sort = sort;
			
			var extname = icon.substring(icon.lastIndexOf(".")+1,icon.length);  
			extname = extname.toLowerCase();//处理了大小写   
		    $.ajaxFileUpload({
				url : "app/saveFunction.do",
				secureuri:false,                       //是否启用安全提交,默认为false
				fileElementId:'icon',
				type : "POST",
				dataType : "json",
				async : false,
				data : m_function,
				success : function(req) {
					if (req.isSuccess) {
						FunctionManage.clearFrom();
						FunctionManage.closeDialog();
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
		delFunction : function() {
			try{
				var dataRows = $('#functionListGrid').datagrid('getRows');
				if (dataRows.length == 0) {
					$.messager.alert('操作提示', "没有可操作数据！", "warning");
					return;
				}
				var target = $("#functionListGrid").datagrid("getChecked");
				if (!target || target.length == 0) {
					$.messager.alert('操作提示', "请选择操作项!", "warning");
					return;
				}
				var id = target[0].id;
				if(target != null){
					$.messager.confirm("删除确认", "确认删除该项？", function(r) {
						if (r) {
							FunctionManage.delFunctionAction(id);
						}
					});
				}
			}catch (ex){
				$.messager.alert("操作提示", ex.message, "error");
			}
		},
		delFunctionAction : function(id) {
			$.ajax({
	    		url :  "app/deleteFunction.do?id="+id,
	    		type : "POST",
	    		dataType : "json",
	    		async : false,
	    		success : function(req) {
	    			if (req.isSuccess) {
	    				$('#functionListGrid').datagrid("reload");
	    			} else {
	    				$.messager.alert('删除失败ʾ', req.msg, "warning");
	    			}
	    		}
	    	});
		},
		clearFrom:function(){
			$('#functionType').combobox("setValue","");
			$('#functionTag').combobox("setValue","");
			$('#functionSort').val("");
			$("#icon").val("");
		},
		closeDialog : function(){
			m_functionInfo_dlg.close();
			$('#functionListGrid').datagrid("reload");
		}
};