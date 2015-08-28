package com.hotel.comm.app;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class AppWebSocketEndPoint extends TextWebSocketHandler {
	@Override  
    protected void handleTextMessage(WebSocketSession session,  
            TextMessage message) throws Exception {
		
        super.handleTextMessage(session, message);  
        
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
        
        session.sendMessage(returnMessage);
    }  
}
