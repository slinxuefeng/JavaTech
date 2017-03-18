package com.yb.linux;

import ch.ethz.ssh2.Connection;//这个是ssh在连接Linux的时候使用一个jar：ganymed-ssh2-build210.jar
import ch.ethz.ssh2.Session;//这个是连接的一个会话
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReadLinuxInfo {

	@Test
	public static void getListLog() throws Exception {

		List arr = new ArrayList();
		String hostname = "133.64.100.4"; // 192.168.18.38主机名称
		String username = "tms";// 主机用户名

		String password = "tms42011";// 主机密码

		Connection conn = new Connection(hostname);// 创建一个连接

		conn.connect();// 创建的连接请求连接

		boolean isAuthenticated = conn.authenticateWithPassword(username,
				password);
		if (isAuthenticated == false)// 如果连接失败抛出异常
			throw new IOException("Authentication failed.");
		Session sess = conn.openSession();// 创建一个会话
		sess.requestDumbPTY();// 请求会话
		// ----------------------------------------执行命令-------------------------

		sess.execCommand("mkdir %e6%96%af%e8%92%82%e8%8a%ac%e6%a3%ae");
		System.out.println("Here is some information about the remote host:");
		InputStream stdout = new StreamGobbler(sess.getStdout());

		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
		while (true)

		{

			String line = br.readLine();

			if (line == null)

				break;
			System.out.println(line);
			sess.close();

			conn.close();
		}
	}

}
