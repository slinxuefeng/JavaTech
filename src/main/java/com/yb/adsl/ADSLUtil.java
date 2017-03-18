package com.yb.adsl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
/**
 * 
 * @Copyrights  2010，Tianyuan DIC Computer Co., Ltd.
 * @projectName YBJ2SETest
 * @author YB
 * @date Jun 18, 2010 2:14:01 PM
 * @Description 文件描述
 * 
 *
 */
public class ADSLUtil {

	/**
	 * 执行CMD命令,并返回String字符串
	 * 
	 * @param strCmd
	 * @return
	 * @throws Exception
	 */
	public static String executeCmd(String strCmd) throws Exception {
		Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
		StringBuilder sbCmd = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(p
				.getInputStream()));
		String line;
		while ((line = br.readLine()) != null) {
			sbCmd.append(line + "\n");
		}
		return sbCmd.toString();
	}

	/**
	 * 连接ADSL
	 * @param adslTitle
	 * @param adslName
	 * @param adslPass
	 * @return
	 * @throws Exception
	 */
	public static boolean connAdsl(String adslTitle, String adslName,
			String adslPass) throws Exception {
		System.out.println("正在建立连接.");
		String adslCmd = "rasdial " + adslTitle + " " + adslName + " "
				+ adslPass;
		String tempCmd = executeCmd(adslCmd);
		// 判断是否连接成功
		if (tempCmd.indexOf("已连接") > 0) {
			System.out.println("已成功建立连接.");
			return true;
		} else {
			System.err.println(tempCmd);
			System.err.println("建立连接失败");
			return false;
		}
	}

	/**
	 *  断开ADSL
	 * @param adslTitle
	 * @return
	 * @throws Exception
	 */
	public static boolean cutAdsl(String adslTitle) throws Exception {
		String cutAdsl = "rasdial " + adslTitle + " /disconnect";
		String result = executeCmd(cutAdsl);

		if (result.indexOf("没有连接") != -1) {
			System.err.println(adslTitle + "连接不存在!");
			return false;
		} else {
			System.out.println("连接已断开");
			return true;
		}
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		connAdsl("宽带", "hzhz**********", "******");
		Thread.sleep(1000);
		cutAdsl("宽带");
		Thread.sleep(1000);
		// 再连，分配一个新的IP
		connAdsl("宽带", "hzhz**********", "******");
		String ip,address;
		InetAddress addr = InetAddress.getLocalHost();
		ip=addr.getHostAddress().toString();//获得本机IP
		address=addr.getHostName().toString();//获得本机名称 
		System.out.println(addr);
	}
}
