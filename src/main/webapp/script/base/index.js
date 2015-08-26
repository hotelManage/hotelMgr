var m_index_orgId;   

$(function() {    
	$('#treeMenu').tree({
		checkbox : false, 
		onClick : onTreeMenuDblClick
	}); 
});

/**
 * 点击树菜单操作功能页面
 */
function onTreeMenuDblClick(row) {
	var src = null;  
	switch (row.text) {
	case "案件分配":
		src = "view/policeoffice/casedistributeList.jsp?caseType=1";
		break;
	case "案件反馈":
		src = "view/policeoffice/casedistributeList.jsp?caseType=2";
		break; 
	}
	$("#ifrContent").attr("src", src); 
}
function iframeSize() {
	var ifm = document.getElementById("ifrContent");
	var subWeb = document.frames ? document.frames["ifrContent"].document
			: ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
		ifm.width = subWeb.body.scrollWidth;
	}
}