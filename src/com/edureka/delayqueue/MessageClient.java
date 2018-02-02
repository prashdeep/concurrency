package com.edureka.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class MessageClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Creates an instance of blocking queue using the DelayQueue.
		BlockingQueue<Message> queue = new DelayQueue<>();
		
		// Starting DelayQueue Producer to push some delayed objects to the queue 
		new MessageProducer(queue).start();
		
		// Starting DelayQueue Consumer to take the expired delayed objects from the queue
		new MessageConsumer("Consumer Thread-1", queue).start();

	}

}