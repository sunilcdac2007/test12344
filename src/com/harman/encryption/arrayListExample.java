package com.harman.encryption;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class arrayListExample {

	public static void main(String[] args) {
		
		String q = "random word £500 bank $";
		String q1="4d309PTO0sjXdOTb6M4lVuDshcZ6eFnrJM2WBoVy1wXducNqVuapxW0JXmhr4VX7JVxi23zcnVzFDE0Ob5C9M4mWooiXdCBkj2Sr5ipAFgQMFbNDHPeaaqmKUh6G7cOXDuvxOe7nCbqIBBJCUJFPBHHukrtpE595hZihkKiyytXO1WYInhxfHXzPTPfcmrDg/eY8d6EpBj+JdL04wlvoVBGFKkW8Wt3emKgW4p0oaic=";
		try {
			
			System.out.println(" time in milisecond "+Calendar.getInstance().getTimeInMillis());
			//"http://example.com/query?q=" +
			String url =  URLEncoder.encode(q1, "UTF-8");
			System.out.println(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread[]	primaryPredictorThreads = new Thread [ 5 ] ;
		for(int i=0;i<5;i++)
		{
			primaryPredictorThreads[i] = new Thread(new myReunnable());
			primaryPredictorThreads[i].start();
		}
		List<List<String>> outerList= new ArrayList<>();
		
		List<String> inerList = new ArrayList<String>();
		
		inerList.add("a");
		inerList.add("b");
		inerList.add("c");
		inerList.add("d");
		
		outerList.add(inerList);
		
inerList = new ArrayList<String>();
		
		inerList.add("a");
		inerList.add("b");
		inerList.add("c");
		inerList.add("d");
		outerList.add(inerList);	
	
inerList = new ArrayList<String>();
		
		inerList.add("a");
		inerList.add("b");
		inerList.add("c");
		inerList.add("d");
		outerList.add(inerList);	
//		System.out.println("outer list size "+outerList.size());

	}

}
class myReunnable implements Runnable{
	
	public void run() {
		
		for(int i=0;i<10;i++)
			System.out.println(Thread.currentThread().getName()+" "+i);
	}
}
