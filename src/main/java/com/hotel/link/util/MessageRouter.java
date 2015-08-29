package com.hotel.link.util;

import com.hotel.link.app.AppWsLink;
import com.hotel.link.rcu.ClientSocketRunner;

import net.sf.json.JSONObject;

/**
 * 消息路由
 * app 的websocket 与  RCU socket 之间的消息传递。 
 * @author charo
 *
 */
public class MessageRouter {

	/**
	 * 发送消息到rcu
	 * @param sid
	 * @param jo
	 */
	public static void message2Rcu(String sid,JSONObject jo){
		ClientSocketRunner client=ClientSocketRunner.getClientRunners().get(sid);
		if(client!=null){
			client.addAction(jo);
		}
	}
	/**
	 * 发送消息到app.
	 * @param customerId
	 * @param jo
	 */
	public static void message2App(String customerId,JSONObject jo){
		AppWsLink app=AppWsLink.getAppLinks().get(customerId);
		if(app!=null){
			app.send(jo);
		}
	}
}
