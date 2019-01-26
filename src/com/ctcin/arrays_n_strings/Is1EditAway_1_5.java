package com.ctcin.arrays_n_strings;

/*
 * Given 2 strings, returns boolean true if both are just one edit away to become equal, else return false.
 * by edit, it could be just Insert a character in one of the 2 strings, or edit a character in one of the 2 strings. Avoid removal for now.
 */
public class Is1EditAway_1_5 {

	public static void main(String[] args) {
		String str1 = "plee";
		String str2 = "pale";
		
		boolean is1EditAway = is1EditAway(str1,str2);

	}

	private static boolean is1EditAway(String str1, String str2) {
		//first see if the lengths are the same for  both the strings, in which case, it may be a need to edit just one character to make them equal
		if(str1.length()==str2.length()){
			int counter=0;int editIndex=0;
			for(int i =0; i<str1.length()-1;i++) {// iterating over length of any strings is invalid as both are of same length from the if loop
				if(str1.charAt(i)!=str2.charAt(i)){
					editIndex=i;
					counter++;
				}
			}
			if(counter>1){
				System.out.println("More than 1 edit required to make the string equal");
				return false;
			} else {
				System.out.println("character at index" + editIndex + " needs to be updated for the strings to be equal");
				return true;
			}
		} else {//if lengths aren't the same, then we could start from figuring out which string is smaller, to identify what needs to be inserted
			String smallerStr = str1.length()<str2.length() ? str1 :str2;
			int insertIndex=0;int editCount=0;
			for(int i =0; i<smallerStr.length()-1;i++){
				if(str1.charAt(i)!=str2.charAt(i)){
					insertIndex=i;
					editCount++;			
				}
			}
			if(editCount>1){
				System.out.println("More than 1 edit required to make the string equal");
				return false;
			} else{
					System.out.println("character at index " + insertIndex + " on string \'" + smallerStr +"\' needs to be updated for the strings to be equal");
					return true;
			}
			
		}
	}

}
