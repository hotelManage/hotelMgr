package com.hotel.link.rcusocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 服务器端监听线程
 * @author charo
 *
 */
public class ServerSocketRunner extends Thread{
	
	private int prot; 
	private ServerSocket serverSocket;
	private volatile boolean isRun=true;

	public ServerSocketRunner(int prot){
		this.prot=prot;
	}
	
	public synchronized boolean isRun() {
		return isRun;
	}
	
	public synchronized void setRun(boolean isRun) {
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
				
				Thread.currentThread().sleep(100);//�ж�
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
