package com.ctcin.arrays_n_strings;

/*
 * Problem to identify if one string is a substring of another
 * The program returns true with the first index of the substring if exists else, returns 0
 * 
 */
public class StrRotation_1_9 {

	public static void main(String[] args) {
		String mainStr = "The city is beautiful", substr = "city";
		boolean subsExists = IsStr2InMainstr(mainStr,substr);

	}

	private static boolean IsStr2InMainstr(String mainStr, String substr) {
		char[] charArr=mainStr.toCharArray();
		int index = mainStr.indexOf(substr, 0);
		if(index<0) 
			System.out.println(substr + " is not a part of the main String :" +mainStr);
		else
			System.out.println(substr+ " is present in the main str at index :" + index);
		return false;
	}

}
