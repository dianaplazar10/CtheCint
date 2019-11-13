package com.ctcin.arrays_n_strings;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class IsUnique_1_1 {
	
	static char repeatedch;
	
	static final int TOTAL_ASCII_COUNT=256;//considering extened ASCII

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String input = in.nextLine();
			System.out.println("user input : " + input);
			input = input.replace(" ", "").trim();
			
//			System.out.println("---------Results without datastructure usage-------------");
//			boolean isStrUnique_UsingDS = isStrUnique_withDS(input);
//			printIsUnique(isStrUnique_UsingDS);//also print first non unique substring- with DataStructure Hashmap
//			printRepeats_UsingDS(input);//print all repeated characters with number of repeats on each- with DataStructure Hashmap
			
			System.out.println("---------Results without datastructure usage-------------");
			boolean isStrUnique_noDS = isStrUnique_noDS(input);
			printIsUnique(isStrUnique_noDS);//also print first non unique substring- with DataStructure Hashmap
		
			System.out.println("in the format --> \"searchString : searchStrType\"");
		}
	}

	private static void printRepeats_UsingDS(String input) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : input.toCharArray()) {
//			map.containsKey(ch) ? map.put(ch, map.get(ch) + 1) : map.put(ch, 1);		
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
			}
			else
				map.put(ch, 1);
		}		
		if(map.size()>0){
			for(Entry<Character,Integer> entryset : map.entrySet()){
				if(entryset.getValue()>1)
					System.out.println(entryset.getKey() + ":" + entryset.getValue());				
			}
		}
	}
	
	private static boolean isStrUnique_withDS(String input) {//using data structure
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : input.toCharArray()) {
			if(map.containsKey(ch)){
				repeatedch = ch;
				return false;
			}
			else
				map.put(ch, 1);
		}		
		return true;
	}
	
	/*
	 * Assumption made: 
	 * ---------------
	 * The input string only ontains EXTEDED ASCIIcharacter.
	 * In which case, the length should not exceed more than the total Extended ASCII characters, which is 256. 
	 * If it does, then we know that the string has repeated characters. 
	 * Hence validating that as first condition to avoid iteration and datastructures.
	 * 
	 * note:
	 * ----
	 * Total ASCII characters = 128
	 * Total unicode characters = 65536
	 */
	
	private static boolean isStrUnique_noDS(String input){
		if(input.length()>TOTAL_ASCII_COUNT)//TOTAL_ASCII_COUNT=256
			return false;
		
		boolean[] boolArr = new boolean[TOTAL_ASCII_COUNT];//defaults all to false
		for (char ch : input.toCharArray()) {
			//Initializing boolean array for ASCII coded index with false, and assigning them true if exists.
			int asciiOfCh = ch;
			if(boolArr[asciiOfCh]){
				repeatedch = ch;
				return false;
			} else{
				boolArr[asciiOfCh]=true;
			}
		}
		return true;
		
	}

	/**
	 * @param isStrUnique
	 */
	private static void printIsUnique(boolean isStrUnique) {
		if(isStrUnique)
			System.out.println("All characters in the string are unique");
		else {
			System.out.println("Some characaters are repeated in the given input. The first one being : " +  repeatedch);
			repeatedch=0;
		}
	}

}
