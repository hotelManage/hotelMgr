package com.hotel.comm.rcu;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerSocketListener implements ServletContextListener{

	private static int port;
	private static long rcuBeatInterval;
	private static ConcurrentHashMap<String,ClientSocketRunner> clientRunners;
	
	private  ServerSocketRunner serverSocketRunner;

	
	public  static int getPort(){
		return port;
	}

	public   static long getRcuBeatInterval(){
		return rcuBeatInterval;
	}
	
	public static ConcurrentHashMap<String,ClientSocketRunner> getClientRunners(){
		return clientRunners;
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent event) {
		String portStr = event.getServletContext().getInitParameter("socketPort");
		String rcuBeatIntervalStr=event.getServletContext().getInitParameter("RCUBeatInterval");
		
		ServerSocketListener.port=Integer.parseInt(portStr);
		ServerSocketListener.rcuBeatInterval=Long.parseLong(rcuBeatIntervalStr);
		
		clientRunners=new ConcurrentHashMap<String,ClientSocketRunner>();
		
		serverSocketRunner=new ServerSocketRunner(port);
		serverSocketRunner.setPriority(8); //
		serverSocketRunner.start();
	}

}
