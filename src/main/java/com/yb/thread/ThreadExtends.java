package com.yb.thread;

import java.lang.Thread;

public class ThreadExtends extends Thread {
	private String name;

	public ThreadExtends(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程开始：" + this.name + ",i=" + i);
		}
	}
}