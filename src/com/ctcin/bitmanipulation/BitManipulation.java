package com.ctcin.bitmanipulation;

//Implemented based on reference video from Gayle mcDowell : https://www.youtube.com/watch?v=NLKQEOgBAnw
public class BitManipulation {
		
	//get ith bit: if(a & (~(1<<i))) NOT EQUAL 0, return 1, else 0;
	
	//set ith bit: (a | (1<<i))
	
	//Clear/delete ith bit: (a & (~(1<<i)))
	
	public static void main(String args[]){
		int a=4;
		int i=1;
		int ithBit = get_ith_bitOf(a,i);
		System.out.println("bit at position " +i+ "of "+a+" : " + ithBit);
		
		int ithBit2 = set_ith_bitOf(a,i);
		System.out.println("value with setting bit at position " +i+ " of "+a+"to 1 is : " + ithBit2);

		int ithBit3 = clear_ith_bitOf(a,i);
		System.out.println("value with clearing bit at position " +i+ " of "+a+"to 1 is : " + ithBit3);

		
	}

	//This method replaces the bit at ith position to 1
	private static int clear_ith_bitOf(int a, int i) {
		a= a&(~(1<<i));
		return a;
	}

	//This method sets the ith bit to 1
	private static int set_ith_bitOf(int a, int i) {
		a= (a | (1<<i));
		return a;
	}

	//get ith bit: (a & (1<<i))!=0
	private static int get_ith_bitOf(int a, int i) {
		if((a&(1<<i))!=0) return 1;
		return 0;
	}

}