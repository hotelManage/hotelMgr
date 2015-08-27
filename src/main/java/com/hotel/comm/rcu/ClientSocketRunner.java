package com.hotel.comm.rcu;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

/**
 * 客户端socket 连接
 * RCU
 * @author charo
 *
 */
public class ClientSocketRunner extends Thread{

	private static String regex="\\{(.*?)\\}";
	private static Pattern pattern=Pattern.compile(regex);
	
	private Socket clientSocket;
	private String sid;
	private String ip;
	
	private volatile boolean isRun=true;
	private final int READ_STREAM_SIZE=2048; //一次读取的字节数
	
	private StringBuilder sb;
	
	
	
	
	
	public ClientSocketRunner(Socket clientSocket){
		this.clientSocket=clientSocket;
		this.sb=new StringBuilder();
	}
	
	public boolean isRun() {
		return isRun;
	}
	
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	public void run(){
		try{

			DataInputStream in=new DataInputStream(clientSocket.getInputStream());
			DataOutputStream out =new DataOutputStream(clientSocket.getOutputStream());
			
			
			while(isRun){
				this.receive(in);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * 接受数据
	 * @throws IOException 
	 */
	private void receive(DataInputStream in) throws IOException{
		byte[] bs=new byte[READ_STREAM_SIZE];
		
		int len=in.read(bs);
		
		if(len>0){
			String ss=new String(bs,0,len);
			this.sb.append(ss);
			
			this.toJSONObject(sb);
		}
	}
	/**
	 * 发送信息到RCU
	 * @param out
	 */
	private void send(DataOutputStream out){
		
	}
	
	private List<JSONObject> toJSONObject(StringBuilder sb){
		
		Matcher m=pattern.matcher(sb.toString());
		
		
		
		
		List<JSONObject> jos=new ArrayList<JSONObject>();
		
		while(m.find()){
			String s=m.group();
			int x=m.end();
			System.out.print(x);
			
			JSONObject jo= JSONObject.fromObject(s);
			jos.add(jo);
			String test1=jo.getString("Type");
			System.out.print(test1);
			String test2=jo.getString("sid");
			
		}
		
		return jos;
	}
}
