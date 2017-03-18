package com.yb.adsl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
/**
 * 
 * @Copyrights  2010��Tianyuan DIC Computer Co., Ltd.
 * @projectName YBJ2SETest
 * @author YB
 * @date Jun 18, 2010 2:14:01 PM
 * @Description �ļ�����
 * 
 *
 */
public class ADSLUtil {

	/**
	 * ִ��CMD����,������String�ַ���
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
	 * ����ADSL
	 * @param adslTitle
	 * @param adslName
	 * @param adslPass
	 * @return
	 * @throws Exception
	 */
	public static boolean connAdsl(String adslTitle, String adslName,
			String adslPass) throws Exception {
		System.out.println("���ڽ�������.");
		String adslCmd = "rasdial " + adslTitle + " " + adslName + " "
				+ adslPass;
		String tempCmd = executeCmd(adslCmd);
		// �ж��Ƿ����ӳɹ�
		if (tempCmd.indexOf("������") > 0) {
			System.out.println("�ѳɹ���������.");
			return true;
		} else {
			System.err.println(tempCmd);
			System.err.println("��������ʧ��");
			return false;
		}
	}

	/**
	 *  �Ͽ�ADSL
	 * @param adslTitle
	 * @return
	 * @throws Exception
	 */
	public static boolean cutAdsl(String adslTitle) throws Exception {
		String cutAdsl = "rasdial " + adslTitle + " /disconnect";
		String result = executeCmd(cutAdsl);

		if (result.indexOf("û������") != -1) {
			System.err.println(adslTitle + "���Ӳ�����!");
			return false;
		} else {
			System.out.println("�����ѶϿ�");
			return true;
		}
	}

	/**
	 * ����
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		connAdsl("����", "hzhz**********", "******");
		Thread.sleep(1000);
		cutAdsl("����");
		Thread.sleep(1000);
		// ����������һ���µ�IP
		connAdsl("����", "hzhz**********", "******");
		String ip,address;
		InetAddress addr = InetAddress.getLocalHost();
		ip=addr.getHostAddress().toString();//��ñ���IP
		address=addr.getHostName().toString();//��ñ������� 
		System.out.println(addr);
	}
}