package com.ctcin.arrays_n_strings;

import java.util.HashMap;
import java.util.HashSet;

public class StringWithNum4EachCharCount_1_6 {

	public static void main(String[] args) {
		String elabStr = "aabbbbacccdeed";
		System.out.println("elabStr : " + elabStr);
		String compressedStr = getCompressedStr(elabStr);
		System.out.println("compressedStr : "+compressedStr);

	}

	private static String getCompressedStr(String elabStr) {
		StringBuffer compressedStr= new StringBuffer();
		HashSet<Character> uniqueCharSet=new HashSet<Character>();
		//compressedStr.append(elabStr.charAt(0));
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i =0; i<elabStr.length();i++){
			if(i>0 && (elabStr.charAt(i)==elabStr.charAt(i-1) || map.containsKey(elabStr.charAt(i)))){
				map.put(elabStr.charAt(i), map.get(elabStr.charAt(i))+1);		
			} else {
				map.put(elabStr.charAt(i),1);
				uniqueCharSet.add(elabStr.charAt(i));
			}
		}
		for(Character uniqueChar: uniqueCharSet){
			compressedStr.append(uniqueChar.toString()).append(map.get(uniqueChar));
		}
		return compressedStr.toString();
	}

}
