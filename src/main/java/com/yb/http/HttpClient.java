package com.yb.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClient {
	CloseableHttpClient httpclient = HttpClients.createDefault();

	// @Test
	public void get() throws ClientProtocolException, IOException {
		HttpGet httpget = new HttpGet("http://www.baidu.com/");
		System.out.println("executing request " + httpget.getURI());
		// 执行get请求.
		CloseableHttpResponse response = httpclient.execute(httpget);

		// 获取响应实体
		HttpEntity entity = response.getEntity();
		// 打印响应状态
		System.out.println(response.getStatusLine());
		System.out.println("Response content: " + EntityUtils.toString(entity));
	}

	@Test
	public void post() throws ClientProtocolException, IOException {
		HttpPost httppost = new HttpPost("http://localhost:8080/ytain/springboot");
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("type", "house"));

		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(uefEntity);
		System.out.println("executing request " + httppost.getURI());
		CloseableHttpResponse response = httpclient.execute(httppost);

		HttpEntity entity = response.getEntity();
		System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
	}

}
