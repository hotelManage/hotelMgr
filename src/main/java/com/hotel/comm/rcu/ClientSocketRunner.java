package com.hotel.comm.rcu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.sf.json.JSONObject;

/**
 * 
 * RCU
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

	private Socket clientSocket;
	private String sid;
	private String ip;

	private volatile boolean isRun = true;
	private final int READ_STREAM_SIZE = 1024; // 一次读取默认的字节数

	private StringBuilder receiveBuffer; // 接受客户端的字符缓存
	private ConcurrentLinkedQueue<JSONObject> actions; // 发送给RCU的命令 json。
	private boolean fristReceive =true;
	
	
	public ClientSocketRunner(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.receiveBuffer = new StringBuilder();
		this.actions = new ConcurrentLinkedQueue<JSONObject>();
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

	public void addAction(JSONObject jo) {
		actions.add(jo);
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
					ip=clientSocket.getInetAddress().getHostAddress();

				} else {
					interval = System.currentTimeMillis() - currentTime;

					if (interval > ServerSocketListener.getRcuBeatInterval() * 1000) {
						isRun = false;
						break;
					}
				}

				if (!this.actions.isEmpty()) {
					this.send(out);
				}

				Thread.sleep(50);
			}
			// 已经跳出循环，说明要关闭socket和终止线程 ，以下是一些清理工作。

			in.close();
			out.close();
			clientSocket.close();

			this.interrupt(); // 终止本线程。
			ServerSocketListener.getClientRunners().remove(sid); // 线程池中删除本线程

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
			ServerSocketListener.getClientRunners().put(sid, this);
		}
		
	}

	/**
	 * 
	 * @param out
	 */
	private void send(DataOutputStream out) {
		try {
			Iterator<JSONObject> it = this.actions.iterator();

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

	private void action(List<JSONObject> jos) {

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
	
	
}
