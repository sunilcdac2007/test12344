package com.harman.blockingQueue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

	// SimpleDateFormat is not thread-safe, so give one to each thread
	 // SimpleDateFormat is not thread-safe, so give one to each thread
	    private static final ThreadLocal<String> formatter = new ThreadLocal<String>(){
	    	String date;
	        @Override
	        protected String initialValue()
	        {
	            return date;
	        }
	    };
	
	    public static void main(String[] args) throws InterruptedException {
	        ThreadLocalExample obj = new ThreadLocalExample();
	        for(int i=0 ; i<10; i++){
	            Thread t = new Thread(obj, ""+i);
	            Thread.sleep(new Random().nextInt(1000));
	            t.start();
	        }
	    }

	    @Override
	    public void run() {
	        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get());
	        try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        Date date = new Date();

	        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        String text = fmt.format(date);
	        
	        formatter.set(text);
	        
	        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get());
	    }
}
