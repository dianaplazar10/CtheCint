package com.ctcin.arrays_n_strings;

/*
 * Given a String, figure out of it is a permutation of a palindrone
 * 
 * Possible solution:
 * 1)If the length of the given string is even, then the the total of each characters would be an even number
 * 2)If the length of the given string is odd, then there are 2 possibilities, Count of all but 1 character  would be odd
 * 
 * In order to make the solution easy, we could lowercase all the letters, 
 * remove all spaces in the given string prior to validation with the above 2 steps.
 */
public class IsPrmtOfPalindrome_1_4 {

	static String str = "Tact Coa";
	
	public static void main(String[] args) {
		str = str.toLowerCase().replaceAll(" ", "").trim();
		int strLength = str.length();
		boolean bool = false;
		if(strLength%2 == 0){
			bool = isPrmtOfPalin(str,true);
		}else {
			bool = isPrmtOfPalin(str,false);
		}
		printTheResult(bool);
	}
	/**
	 * @param bool
	 */
	private static void printTheResult(boolean bool) {
		if(bool) 
			System.out.println("The given string is a permutaion of a palindrome");
		else
			System.out.println("The given string is NOT a permutaion of a palindrome");
	}
	private static boolean isPrmtOfPalin(String str2, boolean isEvenLength) {
		boolean bool = writeStrCharCounts(str.toCharArray(),isEvenLength);
		return bool;
	}
	
	private static boolean writeStrCharCounts(char[] charArray, boolean isEven) {
		int[] charArr = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for (char ch :charArray) {			
			charArr[Character.getNumericValue(ch)-Character.getNumericValue('a')]++;			
		}
		int noOfOddChar = 0;
		for (int i = 0; i < charArr.length; i++) {
			if(isEven && charArr[i]%2!=0) {
				return false;
			}
			if(!isEven && charArr[i]%2!=0){
				noOfOddChar++;
			}
		}
		return noOfOddChar==1;
	}

}
