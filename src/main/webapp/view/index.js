var m_index_user;
var m_changePwd_dlg;
var m_index_orgId;
var m_index_user={};
var m_index_permission;
var m_index_iconStyles = {};

$(function() {  
	m_index_user = getCurrentUser();
	m_index_orgId = m_index_user.orgId
	$('#treeMenu').tree({
		checkbox : false, 
		onClick : onTreeMenuDblClick
	}); 
});
 
/**
 * �˳���ҳ�棬���ص�¼ҳ��
 */
function onExit() {
	$.messager.confirm("ϵͳ��ʾ", "�Ƿ��˳���ҳ�����ص�¼ҳ�棿", function(r) {
		if (r) {
			location = "login/onExit.do";
		}
	}); 
}
/**
 * �޸�����
 */
function onChangePwd() {
	m_changePwd_dlg = art.dialog({
		id : 'dlgchangePwd',
		title : '�޸�����',
		content : document.getElementById("div_changePwd"),
		// content:"123",
		lock : true,
		initFn : function() {
		}
	});
}
/**
 * 
 */
function onTreeMenuDblClick(row) {
	var src = null;  
	switch (row.text) {
	case "�û�����":
		src = "view/system/userList.jsp";
		break;
	case "������Ϣ":
		src = "view/system/region.jsp";
		break;
	case "�豸����":
		src = "";
		break;
	}
	$("#ifrContent").attr("src", src); 
}

/**
 * �������˵�
 * 
 * @param items
 * @returns {Array}
 */
function buildTreeMenu(items) {
	var ss = [];
	var cache = {};

	if (items == null || items.length == 0) {
		return ss;
	}

	var count = items.length;

	for ( var i = 0; i < count; i++) {
		var node = items[i];
		node.text = node.name;
		cache[node.id] = node;
		createIconStyle(node);
		if (node.nodeLevel == 1) {
			ss.push(node);
		} else {
			var node2 = cache[node.parentId];
			if (node2.children == undefined) {
				node2.children = [];
			}
			node2.children.push(node);
		}
	}
	return ss;
}

function createIconStyle(node) {
	if (node.iconCls == undefined || node.iconCls == null) {
		if (node.icon != null && node.icon.length > 0) {
			var classId = "icon_main_menu_" + node.id;
			var tmpId = m_index_iconStyles[classId];
			if (tmpId == undefined || tmpId == null) {
				var style = "."
						+ classId
						+ "{	background:url('"
						+ location.href
						+ node.icon
						+ "');background-size:contain; width:16px; height:16px}";
				createStyle(style);
				m_index_iconStyles[classId] = classId;
			}
			node.iconCls = classId;
		}
	}
}

function createStyle(css) {
	try { // IE����
		var style = document.createStyleSheet();
		style.cssText = css;
	} catch (e) { // Firefox,Opera,Safari,Chrome����
		var style = document.createElement("style");
		style.type = "text/css";
		style.textContent = css;
		document.getElementsByTagName("HEAD").item(0).appendChild(style);
	}
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
