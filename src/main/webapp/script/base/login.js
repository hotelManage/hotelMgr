$(function() {
	var args = getUrlArgs();
	if (args.optType == 0 || args.optType == "0") {
		$.messager.alert("ϵͳ��ʾ","�û������û����벻��Ϊ��","error");
	} else if (args.optType == 1 || args.optType == "1") {
		$.messager.alert("ϵͳ��ʾ","���벻��Ϊ��","error");
	} else if (args.optType == 2 || args.optType == "2") {
		$.messager.alert("ϵͳ��ʾ","�û��ѱ�����������Ҫ��¼������ϵ����Ա","warning");
	} else if (args.optType == 3 || args.optType == "3") {
		$.messager.alert("ϵͳ��ʾ","�û������������","info");
	} else if (args.optType == 4 || args.optType == "4") {
		$.messager.alert("ϵͳ��ʾ","ϵͳ��¼��������ϵ��վ����Ա","info");
	}
	$("#txtusername").keydown(function(e) {
		if (e.keyCode == 13) {
			var username = $("#txtusername").val();
			var password = $("#txtpassword").val();
			if(username==""||username.length==0){
				$.messager.alert("ϵͳ��ʾ","�������û���������","error")
				return;
			}
			if(password==""||password.length==0){
				$.messager.alert("ϵͳ��ʾ","�������û�����","error")
				return;
			}
			$("#submitform").submit();
		}
	});
	$("#txtpassword").keydown(function(e) {
		if (e.keyCode == 13) {
			var username = $("#txtusername").val();
			var password = $("#txtpassword").val();
			if(username==""||username.length==0){
				$.messager.alert("ϵͳ��ʾ","�������û���������","error")
				return;
			}
			if(password==""||password.length==0){
				$.messager.alert("ϵͳ��ʾ","�������û�����","error")
				return;
			}
			$("#submitform").submit();
		}
	});
	
});