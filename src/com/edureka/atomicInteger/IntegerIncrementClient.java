package com.edureka.atomicInteger;

public class IntegerIncrementClient {

	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();
		
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Processing count=" + pt.getCount());
	}

}

class ProcessingThread implements Runnable {

	private int count;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
	}

	public int getCount() {
		return this.count;
	}

}
