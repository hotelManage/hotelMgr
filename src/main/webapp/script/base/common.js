
function getUrlArgs() {
	var url = decodeURI(location.search);
	// var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);

		}
	}
	return theRequest;
}
function getCurrentUser() {
	var user = {};
	$.ajax({
		url : 'login/getCurrentUser.do',
		type : "POST",
		dataType : "json",
		async : false,
		success : function(req) {
			if (req.isSuccess) {
				user = req.data; 
			} else {
				alert(req.msg);
				user = undefined;
			}
		}
	});
	return user;
}