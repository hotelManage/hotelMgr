package com.hotel.comm.app;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class AppWebSocket {
	
	public static java.util.concurrent.ConcurrentHashMap<String, AppWebSocket> appWebSockets;
	
	private Session session;
	
	@OnOpen
	public void onOpen(){
		
	}
}
