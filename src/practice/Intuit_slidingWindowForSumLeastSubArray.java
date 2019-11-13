package practice;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


// Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

// Input: [2, 1, 5, 3, 3, 2], S=7 
// Output: 2
// Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 3].
  
class Intuit_slidingWindowForSumLeastSubArray {
  public static void main(String[] args) {
    
    int[] arr = {2, 1, 5, 2, 3, 2};
    int s = 7;
    int smallestSubSize = getSmallestSubArrSize(arr,s);
    if(smallestSubSize == 0) {
      System.out.println("No such SubArray in the given Array");
    } else {
            System.out.println("smallest SubArray = " + smallestSubSize);
    }
  }
  
  public static int getSmallestSubArrSize(int[] arr, int sum) {
    if(arr.length==0) {
      return 0;
    }
    int total = 0;
    int smallestArray = arr.length;
    
    for(int i =0; i<arr.length;i++) {
      if(arr[i] == sum) {
        smallestArray = 1;
      }
      for(int j=i; j<arr.length;j++) {
        total = total+arr[j];
        if(total == sum) {
          if ((j -i ) < smallestArray) {
            smallestArray= j-i+1;
          }
        }
      }
      total=0;
    }
    return smallestArray;
  }
}

