package com.ctcin.bitmanipulation;
/*
 * reference video: https://www.youtube.com/watch?v=ruWWIBV560U
 */

public class BitwiseOperations {

	public static void main(String[] args) {
//		printShiftOperationExamples();

		int four = 4;
		int six = 6;// if we clear the one'th bit index of bit of 6 to 0, the value resulting int value would be 4, since, 2^1 == 0 in 0110
		
		byte bit = getNthBit(four,1);
		int bitAtNthPosition =  (bit==0)?0:1;
		System.out.println("Bit at ith position of the given number :"+ bitAtNthPosition);
		
		bit = setNthBit(four,1);
		System.out.println("Int val after setting Nth bit of int : "+ four + " ,to '1' :"+ bit);
		
		bit = clearNthBit(six,1);
		System.out.println("Int val after clearing Nth bit of int : "+six+ " ,to '0' :"+ bit);
	}

	/*
	 * Setting a bit means making it 1. 
	 */
	private static byte setNthBit(int intVal, int bitIndex) {
		return (byte) (intVal | (1<<bitIndex));
	}


	/*
	 * retrieve the nth bit value
	 */
	private static byte getNthBit(int intVal,int bitIndex) {
		return (byte) (intVal & (1<<bitIndex));
	}
	
	/*
	 * Clearing a bit means making it 0
	 */
	private static byte clearNthBit(int intVal, int index2Clear){
		return (byte)(intVal &(~(intVal<<index2Clear)));
	}
	
	/*
	 * To toggle (invert) a bit, is to change its bit value from 0->1 and 1->0
	 * myByte ^= 1 << bit;
	 */
	private static byte invertNthBit(int intVal, int index2Invert){
		return (byte) (intVal^(1 << index2Invert));
	}

	/**
	 * 
	 */
	private static void printShiftOperationExamples() {
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
		
		System.out.println();
		b=(byte) 130;// returns negative number(-126).. since range is -126 ~ 127 only..,
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
