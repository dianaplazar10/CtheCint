package com.hashmaps;

/*
 * Reference sites: https://www.journaldev.com/146/hashmap-implementation-with-list-in-java
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

class MyHashMap<K ,V > {
	
	class MyMapEntry{
		K key;
		V value;
		MyMapEntry(K key,V value){
			this.key=key;
			this.value=value;			
		}	
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" +key + " : " + value+"]";
		}
	}

	List<MyMapEntry> entriesList = new ArrayList<MyMapEntry>();

	void put(K k, V v) {
		if(k==null){
			throw new NullPointerException(" The key value cannot be null");
		}
//		for(MyMapEntry entry : entriesList){// Throws concurrent exception as we try and remove entry in array while iterating through the array
		for (int j = 0; j < entriesList.size(); j++) {
			if(k==(entriesList.get(j).key)){
				entriesList.remove(entriesList.get(j));
			}
		}
		entriesList.add(new MyMapEntry(k, v));
	}
	
	V get(K key){
		for(MyMapEntry entry : entriesList){
			if(entry.key==key) 
				return entry.value;
		}
		return null;
	}
	
	void print(){
		entriesList.forEach(entry -> System.out.println(entry));
	}
	
}


public class ImplementHashMap_getput{
	public static void main(String[] args) {
		MyHashMap<Integer, String> myhashmap = new MyHashMap<Integer, String>();
		//myhashmap.put(null,"one");
		myhashmap.put(1,"one");
		myhashmap.put(1,"one");
		myhashmap.put(1,"keyDup");
		myhashmap.put(2,"two");
		myhashmap.put(3,"three");
		String value= myhashmap.get(3);
		System.out.println("Value _________________________" + value);
		System.out.println();
		
		myhashmap.print();
		
		
		
	}
	
}