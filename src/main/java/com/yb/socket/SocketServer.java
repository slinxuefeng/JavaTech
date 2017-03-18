package com.yb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private ServerSocket ss;
	private Socket socket;
	private BufferedReader in;

	public SocketServer() throws IOException {
		ss = new ServerSocket(10000);
		while (true) {
			socket = ss.accept();
			in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			String line = in.readLine();
			if ("exit".equalsIgnoreCase(line)) {
				System.out.println("you input is :" + line+"\n停止进程！");
				break;
			}else{
				System.out.println("you input is :" + line+"\n如果想停止进程请输入EXIT！");
			}

			in.close();
			socket.close();
		}
	}

	public static void main(String[] args) throws IOException {
		new SocketServer();
	}
}
