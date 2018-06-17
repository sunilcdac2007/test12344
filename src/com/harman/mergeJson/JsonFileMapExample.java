package com.harman.mergeJson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.common.collect.ImmutableMap;

public class JsonFileMapExample {
	
	public static final String JSONfILE1="D:\\workspace\\core_java\\src\\com\\harman\\mergeJson\\input1.json";
	public static final String JSONfILE2="D:\\workspace\\core_java\\src\\com\\harman\\mergeJson\\input2.json";

	public static void main(String[] args) {
		 ObjectMapper mapper = new ObjectMapper();
		  try { 
		 Map<String, Object> map_json1 = mapper.readValue(new File(JSONfILE1),new TypeReference<Map<String, Object>>() { });
         Map<String, Object> map_json2 = mapper.readValue(new File(JSONfILE2),new TypeReference<Map<String, Object>>() { });
         System.out.println(map_json1);
         System.out.println(map_json2);
         
         Map<String, Object> map2 = (Map<String, Object>) map_json1.get("metadata");         
         Map<String, Object> map_json3 = new HashMap<String, Object>();          
         map_json3 = mergeMyTwoMaps((Map<String, Object>) map_json1.get("metadata"),(Map<String, Object>) map_json2.get("metadata"));            
         System.out.println(map_json3);
		  }
		  catch (Exception e) {
              e.printStackTrace();
          }
	}

	  static Map<String, Object> mergeMyTwoMaps(Map<String, Object> map1, Map<String, Object> map2) {
          return ImmutableMap.<String, Object>builder()
              .putAll(map1)
              .putAll(map2)
              .build();
        }
}
