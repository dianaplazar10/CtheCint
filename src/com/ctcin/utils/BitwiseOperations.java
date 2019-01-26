package com.ctcin.utils;
/*
 * reference video: https://www.youtube.com/watch?v=ruWWIBV560U
 */

public class BitwiseOperations {

	public static void main(String[] args) {
		/// << >> >>>(logical right shift fill with zeros
		int a=2;
		System.out.println("int a: "+a);
		System.out.println("Binary a: "+ Integer.toBinaryString(a));
		System.out.println("Binary (a<<1): "+ Integer.toBinaryString(a<<1));
		System.out.println("Binary (a>>1): "+ Integer.toBinaryString(a>>1));

		System.out.println();
		byte b=120;
		System.out.println("byte b: "+b);
		System.out.println("Binary b: "+ Integer.toBinaryString(b));
		System.out.println("Binary (b<<1): "+ Integer.toBinaryString(b<<1));
		System.out.println("Binary (b>>1): "+ Integer.toBinaryString(b>>1));
		
		System.out.println();
		b=(byte) 255;// returns negative number(-126).. since range is -126 ~ 127 only..
		System.out.println("byte b: "+b);
		System.out.println("Binary b: "+ Integer.toBinaryString(b));
		System.out.println("Binary (b<<1): "+ Integer.toBinaryString(b<<1));
		System.out.println("Binary (b>>1): "+ Integer.toBinaryString(b>>1));
		
//		System.out.println("Hexadecimal : "+ Integer.toHexString(a));
//		System.out.println("Octal : "+ Integer.toOctalString(a));
//		System.out.println("UnsignedLong : "+ Integer.toUnsignedLong(a));


	}

}


/**
Output:
	int a: 2
	Binary a: 10
	Binary (a<<1): 100
	Binary (a>>1): 1

	byte b: 120
	Binary b: 1111000
	Binary (b<<1): 11110000
	Binary (b>>1): 111100

	byte b: -126
	Binary b: 11111111111111111111111110000010
	Binary (b<<1): 11111111111111111111111100000100
	Binary (b>>1): 11111111111111111111111111000001
*/
