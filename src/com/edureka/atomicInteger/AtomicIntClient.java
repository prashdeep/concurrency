package com.edureka.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntClient {

	public static void main(String[] args) throws InterruptedException {

		AtomicProcessingThread pt = new AtomicProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}
}

class AtomicProcessingThread implements Runnable {
	
	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			processSomething(i);
			count.incrementAndGet();
		}
	}

	public int getCount() {
		return this.count.get();
	}

	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}