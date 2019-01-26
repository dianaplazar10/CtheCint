package com.ctcin.arrays_n_strings;

/*
 * 
 * reference: https://stackoverflow.com/questions/19484406/detecting-if-a-string-has-unique-characters-comparing-my-solution-to-cracking	
 */
import java.util.Scanner;

public class IsPemtOfAnother_1_2 {
	
	static String str="salta";
	static final int TOTAL_ASCII_COUNT=128;//note that extended ASCII has more characters... 256

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		while(in.hasNextLine()){
			input = in.nextLine();
			//Self solution
//			boolean isPermt = isStrPemtOfstr(input);
//			printResult(isPermt);
			
			//HackerRankProposed solution 1 - HRS1
				//sort and use .equals method to compare
//				isPermt = isStrPemtOfstr_HRS1(input);
//				printResult(isPermt);
			
			//HackerRankProposed solution 2 - HRS2
				boolean isPermt = isStrPemtOfstr_HRS2(input);
				printResult(isPermt);
		}
	}

	
	//HRS1-----starts
	/**
	 * @param input
	 * As a first condition, Validate if the lengths are varied, if yes, then they are obviously not permutations
	 * And if lengths are same, then we need to validate if the characters are the same, even in their counts individually.
	 * sort and use .equals method to compare
	 * 
	 * Assumptions made, Case is also considered, as each char has a specific ASCII code.
	 */
	private static boolean isStrPemtOfstr_HRS1(String input) {
		if(input.toCharArray().length != str.toCharArray().length){//this condition is the same even in my solution.
			return false;
		}
		return sort(str).equals(sort(input));
	}

	private static Object sort(String varStr) {
		char[] charArr= varStr.toCharArray();
		java.util.Arrays.sort(charArr);
		return new String(charArr);
	}
	//HRS1----ends
	
	//HRS2----starts
	/**
	 * @param input
	 * As a first condition, Validate if the lengths are varied, if yes, then they are obviously not permutations
	 * And if lengths are same, then we need to validate if the characters are the same, even in their counts individually. 
	 * iterate and store vals of first string in int[] and then iterate over the second string and 
	 * decrement the count on the int[] as and when a char exists here as well.and if this item, is<0, then we know its not  a permt.
	 * 
	 * Assumptions made, Case is also considered, as each char has a specific ASCII code.
	 */
	private static boolean isStrPemtOfstr_HRS2(String input) {
		if(input.toCharArray().length != str.toCharArray().length){//this condition is the same in all solution.
			return false;
		}
		//assuming the characters are ASCII and hence only 128
		int[] charsArr = new int[128];
		for (char ch : str.toCharArray()) {
			int charAsciiVal = ch;
			charsArr[charAsciiVal]++;
		}
		
		for (char inputch : input.toCharArray()) {
			int inputchAsciiVal = inputch;
			charsArr[inputchAsciiVal]--;
			if(charsArr[inputchAsciiVal]<0) 
				return false;
		}
		return true;
	}
	//HRS2----ends


	/**
	 * @param in
	 * As a first condition, Validate if the lengths are varied, if yes, then they are obviously not permutations
	 * And if lengths are same, then we need to validate if the characters are the same, even in their counts individually. This is done using lambdas and streams in java 8.
	 * 
	 * Assumptions made, Case isn't a concern.
	 */
	private static boolean isStrPemtOfstr(String input) {		
			if(input.toCharArray().length != str.toCharArray().length){
				return false;
			}
			for (char charvar : input.toCharArray()) {
				long countInput = input.chars().filter(ch -> ch == charvar).count();
				long countStr = str.chars().filter(ch -> ch == charvar).count();
				if(countInput!=countStr)
					return false;
			}
		return true;
	}

	private static void printResult(boolean isPermt) {
		if(isPermt) System.out.println("The given string is a permutation of the existing");
		else System.out.println("The strings are not permutations of each other");
		
	}
}
