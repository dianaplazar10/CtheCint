package com.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapUtil {
	
	public static <T> HashMap<Integer,Object> CreateHashmap(T[] t){
		Map<Integer,Object> map = null;
		if(t instanceof String[]){ 
			map = new HashMap<Integer,Object>();
			for (int i = 0; i < t.length; i++) {
				map.put(i, (String) t[i]);
			}			
		}
		if(t instanceof Integer[]){
			map = new HashMap<Integer,Object>();
			for (int i = 0; i < t.length; i++) {
				map.put(i,  (Integer) t[i]);
			}
		}
		return (HashMap<Integer, Object>) map;		
	}

}
