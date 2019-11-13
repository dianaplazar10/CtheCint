package com.ctcin.arrays_n_strings;
/*
 *The class implements a functions to remove all copies of given values from the array and return the new array size.
 *
 *In the process, the array also needs to move the non-given values to the front of the array
 *
 *leetcode url : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveArrayItemGivenValue_leetcode {

	public static void main(String[] args) {
		int[] arr={3,5,6,4,5,5,9,7,0};
		int returnSize = removeElement(arr,5);
		System.out.println(returnSize);

	}
	
	// The solutions is,
	//Add all the characater to the same array with a runner counter, 
	//only if the value isnt equal to the given value, hence, we oudl have the final array with all the non copies in front
	public static int removeElement(int[] nums, int val) {
		int counter=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[counter]=nums[i];
                counter++;
            }
        }
        return counter;
    }

}
