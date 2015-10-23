package com.hotel.link.router;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.hotel.link.app.AppHandler;
import com.hotel.link.console.ConsoleHandler;
import com.hotel.link.rcu.RcuHandler;
import com.hotel.link.rcusocket.ClientSocketRunner;

import net.sf.json.JSONObject;

/**
 * 消息路由
 * app 的websocket 与  Rcu socket 之间的消息传递。 
 * @author charo
 *
 */
public class MessageRouter {
	
	/**
	 * rcu客户端端连接的集合。
	 */
	private static Map<String,RcuHandler> rcuHandlers=new ConcurrentHashMap<String,RcuHandler>();
	/**
	 * app客户端连接集合
	 */
	private static Map<String, AppHandler> appHandlers=new ConcurrentHashMap<String, AppHandler>();
	/**
	 * 控制台连接集合
	 */
	private static Map<String, ConsoleHandler> consoleHandlers=new ConcurrentHashMap<String, ConsoleHandler>();
	
	private JSONObject jo;
	private String dst;
	private String src;
	private String sid;
	private String uid;
	
	private RcuHandler rcuHandler;
	private AppHandler appHandler;
	
	public static Map<String,RcuHandler> getRcuHandlers(){
		return rcuHandlers;
	}
	
	public static Map<String, AppHandler> getAppHandlers(){
		return appHandlers;
	}
	
	public static Map<String, ConsoleHandler> getConsoleHandlers(){
		return consoleHandlers;
	}
	
	public static void addRcuHandler(String sid,RcuHandler rcuHandler){
		rcuHandlers.put(sid, rcuHandler);
	}
	
	public static void addAppHandler(String usid,AppHandler appHandler){
		appHandlers.put(usid, appHandler);
	}
	
	public static void addConsoleHandler(String consoleId,ConsoleHandler consoleHandler){
		consoleHandlers.put(consoleId, consoleHandler);
	}
	
	public MessageRouter(JSONObject jo,RcuHandler rcuHandler){
		this(jo);
		this.rcuHandler =rcuHandler;
		String sid=jo.getString("sid");
		this.rcuHandler.setSid(sid);
		
	}

	public MessageRouter(JSONObject jo,AppHandler appHandler){
		this(jo);
		this.appHandler =appHandler;
	}
	
	public MessageRouter(JSONObject jo){
		this.dst= jo.getString("dst");
		this.src=jo.getString("src");
		this.sid=jo.getString("sid");
		this.uid=jo.getString("uid");
		
		this.jo=jo;
	}
	
	public void execute(){
		
		toWebConsole();
		
		String type=jo.getString("type");
		
		switch(type){
		
		case "htpk":
			htpkType();
			break;
		case "ctst":
			transmit();
			break;
			
		case "result" :
			transmit();
			break;
		case "report":
			
			break;
		}
	}

	/**
	 * rcu心跳连接
	 */
	private void htpkType(){
		rcuHandlers.put(sid, rcuHandler);
	}
	
	/**
	 * 控制命令,返回命令
	 */
	private void transmit(){
		
		String msg="#@" + jo.toString() + "@#";
		
		switch(dst){
		case "rcu":
			if(sid!=null && !sid.isEmpty()){
				RcuHandler rcuh=rcuHandlers.get(sid);
				rcuh.sendMessage(msg);
			}
			break;
		case "app":
			if(uid!=null && !uid.isEmpty()){
				AppHandler apph=appHandlers.get(uid);
				apph.sendMessage(msg);
			}
			break;
		case "svr":
			
			break;
		default:
			
		}
	}
	
	private void toWebConsole(){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jo.accumulate("time", df.format(new Date()));
		
		for(Entry<String,ConsoleHandler> e : consoleHandlers.entrySet()){
			ConsoleHandler ch =e.getValue();
			ch.sendMessage(jo.toString());
		}
	}
	
}
