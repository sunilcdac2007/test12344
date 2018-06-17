package com.interview.array;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ArrayAddition {

    public int[] add(int arr1[], int arr2[]){
        int l = Math.max(arr1.length, arr2.length);
        int[] result = new int[l];
        int c=0;
        int i = arr1.length-1;
        int j= arr2.length-1;
        int r=0;
        l--;
        while(i >=0 && j >=0){
            r = arr1[i--] + arr2[j--] + c;
            c = r/10;
            result[l--] = r%10;
        }
        while(i>=0){
            r = arr1[i--] + c;
            c = r/10;
            result[l--] = r%10;
        }
        while(j>=0){
            r = arr2[j--] + c;
            c = r/10;
            result[l--] = r%10;
        }
        if(c != 0){
            int[] newResult = new int[result.length+1];
            for(int t= newResult.length-1; t> 0; t--){
                newResult[t] = result[t-1];
            }
            newResult[0] = c;
            return newResult;
        }
        return result;
    }
    
    public static void main(String args[]){
    	
    	String q = "random word £500 bank $";
    	try {
    		System.out.println("original string "+q);
			String url =  URLEncoder.encode(q, "UTF-8");
			System.out.println(" url encode "+url);
			String seconUrl = URLEncoder.encode(url, "UTF-8");
			System.out.println(" second url "+seconUrl);
			String result = java.net.URLDecoder.decode(seconUrl, "UTF-8");
			System.out.println("Result "+result);
			String result2 = java.net.URLDecoder.decode(result, "UTF-8");
			System.out.println("result2 "+result2);
			 result2 = java.net.URLDecoder.decode(result2, "UTF-8");
			 System.out.println("result2 "+result2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    long tim=	Calendar.getInstance().getTimeInMillis();
    
    System.out.println("Time in milisecond "+tim);
    	String str="sunil kumar";
    	String[] arr= str.split(" ");
    	for(String name : arr)
    		System.out.println(name);
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    	String date = sdf.format(new Date());
    	System.out.println(date); //15/10/2013
       
       System.out.println("Date  "+new Date() );
    	
        int arr1[] = {9,9,9,9,9,9,9};
        int arr2[] = {1,6,8,2,6,7};
        ArrayAddition aa = new ArrayAddition();
        int result[] = aa.add(arr1, arr2);
        for(int i=0; i < result.length; i++){
            System.out.print(" " + result[i]);
        }
    }
}
