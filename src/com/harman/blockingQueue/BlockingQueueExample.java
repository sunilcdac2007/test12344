package com.harman.blockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
	public static BlockingQueue<Thread> queue = new ArrayBlockingQueue(1024);

	public static void main(String[] args) throws Exception {

       
      /* 
        for(int i=0;i<10;i++)
        {
        	callLogic(queue,i);
        	/*
        	 Producer producer = new Producer(queue,i);
        	Thread t = new Thread(producer);
        	t.start();
        	t.join();
        	*/
        	 
        	 
       // }
        
        // new Thread(producer).start();
       
      
		BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
       
        
       
        
    }
	
	public static void callLogic(BlockingQueue queue,int i)
	{
		Producer producer = new Producer(queue,i);
    	Thread t = new Thread(producer);
    	t.start();
    	try {
			t.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
