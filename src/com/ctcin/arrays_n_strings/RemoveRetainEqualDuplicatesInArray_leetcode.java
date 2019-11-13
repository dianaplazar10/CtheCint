package com.ctcin.arrays_n_strings;

/*
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared 
 * "at most twice" and return the new length
 * -------------
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * ---------
 * Given nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * ----------
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It doesn't matter what values are set beyond the returned length.
 */

//HARDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD

public class RemoveRetainEqualDuplicatesInArray_leetcode {

	public static void main(String[] args) {
		int[] arr={0,0,1,1,1,1,2,3,3};//{5,5,5,9,9,10,11,11};//{1,1,2,2};//
		int newSize = removeDuplicates(arr);
		System.out.println(newSize);
	}
	
	//Assumption: letters can be repeated to a max of n times, else, remove it to move the next integers
	//
	
	public static int removeDuplicates(int[] nums) {
		if(nums==null)
	        return 0;
	 
	    if (nums.length <= 2)
	        return nums.length;
		/*
			1,1,1,2,2,3
		  	  i j
		 */
	    int i = 1; // point to previous
	    int j = 2; // point to current
	 
	    while (j < nums.length) {
	        if (nums[j] == nums[i] && nums[j] == nums[i - 1]) {
	            j++;
	        } else {
	            i++;
	            nums[i] = nums[j];
	            j++;
	        }
	    }
	 
	    return i + 1;
		//Checking for less than 2, since only 2 duplicates are allowed, the below filter would ignore of the arr is only of length 2, with 2 elements either same or not, which is allowed.
//		if(nums.length<2) 
//			return nums.length;
//		int i=2;//starting with 3rd element, as first 2 element can be repeated with no changes needed.
//		int extraDups=getExtraDups(nums);
//		while(i<nums.length){
//			if(nums[i]==nums[i-1] && nums[i]==nums[i-2]){ // do nothing, if this and previous 2 elements are the same.
//				i++;
//			} else {
//				nums[i-1]=nums[i];
//				i++;
//			}
//		}
//		return nums.length-extraDups;

    }

	/*
	private static int getExtraDups(int[] nums) {
		int i=2;
		int dups=0;
		while( i < nums.length) {
			if(nums[i]==nums[i-1] && nums[i]==nums[i-2]){
				dups++;
			}
			i++;
		}
		return dups;
	}
	*/
	

}
