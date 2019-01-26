package com.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NestedHashMap {

	public static void main(String[] args) {
		String[] strArr = {"apple","mango","grapes"};
		 HashMap<Integer, Object> mapFruits = HashMapUtil.CreateHashmap(strArr);
		
		Integer[] intArr={3,5,1,6,9};
		HashMap<Integer, Object> mapInteger = HashMapUtil.CreateHashmap(intArr);
		
		Map<String, Object> mapOfMaps = new HashMap<String, Object>();
		mapOfMaps.put("fruits", mapFruits);
		mapOfMaps.put("Numbers", mapInteger);
		
		String fruit2Get = "mango";
		String val = get2ndKeyValFromNestedMap(mapOfMaps,fruit2Get);
		System.out.println("-----val-----" + val);
		
		
	}

	private static String get2ndKeyValFromNestedMap(Map<String, Object> mapOfMaps, String fruit2Get) {
//		for(Entry<String, Object> entry : mapOfMaps.entrySet()){
//			if(entry.getKey().equalsIgnoreCase("fruits")){
//				//HashMap<Integer, Object> map =  (HashMap<Integer, Object>) entry.getValue();
//				return (String) ((HashMap<Integer, Object>) entry.getValue()).get(1);
//			}			
//		}
		//above commented works too, in case we are searching against a key
		((HashMap<Integer, Object>) mapOfMaps.get("fruits")).get(1);
		return null;
	}
}
