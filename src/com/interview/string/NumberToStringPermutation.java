package com.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* Goldman sach*/

public class NumberToStringPermutation {

	public NumberToStringPermutation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		
		  
	List<List<Integer>> out  =	converArray("21212345");
	 System.out.println(out); 
			/*
		String num="2112";
		char[] chArr = num.toCharArray(); 
      List<List<Integer>> list = new ArrayList<>();
		int a1 = 1;
		char b = (char)(a1 + '0');
		System.out.println(b);
		System.out.println((int)'a');
		String temp ="";
		int[] arr = {2,1,1,2};
		*/
		/*
		int number = 1234567890;
		int len = Integer.toString(number).length();
		int[] iarray = new int[len];
		for (int index = 0; index < len; index++) {
		    iarray[index] = number % 10;
		    number /= 10;
		}*/
		int[] iarray = convertNumToArr("1234567890");
		for(int num1 : iarray)
 System.out.println(num1);
	  List<Integer> tempArr = new ArrayList<>();
	 	
		/*
		for(int i=0; i< arr.length;i++)
		{
		
			char a = (char) (arr[i]  + 96);
			System.out.println(a);
			if(isAlphabet(a))
			{
				temp += a; 
			}
			else
			{
				temp="";
				break;
			}
			//System.out.println(isAlphabet(a));
		}
		
		System.out.println("world "+temp);
		*/
	}
	
	static boolean isAlphabet(char ch)
	{
		if( (int)ch >= 97 && (int)ch <= 122 )
		{
			return true;
		}
		return false;
	}
	
  public static String getStringFromNumArr(List<Integer> lst)
  {
	  String temp ="";
	  for(Integer num : lst)
	  {
		  char a = (char) (num  + 96);
			System.out.println(a);
			if(isAlphabet(a))
			{
				temp += a; 
			}
			else
			{
				temp="";
				break;
			} 
	  }
	  return temp;
  }
  public static List<List<Integer>> converArray(String num)
  {
	
	  
	  
	  List<List<Integer>> list = new ArrayList<>();
	  
	  List<Integer> lst1 = new ArrayList<>(); 
	  
	  for(int j=0;j<num.length();j++)
	  {
		  lst1.add(Integer.parseInt(num.charAt(j)+""));
	  }
	  list.add(lst1);
	  
	  for(int i=0;i< num.length();i++)
	  {
		  List<Integer> lst = new ArrayList<>(); 
	
			  for(int j=0;j < num.length();j++)
			  {
				  if(i==j )
				  {
					  int endIndex=0;
					if(j+2 > num.length())
						endIndex = num.length();
					else
						endIndex=j+2;
						
					  String temp = num.substring(i,endIndex);
					  lst.add(Integer.parseInt(temp));
					  j++; 
					
				  }
				  else
				  {
					  lst.add(Integer.parseInt(num.charAt(j)+""));  
				  }
			  }
			  list.add(lst);
		 
	  }
	  List<Integer> pairArray = getGroupOfArray(lst1.toArray(),2);
	  list.add(pairArray);
	  return list;
  }
  public static int[] convertNumToArr(String number)
  {
	  int len = number.length();
	  int[] outPutArr = new int[len];
	  int numFormat = Integer.parseInt(number);
	  int i=0;
	  while(len > 0)
	  {
		  
		  outPutArr[i] =  numFormat%10;
		  numFormat = numFormat /10;
		  len--;
		  i++;
		  
	  }
	  int leng = outPutArr.length;
	  for(int j=0; j<= leng/2 ;j++)
	  {
		int tem =  outPutArr[j];
		outPutArr[j]=outPutArr[leng-j-1];
		outPutArr[leng-j-1]=tem;
	  }
	  
	  return outPutArr;
  }

  public int getDevider(int len)
  {
	  int outPut=1;
	  for(int i=0;i < len;i++)
	  {
		  
	  }
	  return outPut;
  }
  
  public static List<Integer> getGroupOfArray(Object[] arr,int n)
  {
	 
	  int[] original =new int[arr.length];
	  int k=0;
	  for(Object obj : arr)
	  {
		  original[k] = Integer.parseInt(obj.toString());
		  k++;
	  }
	  int[] outPutarr=null;
	  String out="";
	  int chunk = n; // 
		List<Integer> lst = new ArrayList<>();
		for(int i=0;i<original.length;i+=chunk){
			
			String temp ="";
			outPutarr= Arrays.copyOfRange(original, i, Math.min(original.length,i+chunk));
			for(int num : outPutarr)
			{
				temp+=num;
			}
			lst.add(Integer.parseInt(temp));
			
		} 
			
			System.out.println(lst);
	  return lst;
  }
}
