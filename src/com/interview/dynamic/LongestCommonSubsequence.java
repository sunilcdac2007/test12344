package com.interview.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public int lcs(char str1[],char str2[],int len1, int len2){
        
        if(len1 == str1.length || len2 == str2.length){
            return 0;
        }
        if(str1[len1] == str2[len2]){
            return 1 + lcs(str1,str2,len1+1,len2+1);
        }
        else{
            return Math.max(lcs(str1,str2,len1+1,len2),lcs(str1,str2,len1,len2+1));
        }
    }

    public int lcsDynamic(char str1[],char str2[]){
    
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;
    
    }
    
    public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        List<?> lst = new ArrayList<>();
       
        List<? super Object> lst1 = new ArrayList<>();
        Integer in = new Integer(1);
        lst1.add("q");
        lst1.add(2);
        lst1.add(new Object());
        List<? super Number> list = new ArrayList<Object>();
        list.add(1);
        list.add(1.1f);
        list.add(2l);
       // list.add(new Object());
        List<Number> list1 = new ArrayList<Number>();
        list1.add(1);
        list1.add(1.2f);
        list.add(2l);
        
        
        int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }
    
    
    
}
