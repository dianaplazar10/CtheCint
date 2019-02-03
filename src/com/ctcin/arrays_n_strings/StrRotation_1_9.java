package com.ctcin.arrays_n_strings;

/*
 * A problem to validate if , 
 * Given 2 strings, Srt1 and Str2, one of them is a rotation of the other.
 * 
 * example, 
 * if Str1 = "waterbottle", Str2='bottlewater", then validation is needed to see if Str2 is a rotation of Str1?
 * In teh case of above example both strings are rotation of each other
 * 
 * Steps for validation of rotation:
 * --------------------------------
 * 1) Validate if both strings are of equal sizes, if not, then return false
 * 2) If of equal sizes, then we could simply check if STR2 is a substring of (str1+str1), or check if str1 is a substring of (str2+str2)
 * 
 * 
 */
public class StrRotation_1_9 {

	public static void main(String[] args) {
		String str1 = "The city is beautiful";
		String str2 = "city is beautiful The";
		//isStr2RotOfStr1
		boolean subsExists =isStr2RotOfStr1(str1.replaceAll(" ","").toLowerCase(),str2.replaceAll(" ","").toLowerCase()); 
		if(subsExists) System.out.println("String '" + str2 + "' is a rotation of String '" + str1 + "'");
		else System.out.println("The strings '"+str1 + "' and '"+str2+"' are not rotations of each other");

	}

	private static boolean isStr2RotOfStr1(String str1, String str2) {
		//1) Validate if both strings are of equal sizes, if not, then return false
		if(str1.length()!=str2.length()) return false;
		//2) If of equal sizes, then we could simply check if STR2 is a substring of (str1+str1), or check if str1 is a substring of (str2+str2)
		boolean isStr2SubsOfStr1Twice = isStr2SubsOfStr1Twice(str2,str1+str1);
		return isStr2SubsOfStr1Twice;
	}

	private static boolean isStr2SubsOfStr1Twice(String str2, String str1Twice) {
		int str2IndexinStr1 = str1Twice.indexOf(str2);
		int str2Index = 1;
		if(str2IndexinStr1<0) {
			return false;
		} else {
			for(int indexStr1=str2IndexinStr1+1; indexStr1<str2.length(); indexStr1++){
				if(str1Twice.charAt(indexStr1)!=str2.charAt(str2Index)){
					return false;
				}
				str2Index++;
			}
		}
		return true;
	}

}
