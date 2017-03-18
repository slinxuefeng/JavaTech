package com.yb.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {
	Socket socket;
	BufferedReader in;
	PrintWriter out;

	public SocketClient() {
		try {
			socket = new Socket("localhost", 10000);
			in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader line = new BufferedReader(new InputStreamReader(
					System.in));
			out.println(line.readLine());
			//line.close();
			//in.close();
			//socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SocketClient();
	}
}
