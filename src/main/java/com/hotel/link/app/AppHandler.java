package com.hotel.link.app;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.hotel.service.base.CustomerService;

/**
 * websocket 连接管理
 * @author charo
 *
 */
@ServerEndpoint(value="/appWsLink/{customerId}",configurator = SpringConfigurator.class)
public class AppHandler {

	private Session session; //websocket 的session
	private Integer customerId; //customerId 作为缓存key。
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 客户端请求一个webSocket连接
	 * @param session
	 * @param customerId
	 */
	@OnOpen
	public void onOpen(Session session,
			@PathParam(value = "customerId") Integer customerId) {
		try {
			if (customerId == null) {
				session.close();
			} else {
				this.session = session;
				this.customerId=customerId;
				
				//appLinks.put(customerId, this);
			}
		} catch (IOException e) {

		}

	}

	/**
	 * 接受客户端数据
	 * @param msg
	 * @param session
	 * @return
	 */
	@OnMessage
	public String onMessage(String msg, Session session) {
		this.session = session;
		return null;
	}

	/**
	 * 连接被关闭
	 * @param session
	 */
	@OnClose
	public void onClose(Session session) {

	}

	/**
	 * 发生错误
	 * @param session
	 * @param t
	 */
	@OnError
	public void onError(Session session, Throwable t) {

	}

	/**
	 * 发送数据到客户端
	 * @param msg
	 */
	public void sendMessage(String msg){
		try {
			session.getBasicRemote().sendText(msg);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
