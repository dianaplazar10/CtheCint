package com.hashmaps;

import java.util.HashMap;

/*
 * The interest of this clas is to find the number with odd number of occurrences within the given array
 * 
 * Assumption made is that there is only one number that is repeated odd times in the given array
 * 
 */
public class FindOddumberOfInt {

	public static void main(String[] args) {
		int[] arr = {2,4,2,3,61,3,4,4,4,11,11};
		/*This hashmap would hold only digits with odd occurences.
		* The logic used is to create and populate the map as and when we figure the item in teh array is occurred odd times,
		* First occurence will make an entry, as its odd occurence(1). however, 
		* the next occurence (if any) of the same item, excludes the item from the map. 
		* However, it the same item occurs a third time, its occurence is still going to be 1, which is odd.
		* 
		* We are only interested in returning the odd occurrences number 
		* and not the number of times it occured, hence, thsi method works best with minimal space and o[n] time complexity
		* */
		int oddInt = getOddTimesOccuredInt(arr);
		System.out.println("----Oddly occurred int is ------" + oddInt);

	}

	private static int getOddTimesOccuredInt(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])){
				map.remove(arr[i]);
			} else {
				map.put(arr[i], 1);
			}
		}
		//Since the array has only one item with odd occurences, thsi map would have only 1 item
		return (int) map.keySet().toArray()[0];
	}

}


/*
 * ----Oddly occurred int is ------61
 */