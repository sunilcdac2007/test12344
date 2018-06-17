package com.harman.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	
	protected BlockingQueue<Thread> queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for(int i=0;i<queue.size();i++)
            {
            Thread t=	queue.peek();
            t.start();
            queue.take();
            }
            	
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
