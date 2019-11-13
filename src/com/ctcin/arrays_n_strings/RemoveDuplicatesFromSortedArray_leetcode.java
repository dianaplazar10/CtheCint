package com.ctcin.arrays_n_strings;

import java.util.Arrays;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1:
-------------
Given nums = [1,1,2], 
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
----------
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.

Solution:
---------
Since array sorted, we know that no duplicates would be repeated more than the current repetitive sequest, ie, we will not find repeats in thsi fashion - > 1,2,2,3,2... where 2 is duplicated after 3 as well.
It would only be of the format given in the above examples
 */

public class RemoveDuplicatesFromSortedArray_leetcode {

	public static void main(String[] args) {
		int[] arr={5,5,5,5,9,9,10,11,11};//{1,1,2};//
		int newSize = removeDuplicates(arr);
		System.out.println(newSize);
	}
	
	public static int removeDuplicates(int[] nums) {
		int runner=1;
		for(int i = 1; i<nums.length;i++){
			if(nums[i] != nums[i-1]){
				nums[runner]=nums[i];
				runner++;
			}
		}
		return runner;
    }
}
