package com.yb.security;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class Base64Test {
	@Test
	public void mainTest() throws Exception {
		System.out.println(new String(Base64.decodeBase64("cXQuZ3RpbWcuY24=")));	
		System.out.println(Base64.encodeBase64String("源天科技".getBytes()));
	
	}
}
