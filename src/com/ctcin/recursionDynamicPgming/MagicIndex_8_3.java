package com.ctcin.recursionDynamicPgming;
/*
 * Magic index in context of an array is the index when th evalue is also the same as index.. example: arr[1] = 1, 
 * then 1 is a magic index, similarly, if arr[6]=6, then 6 is a mgaic index
 * 
 * This class implements the function that gets the magic index in a given array.
 * 
 * We coudl directly parse through all elements via brute force as below to get the magic index, 
 * 
 * However, to make it more efficient, we could do a partial binary seach.
 * This hold only the given array is sorted.
 * 
 * example, in sorted array
 */
public class MagicIndex_8_3 {

	public static void main(String[] args) {
		int[] arr = {4,63,5,8,12,5,98,20};
		int magicIndex=getMagicIndexOfArr(arr);//bruteForce
		printMagicIndexResult(magicIndex);
		
		
		//With sorted array, can implement more efficient method 
		int[] sortedarr = {2,2,3,4,5,5,98,20};
		magicIndex=getMagicIndexOfSortedArr(sortedarr);//bruteForce
		System.out.println("Number of iterations: "+ SortedArrcounter);
		printMagicIndexResult(magicIndex);

	}

	static int SortedArrcounter=0;
	private static int getMagicIndexOfSortedArr(int[] sortedarr) {
		return getMagicIndexOfSortedArray(sortedarr,0,sortedarr.length);
	}

	private static int getMagicIndexOfSortedArray(int[] sortedarr, int startIndex, int endIndex) {
		if(endIndex<startIndex) 
				return -1;
		SortedArrcounter++;
		int midIndex = (startIndex+endIndex)/2;
		if(sortedarr[midIndex]==midIndex) 
			return midIndex;
		else if(midIndex<sortedarr[midIndex])
			return getMagicIndexOfSortedArray(sortedarr,midIndex+1,endIndex);
		else
			return getMagicIndexOfSortedArray(sortedarr,startIndex,midIndex-1);
	}

	/**
	 * @param magicIndex
	 */
	private static void printMagicIndexResult(int magicIndex) {
		if(magicIndex!=-1)
			System.out.println("The magic index is :" + magicIndex);
		else
			System.out.println("The given array has no magic index");
	}

	private static int getMagicIndexOfArr(int[] arr) {
		int counter=0;
		for (int i = 0; i < arr.length; i++) {
			counter++;
			if(arr[i]==i)
				return i;
		}
		System.out.println("Number of iterations: "+ counter);
		return -1;
	}

}
