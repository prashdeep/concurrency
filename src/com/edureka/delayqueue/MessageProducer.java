package com.edureka.delayqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class MessageProducer {
	
    // Creates an instance of blocking queue using the DelayQueue.
    private BlockingQueue<Message> queue;

	private final Random random = new Random();
	
	public MessageProducer(BlockingQueue<Message> queue) {
		super();
		this.queue = queue;
	}
	
	private Thread producerThread = new Thread(() -> {
            while (true) {
                try {
                    // Put some Messages into the DelayQueue.
                    int delay = random.nextInt(10000);
                    Message object = new Message(
                            UUID.randomUUID().toString(), delay);

                    System.out.printf("Put object = %s%n", object);
                    queue.put(object);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }, "Producer Thread");
	
	public void start(){
		this.producerThread.start();
	}

}
