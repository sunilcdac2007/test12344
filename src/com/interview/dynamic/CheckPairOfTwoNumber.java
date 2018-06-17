package com.interview.dynamic;

import java.util.HashSet;
import java.util.Set;

public class CheckPairOfTwoNumber {

	public static void main(String[] args) {
		int arr[] = {2, 11, 5, 1, 4, 2,1};
		
		System.out.println(checkPairOfNum(arr));

	}

	
	static boolean checkPairOfNum(int[] arr)
	{
		
		int sum=0;
		
		for(int num : arr)
			sum+=num;
		
		if(sum % 2 != 0)
			return false;
		sum=sum/2;
		
		Set<Integer> s = new HashSet<>();
		for(int i=0;i< arr.length ; i++)
		{
			int val = sum-arr[i];
			
			if(s.contains(val))
			{
				return true;
			}
			s.add(arr[i]);
		}
		
		return false;
	}
	
}
