package com.harman.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		Map<String,String> map = new TreeMap<String,String>();
		List<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<1073741824;i++)
		{
			map.put("key"+i, "value"+i);
			
		}
     System.out.println("Size of map "+map.size());
     map.clear();
     System.out.println("Size of map after clear "+map.size());
	}

}
