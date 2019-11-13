package com.ctcin.arrays_n_strings;

import java.util.Scanner;

/*
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * Return the minimum number of flips to make S monotone increasing. 

Example 1:
---------
Input: "00110"
Output: 1
Explanation: We flip the last digit to get 00111.

Example 2:
---------
Input: "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.

Example 3:
---------
Input: "00011000"
Output: 2
Explanation: We flip to get 00000000.
 * 
 */
public class Flip2MonotoneIncrease_leetcode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int flipsNeeded = minFlipsMonoIncr(str);
		//leetCodeSolution(str); 
		System.out.println("Min flips needed to flip str :"+ str +"to make it monotone increasing string is :  " + flipsNeeded);

	}

	// -------------------------CORRECT leetcode solution. 
	//My solutions (minFlipsMonoIncr()) failed while first character is 1, and pass for all others, under the assumption that first letter is '0'
	public static int leetCodeSolution(String S) {
		int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N-j-(P[N]-P[j]));
        }
        return ans;
	}
	
	
	 public static int minFlipsMonoIncr(String S) {
		 int count1=0;
		 int count0=0;
		 
		 //Count all '0's after the first occurence of '1's.. handled at (1)
		 //count all 1's through the string
		 //The min of the 2 counts will yield the needed flip
		 int first0indexAfterfirst1s = 0;
		 for (int i = 0; i < S.length(); i++) {
			if(first0indexAfterfirst1s==0 && S.charAt(i)=='1') //---(1)
				first0indexAfterfirst1s++;
			if(first0indexAfterfirst1s!=0 && S.charAt(i) == '0'){
				count0++;
			} else if(S.charAt(i) == '1'){
				count1++;
			}
		}
		 
		 //if last letter i is'1', then we only need to worry about all the 1's in between and npt teh last few, hence the below while loop
		 if(S.charAt(S.length()-1)=='1'){
			 int j = S.length()-1;
			 while(S.charAt(j)=='1' && j>-1){
				 j--;
				 count1--;
			 }
		 }
	     return Math.min(count1, count0);
	   }

}
