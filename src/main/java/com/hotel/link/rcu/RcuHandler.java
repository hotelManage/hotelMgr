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
import com.hotel.link.router.MessageRouter;
import com.hotel.service.base.CustomerService;

public class RcuHandler extends IoHandlerAdapter {
	

	@Autowired 
	private CustomerService customerService;
	
	private IoSession ioSession;
	
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
	
	/**
	 * 获取RCU端发送的数据。
	 */
	@Override
    public void messageReceived(IoSession session, Object message) throws Exception {

		this.ioSession=session;
		
		try{
			if(message != null){
				String txt=(String)message;
				txt=txt.trim().replaceAll("#@", "");
				
				JSONObject jo =JSONObject.fromObject(txt);
				
				MessageRouter router=new MessageRouter(jo,this);
				router.execute();
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		

    }
	
	public void sendMessage(String msg){
		if(this.ioSession != null){
			this.ioSession.write(msg);
		}
	}
}
