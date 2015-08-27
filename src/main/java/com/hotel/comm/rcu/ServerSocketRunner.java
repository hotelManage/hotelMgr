package com.hotel.comm.rcu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ·þÎñÆ÷¶Ësocket¼àÌý
 * @author charo
 *
 */
public class ServerSocketRunner extends Thread{
	
	private int prot; 
	private ServerSocket serverSocket;
	private volatile boolean isRun=true;
	private ConcurrentHashMap<String,ClientSocketRunner> clientRunners;
	
	public ServerSocketRunner(int prot){
		this.prot=prot;
	}
	
	public boolean isRun() {
		return isRun;
	}
	
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	@Override
	public void run(){
		try {
			serverSocket =new ServerSocket(prot);
			
			while(isRun){
				Socket client=serverSocket.accept();

				ClientSocketRunner clientSocketRunner=new ClientSocketRunner(client);
				clientSocketRunner.start();
				
				Thread.currentThread().sleep(100);//ÖÐ¶Ï
				System.out.println("123");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
