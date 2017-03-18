package com.yb.thread;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class ThreadTest {
	// @Test
	public void RunnableImplementsTest() {
		for (int i = 0; i < 10; i++) {
			Runnable t = new RunnableImplements(i + "");
			new Thread(t).start();
		}
	}

	// @Test
	public void ThreadExtendsTest() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread t = new ThreadExtends(i + "");
			t.start();
		}
	}

	@Test
	public void RunnableImplementsCompletableFutureTest() throws InterruptedException {
		final CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		new Thread(new RunnableImplements(future,"ytain")).start();
		// 模拟长时间的计算过程
		Thread.sleep(1000);
		// 告知完成结果
		future.complete(60);
	}
}
