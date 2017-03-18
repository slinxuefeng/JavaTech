package com.yb.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MD5 {
	public String MD5(String s) throws NoSuchAlgorithmException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		byte[] strTemp = s.getBytes();
		// 使用MD5创建MessageDigest对象
		MessageDigest mdTemp = MessageDigest.getInstance("MD5"); // MD5也可以换成SHA-1
		mdTemp.update(strTemp);
		byte[] md = mdTemp.digest();
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte b = md[i];
			str[k++] = hexDigits[b >> 4 & 0xf];
			str[k++] = hexDigits[b & 0xf];
		}
		return new String(str);
	}

	@Test
	public void EncoderByMd5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println("MD5(大灰狼,32) = " + MD5("123456"));
		System.out.println("MD5(大灰狼,32) = " + MD5(MD5("123456")));
		System.out.println("MD5(大灰狼,16) = " + MD5(MD5("大灰狼")).substring(8, 24));
	}
}
