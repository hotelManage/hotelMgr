$(function() {
	//getCurrentUser();
	LinkInfoManage.init();
});

var LinkInfoManage ={
	
		wsClient:null,
		
		consoleId:'',
		
		serverAddress:'127.0.0.1:8080',
		
		init:function(){
			this.linkGrdInit();
			this.consoleId =this.createUUID();
		},
		
		linkGrdInit : function() {
			$('#linkGrd').datagrid({
				fitColumns : true,
				rownumbers : true,
				title:"连接数据",
				pagination : false,
				nowrap : false,
				idField : 'id',
				columns : [[ {
					title : 'src',
					field : 'src',
					width : 100
				}, {
					title : 'dst',
					field : 'dst',
					align : 'left',
					width : 100
				}, {
					title : 'time',
					field : 'time',
					align : 'center',
					width : 140
				} ,
				{
					title : 'sid',
					field : 'sid',
					align : 'left',
					width : 120
				} ,
				{
					title : 'uid',
					field : 'uid',
					align : 'left',
					width : 120
				} ,
				{
					title : 'content',
					field : 'content',
					align : 'left',
					width : 400,
					formatter:function(val,row){
						return JSON.stringify(row);
					}
				}] ]
			});
		},
		
		onConnection :function(){
			this.wsClient =new WebSocket('ws:112.74.209.133:8080/hotelmgr/console/' + this.consoleId);
			
			this.wsClient.onopen=function(){
				$("#lblInfo").html('已连接');
				console.log('open');
			};
			
			this.wsClient.onmessage =function(msg){
				var obj=JSON.parse(msg.data);
				$('#linkGrd').datagrid('appendRow',obj);
			};
			
			this.wsClient.onclose=function(){
				$("#lblInfo").html('连接被关闭!');
			};
			
			this.wsClient.onerror = function(evt)
			{
				$("#lblInfo").html('连接发送错误!' + JSON.stringify(evt));
			};
			
		},
		createUUID:function(){
			function S4() {
			       return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
			    }
			    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
		}

		
};