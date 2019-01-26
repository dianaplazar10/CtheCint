package com.ctcin.arrays_n_strings;

/*
 * This program replaces the " " within a given string with "%20". 
 * 
 * The given string however also postfixes the required char spaces for the additional characters.
 * 
 * Given String : Mr. John Doe    
 * output: Mr.%20John%20Doe
 *  
 */


public class URLify_1_3 {

	public static void main(String[] args) {
		String str = "Mr. John Doe    ";
		String retStr = "";
		//retStr = replaceSpaceUsingReplaceAll(str);
		retStr = replaceUsingCharArr_HRS1(str);
		System.out.println(retStr);
	}
	
	/**
	 * self solution
	 * @param str
	 * As the method name suggesst,
	 * This method returns the given string by 
	 * replaces all the spaces with "%20" 
	 * using the String's "ReplaceAll" function
	 */
	private static String replaceSpaceUsingReplaceAll(String str) {
		return "URLified string" + str.replaceAll(" ", "%20");
	}

	/*
	 * HRS1
	 * @param str
	 * This method replaces the " " within the given string by replacing them with "%20",
	 * Without using default String API's such as ReplaceAll, etc
	 * 
	 * steps this is done in:
	 * 1)convert the given string to char array
	 * 
	 * Assumption made:
	 * The full length of given string is filled with empty spaces at the end equivalent 
	 * to what we need if the mid-word-spaces are filled with 3 characters in concern("%20")
	 */
	private static String replaceUsingCharArr_HRS1(String str) {
		char[] chFullStr=str.toCharArray();
		int fullStrlen = chFullStr.length;//if the str len is not including the empty spaces , then we will have to calculate the same.
		int lethWithoutEmptyCharsAtEnd = str.trim().length();
		
		for (int i =lethWithoutEmptyCharsAtEnd-1 ; i >=0; i--) {
			if(chFullStr[i] == ' '){
				chFullStr[fullStrlen-1]='0';
				chFullStr[fullStrlen-2]='2';
				chFullStr[fullStrlen-3]='%';
				fullStrlen=fullStrlen-3;
			} else {
				chFullStr[fullStrlen-1] = chFullStr[i];
				fullStrlen--;
			}
		}
		String retStr = new String(chFullStr);
		return retStr;
	}

	

}
