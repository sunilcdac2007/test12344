package com.harman.blockingQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=(+-+-+-1);
int[] arr={8,6,11};

i=1;

arr[++i]=--i;
System.out.println(""+arr[0]+""+arr[1]+""+arr[2]);
System.out.println(arr[0]+arr[1]+arr[2]);
/*
String URL ="https://t.afftrackr.com/p.ashx?o=208656&e=1057&f=pb&r=TPUID&t=TPSID";
        String tpsid="123";
        String tpid ="897";
		System.out.println(" tpuid check "+URL.contains("TPUID")+" tpsid "+URL.contains("TPSID"));
		URL=URL.replaceAll("TPUID", tpid);
		URL=URL.replaceAll("TPSID", tpsid);
		System.out.println("URL after replcment "+URL);
		*/
     /*
		List<Integer> lst = new ArrayList<>();
		for(int i=0;i<94;i++)
		{
			lst.add(i);
		}
		List<List<Integer>> lstp= partitionArray(lst,10);
		System.out.println(lstp.size());
		for(List<Integer> list :lstp )
		{
			for(Integer in : list)
				System.out.println(in);
			System.out.println("New line");
		}
			*/
	}
public static	List<List<Integer>> partitionArray(List originalList,int segmentSize)
	{
		int size = originalList.size();
		int partitionArrSize = size/segmentSize;
		List<List<Integer>> partitions = new LinkedList<List<Integer>>();
		for(int i = 0; i < originalList.size(); i += segmentSize)
		{
			 partitions.add(originalList.subList(i,
			            Math.min(i + segmentSize, originalList.size())));
		}
		return partitions;
	}

}
