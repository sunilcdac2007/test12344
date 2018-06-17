package com.harman.blockingQueue;

public class ThreadGroupDemo  implements Runnable {

	public void run() {  
        System.out.println(Thread.currentThread().getName());  
  }  
 public static void main(String[] args) {  
    ThreadGroupDemo runnable = new ThreadGroupDemo();  
        ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");  
          
        Thread t1 = new Thread(tg1, runnable,"one");  
        t1.start();  
        System.out.println("Active thread count "+tg1.activeGroupCount());

        Thread t2 = new Thread(tg1, runnable,"two");  
        t2.start();  
        System.out.println("Active thread count "+tg1.activeGroupCount());

        Thread t3 = new Thread(tg1, runnable,"three");  
        t3.start();  
        System.out.println("Active thread count "+tg1.activeGroupCount());
     
        System.out.println("Thread Group Name: "+tg1.getName());  
        tg1.list(); 
     
        System.out.println("Active thread count "+tg1.activeGroupCount());

  }  
	
}
