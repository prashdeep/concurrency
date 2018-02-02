package com.edureka.delayqueue;

import java.util.concurrent.BlockingQueue;

public class MessageConsumer {

	private String name;

	private BlockingQueue<Message> queue;

	public MessageConsumer(String name, BlockingQueue<Message> queue) {
		super();
		this.name = name;
		this.queue = queue;
	}

	private Thread consumerThread = new Thread(() -> {
		while (true) {
			try {
				// Take elements out from the DelayQueue object.
				Message object = queue.take();
				System.out.printf("[%s] - Take object = %s%n", Thread.currentThread().getName(), object);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});

	public void start() {
		this.consumerThread.setName(name);
		this.consumerThread.start();
	}

}
