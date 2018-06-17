package com.harman.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue<Thread> queue = null;

    public Producer(BlockingQueue queue,int i) {
        this.queue = queue;
        Thread.currentThread().setName("name "+i);
    }
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
	
	@Override
	public void run() {
		try {
			long id =Thread.currentThread().getId();
			queue.put(Thread.currentThread());
			//for(int i=0;i<10;i++)
			//	System.out.println(" ID "+id +" <><> count "+i  +" name of thread "+Thread.currentThread().getName());
			//queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
