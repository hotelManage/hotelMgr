package com.hotel.link.rcu;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.json.JSONObject;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.link.rcusocket.ClientSocketRunner;
import com.hotel.service.base.CustomerService;

public class RcuHandler extends IoHandlerAdapter {
	
	/**
	 * rcu客户端端连接的集合。
	 */
	private static Map<String,RcuHandler> rcuHandlers=new ConcurrentHashMap<String,RcuHandler>();
	
	@Autowired 
	private CustomerService customerService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override 
    public void sessionCreated(IoSession session) throws Exception {
		//System.out.println("created");
    }
	
	@Override
    public void sessionOpened(IoSession session) throws Exception {
		//System.out.println("opened");
    }
	
	@Override
    public void sessionClosed(IoSession session) throws Exception {
        // Empty handler
    }
	
	@Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("sessionIdle");
    }
	
	@Override
    public void messageReceived(IoSession session, Object message) throws Exception {

		if(message != null){
			String txt=(String)message;
			txt=txt.trim().replaceAll("#@", "");
			
			JSONObject jo =JSONObject.fromObject(txt);
			
			
			
		}

    }
}
