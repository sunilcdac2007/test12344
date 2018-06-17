package com.harman.blockingQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomeSort {

	final static Pattern p = Pattern.compile("^\\d+"); 
	/*
	static String[] examples = { 
			  "18-34(AGE)","18-54(AGE)","18(AGE)","18-24(AGE)"
			}; 
	*/
	static String[] examples = { 
			  "18 - 34(AGE)","18 - 49(AGE)","18 - 24(AGE)","18(AGE)"
			}; 
	public static void main(String args[])
	{
		List<String> examplesList = new ArrayList<String>(Arrays.asList(examples));
		
		Collections.sort(examplesList,customComparator);
		for(String str : examplesList)
			System.out.println(str);
	}
	
	static Comparator<String> customComparator = new Comparator<String>() {
	    @Override
	    public int compare(String object1, String object2) {
	    	
	    	System.out.println("String 1 "+object1);
	    	System.out.println("compareStr2 "+object2);
	    	object1 =object1.replace(" - ", "-");
	    	object2 =object2.replace(" - ", "-");
	        Matcher m = p.matcher(object1);
	        Integer number1 = null;
	        if (!m.find()) {
	            return object1.compareTo(object2);
	        }
	        else {
	            Integer number2 = null;
	            number1 = Integer.parseInt(m.group());
	            m = p.matcher(object2);
	            if (!m.find()) {
	                return object1.compareTo(object2);
	            }
	            else {
	                number2 = Integer.parseInt(m.group());
	                int comparison = number1.compareTo(number2);
	     
	                if (comparison != 0) {
	                    return comparison;
	                }
	                else {
	                    return object1.compareTo(object2);
	                }
	            }
	        }
	    }
	};
}
