package com.hotel.link.rcusocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;


import net.sf.json.JSONObject;

/**
 * 
 * Rcu
 * 
 * @author charo
 * 
 */
public class ClientSocketRunner extends Thread {

	private static final String RCU_TYPE_HTPK = "Htpk";
	private static final String RCU_TYPE_IDSET = "IDSET";
	private static final String RCU_TYPE_CTST = "CTST";

	private static String regex = "\\{(.*?)\\}";
	private static Pattern pattern = Pattern.compile(regex);

	private Socket clientSocket; //连接客户端的socket
	private String sid;  //RCU内部id，由RCU发送上来。
	private volatile boolean isRun = true;
	private final int READ_STREAM_SIZE = 1024; // 一次读取默认的字节数

	private StringBuilder receiveBuffer=new StringBuilder(); // 接受客户端的字符缓存
	private Collection<JSONObject> actions2RCU =new ConcurrentLinkedDeque<JSONObject>(); // 发送给RCU的命令 json。

	private static Map<String,ClientSocketRunner> clientRunners=new ConcurrentHashMap<String,ClientSocketRunner>();
	
	//private ReceiveStreamInfo receiveStreamInfo= new ReceiveStreamInfo();
	/**
	 * 通过RCU的SID返回一个客户端Socket包装类（this type)
	 * @param sid
	 * @return
	 */
	public static Map<String,ClientSocketRunner> getClientRunners(){
		

		
		return clientRunners;
	}
	
	public ClientSocketRunner(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	
	public synchronized  boolean isRun() {
		return isRun;
	}

	public synchronized  void setRun(boolean isRun) {
		this.isRun = isRun;
	}

	public void addAction(JSONObject jo) {
		actions2RCU.add(jo);
	}

	public void run() {
		try {

			DataInputStream in = new DataInputStream(
					clientSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(
					clientSocket.getOutputStream());

			long currentTime = 0;
			long interval = 0;
			while (isRun) {

				if (in.read() != -1) {
					
					currentTime = System.currentTimeMillis();
					this.receive(in);

				} else {
					//两次发送数据之间的时间差，超过预定时间，就关闭连接。
					//超时连接数字设置在web.xml
					interval = System.currentTimeMillis() - currentTime; 

					if (interval > ServerSocketListener.getRcuBeatInterval() * 1000) {
						isRun = false;
						break;
					}
				}

				if (!this.actions2RCU.isEmpty()) {
					this.send(out);
				}

				Thread.sleep(50);
			}
			// 已经跳出循环，说明要关闭socket和终止线程 ，以下是一些清理工作。

			in.close();
			out.close();
			
			clientSocket.close();
			clientRunners.remove(sid); // 线程池中删除本线程
			
			this.interrupt(); // 终止本线程。
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 接受客户端传递的数据
	 * 
	 * @throws IOException
	 */
	private void receive(DataInputStream in) throws IOException {


		
		byte[] bs = new byte[READ_STREAM_SIZE];

		int len = in.read(bs);

		String ss = new String(bs, 0, len);
		receiveBuffer.append(ss);

		List<JSONObject> jos=toJSONObject(receiveBuffer);
		
		if(sid==null && !jos.isEmpty()){
			sid=jos.get(0).getString("SID");
			clientRunners.put(sid, this);
		}
		
		action2Server(jos);
	}

	/**
	 * 将actions中的jsonobject 转换成json格式后发送到RCU
	 */
	private void send(DataOutputStream out){
		try {
			Iterator<JSONObject> it = this.actions2RCU.iterator();

			while (it.hasNext()) {
				JSONObject jo = it.next();
				it.remove();
				
				String str = jo.toString();
				byte[] bs = str.getBytes();

				out.write(bs);
				out.flush();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	

	/**
	 * 执行RCU上传上来的命令
	 * @param jos
	 */
	private void action2Server(List<JSONObject> jos) {

		for (JSONObject jo : jos) {
			String type = jo.getString("Type");

			if (type.equals(ClientSocketRunner.RCU_TYPE_HTPK)) {
				addHtpkAction(jo);
			} else if (type.equals(ClientSocketRunner.RCU_TYPE_IDSET)) {
				
			} else if (type.equals(ClientSocketRunner.RCU_TYPE_CTST)) {

			} else {

			}
		}
	}

	/**
	 * 将字符缓冲区的数据转换成json格式（如果可能的话）
	 * @param sb
	 * @return
	 */
	private List<JSONObject> toJSONObject(StringBuilder sb) {


		
		Matcher m = pattern.matcher(sb.toString());

		List<JSONObject> jos = new ArrayList<JSONObject>();

		int end = 0;

		while (m.find()) {
			String s = m.group();
			end = m.end();

			JSONObject jo = JSONObject.fromObject(s);
			jos.add(jo);
		}

		sb.delete(0, end); // 删除已经转换成功的字符，
		return jos;
	}

	/**
	 * 心跳包，只需要返回相同的数据即可
	 * @param jo
	 */
	private void addHtpkAction(JSONObject jo) {
		this.addAction(jo);
	}
	/**
	 * 
	 */
	private void addIdSetAction(){

	}
	/**
	 * 字节流的信息描述
	 * @author charo
	 *
	 */
	private class ReceiveStreamInfo{
		private int head;
		private byte[] bytes;
		
		
		public ReceiveStreamInfo(byte[] head){
			
		}

		public ReceiveStreamInfo(byte[] head,byte[] data){
			
		}
		
		public int getHead() {
			return head;
		}
		public void setHead(int head) {
			this.head = head;
		}
		public byte[] getBytes() {
			return bytes;
		}
		public void setBytes(byte[] bytes) {
			this.bytes = bytes;
		}
		
		
		
	}
}
