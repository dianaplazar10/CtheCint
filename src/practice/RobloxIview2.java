package practice;

// Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

// Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

// image1 = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 1, 1, 1, 1, 1, 1],
// ]

// Sample output variations (only one is necessary):

// findRectangle(image1) =>
//   x: 3, y: 2, width: 3, height: 2
//   2,3 3,5 -- row,column of the top-left and bottom-right corners

// Other test cases:

// image2 = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 0],
// ]

// findRectangle(image2) =>
//   x: 6, y: 4, width: 1, height: 1
//   4,6 4,6

// image3 = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 0, 0],
//   [1, 1, 1, 1, 1, 0, 0],
// ]

// findRectangle(image3) =>
//   x: 5, y: 3, width: 2, height: 2
//   3,5 4,6
  
// image4 = [
//   [0, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
// ]

// findRectangle(image4) =>
//   x: 0, y: 0, width: 1, height: 1
//   0,0 0,0

// image5 = [
//   [0],
// ]

// findRectangle(image5) =>
//   x: 0, y: 0, width: 1, height: 1
//   0,0 0,0

// n: number of rows in the input image
// m: number of columns in the input image

import java.io.*;
import java.util.*;

public class RobloxIview2 {
  public static void main(String[] argv) {
    int[][] image1 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image2 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0}
    };

    int[][] image3 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 0, 0},
      {1, 1, 1, 1, 1, 0, 0}
    };

    int[][] image4 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image5 = {
      {0}
    };
    
    // Expected output : 2,3 3,5; List<List<Integer>>
    
//     List<List<Integer>> listOfCoOrds = getZeroRectangleCoOrd(image1);
    System.out.println(getZeroRectangleCoOrd(image1));
    System.out.println(getZeroRectangleCoOrd(image2));
    System.out.println(getZeroRectangleCoOrd(image3));
    System.out.println(getZeroRectangleCoOrd(image4));
    System.out.println(getZeroRectangleCoOrd(image5));
  }
  
  public static List<List<Integer>> getZeroRectangleCoOrd(int[][] arr) {
    if(arr==null) return null;
    List<List<Integer>> listOfCoOrds = new ArrayList<List<Integer>>();
    int row = 0;
    int column = 0;
    exitLabel :
    for(int i=0; i<arr.length;i++) {
      for(int j=0; j<arr[i].length;j++) {
        if(arr[i][j] == 0) {
          row = i;
          column = j;
          while((row < arr.length) && (arr[row][j] == 0)){
            row++;
          }
          while((column < arr[i].length) && (arr[i][column] == 0)){
            column++;
          }
          listOfCoOrds.add(Arrays.asList(i,j));
          listOfCoOrds.add(Arrays.asList(row-1,column-1));
          //j = arr[i].length;
          
          break exitLabel;
        }
      }
    }
    return listOfCoOrds;
  }
}

// row=m
// col=n
// O(m*n)
//   O(4 +2) : O(6)