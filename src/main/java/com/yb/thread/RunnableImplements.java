package com.yb.thread;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class RunnableImplements implements Runnable {
	private String name;
	
	CompletableFuture<Integer> re = null;

	public RunnableImplements(String name) {
		this.name = name;
	}

	public RunnableImplements(CompletableFuture<Integer> re,String name) {
		this.re = re;
		this.name = name;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程开始：" + this.name + ",i=" + i);
		}
	}
}
