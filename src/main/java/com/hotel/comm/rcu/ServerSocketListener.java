package com.hotel.comm.rcu;

import java.net.ServerSocket;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerSocketListener implements ServletContextListener{

	private int port; //����˿�
	private  ServerSocketRunner serverSocketRunner;

	private ConcurrentHashMap<String,ClientSocketRunner> clientRunners;
	

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent event) {
		String portStr = event.getServletContext().getInitParameter("socketPort");
		int port=Integer.parseInt(portStr);
		
		serverSocketRunner=new ServerSocketRunner(port);
		serverSocketRunner.setPriority(8); //
		serverSocketRunner.start();
	}

}
