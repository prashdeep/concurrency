package com.edureka.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo 
{
    public static void main(String args[]) throws InterruptedException 
    {
        // creating a Semaphore object
        // with number of permits 1
        Semaphore sem = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(10);
         
        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        MyThread mt1 = new MyThread(sem, "A", latch);
        MyThread mt2 = new MyThread(sem, "B", latch);
         
        // stating threads A and B
        mt1.start();
        mt2.start();
         
        // waiting for threads A and B 
       // mt1.join();
        //mt2.join();
        latch.await();
         
        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("Printing after both threads are done completing the job: " + Shared.count);
    }
}