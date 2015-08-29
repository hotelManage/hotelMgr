package com.hotel.comm.app;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class AppWebSocket {
	
	public static java.util.concurrent.ConcurrentHashMap<String, AppWebSocket> appWebSockets;
	
	private Session session;
	
	@OnOpen
	public void onOpen(Session session){
		this.session=session;
	}
	
	@OnMessage
	public String onMessage(String msg,Session session){
		
		return null;
	}
	
	@OnClose
	public void onClose(Session session){
		
	}
	
	@OnError
	public void onError(Session session,Throwable t){
		
	}
}
