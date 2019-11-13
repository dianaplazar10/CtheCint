package com.ctcin.arrays_n_strings;
/*
 * reference video :  
 * 
 * PROBLEM : Check for existence of a substring in a given string
 * 
 *  KnuthMorrisPratt can be used for th egiven problem.
 *  
 *  KnuthMorrisPratt is a string-pattern search algorithm
 *  For the given problem, the Brute force would be O(m * n) where M is the length of the substring and n is th elength of the given string
 *  Using KnuthMorrisPratt, the solution would be of Time complexity O(m+n), with below steps:
 *  1)Create a helper array that would hold the prefix and suffix information of the substring.(Watch the reference video to better understand how this helper array is generated)
 *  2)Now, while over both th epointers less than the respective str/substirng lengths,----->while(i < text.length && j < pattern.length){
 *  3)In each iteration, compare the characters between the String and the substring, using 2 pointers, (j)one on the str and the (i)other on the substring
 *  4)if(both indices match) increment both pointers
 *  5)else reset substrng pointer to value at (i-1) of the helper array
 *  
 */
public class SubsstrInGvStr_KnuthMorrisPratt_EXTRA {

	public static void main(String[] args) {
		String pattern="aabaazzbaaa";
		String mainStr = "abbbaabaabaabaaa";
		System.out.println("isPattern_in_mainStr ? "+isPattern_in_mainStr(pattern,mainStr));
	}

	private static String isPattern_in_mainStr(String pattern, String mainStr) {
		int[] preFixLogic = getPreFixLogicArray_4_pattern(pattern.toCharArray());
		boolean isPatternInMain = isPatternInStr(pattern,mainStr,preFixLogic);
		
		return String.valueOf(isPatternInMain);
	}

	private static boolean isPatternInStr(String pattern, String mainStr, int[] preFixLogic) {
	        int i=0;
	        int j=0;
	        while(i < mainStr.length() && j < pattern.length()){
	            if(mainStr.toCharArray()[i] == pattern.toCharArray()[j]){
	                i++;
	                j++;
	            }else{
	                if(j!=0){
	                    j = preFixLogic[j-1];
	                }else{
	                    i++;
	                }
	            }
	        }
	        //Except the beow check, the above is similar to checking while generating the prefix array
	        if(j == pattern.length()){
	            return true;
	        }
	        return false;
	}

	private static int[] getPreFixLogicArray_4_pattern(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

}
