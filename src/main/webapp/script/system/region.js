$(function() { 
	//getCurrentUser();
}); 
var region_obj={};
var RegionManage = {
		loadRegionList:function(){
			$('#RegionTree').treegrid({
		    	url: 'region/getRegionList.do?parentid=0', 
		        rownumbers: true, 
				fitColumns : true,
		        idField: 'id',
		        treeField: 'name',
		        //toolbar:'#regionTb',
		        columns: [[
		               { title: 'id', field: 'id', align: 'left', width: 200,hidden:true } ,
		               { title: '区域名称', field: 'name', align: 'left', width: 300 }, 
		               { title: '备注信息', field: 'note', align: 'center', width: 200 }
		        ]]
		    });
		},
};