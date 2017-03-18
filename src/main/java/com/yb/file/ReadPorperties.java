package com.yb.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * 
 * @author YB
 * @date Oct 26, 2009
 * @desc 读取porperties配置文件方法
 * 
 * 
 */
public class ReadPorperties {
	private static final String PropertiesName = "chargeClient.properties";

	public static String readProperties(String properKey) {
		InputStream inputStream = ReadPorperties.class.getClassLoader()
				.getResourceAsStream(PropertiesName);
		Properties p = new Properties();
		String returnProVal = "";
		try {
			p.load(inputStream);
			returnProVal = 	new   String(p.getProperty(properKey).trim().getBytes("iso-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnProVal;
	}

	@Test
	public void test() {
		System.out.print(readProperties("charge.appserver.address"));
	}
}
