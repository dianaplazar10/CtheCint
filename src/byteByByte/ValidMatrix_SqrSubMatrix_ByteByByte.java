package byteByByte;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * reference video : https://www.youtube.com/watch?v=NYeVhmWsWec&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj&index=38
 * 
 * Problem:
 * -------
 * Given a 2D array(Matrix) with values 1 or 0, find the size of the largest mXm matrix, consisting of only 1's.
 * 
 * if, in the below matrix, the max size of largest valid square matrix = 3
 * Example:
 * {{1,1,1,1},
 * 	{1,1,1,0},
 * 	{1,1,1,1},
 * 	{1,1,0,1}}
 * 
 * Note that, a single element {1} is also a square sub matrix.
 * 
 * SOLUTION:
 * --------
 * a single element is also treated a valid sq matrix, therefore, we cd solve this problem via DP,
 * 1) Basically start from the first element , and gradually go from there till the last element.
 * 2) Create a new matric that holds the size information of each cell, a cell that holds a 1, indicates a single valid sq matrix,
 * 3) if a cell holds 2, it indicates that the cells above and below and left-top-diagonally, are all one's, indicating a size 2 valid sq matrix and so on.
 * 
 */

public class ValidMatrix_SqrSubMatrix_ByteByByte {

	public static void main(String[] args) {
		int[][] matrix=get2Darray();
		int validSqMatrixSize=getValidMatrixSize(matrix);
		System.out.println("Max Size of valid sq matrix :" + validSqMatrixSize);

	}
	
	private static int getValidMatrixSize(int[][] matrix) {
		int[][] sizeInfoMatrix = new int[matrix.length][matrix[0].length];
		if(matrix.length==0) return 0;
		if(matrix[0].length==0) return 0;
		for (int i = 0; i < sizeInfoMatrix.length; i++) {
			for (int j = 0; j < sizeInfoMatrix[0].length; j++) {
				if(matrix[i][j]==0) 
					sizeInfoMatrix[i][j]=0;
				else if(i==0 || j==0)
					sizeInfoMatrix[i][j] = matrix[i][j];
				else
					sizeInfoMatrix[i][j] = 1 + Math.min(sizeInfoMatrix[i][j-1], 
												Math.min(sizeInfoMatrix[i-1][j-1],sizeInfoMatrix[i-1][j]));
			}
		}
		return getMaxOf2DMatrix(sizeInfoMatrix);
	}

	private static int getMaxOf2DMatrix(int[][] sizeInfoMatrix) {
		IntStream stream = Arrays.stream(sizeInfoMatrix).flatMapToInt(Arrays::stream);
		return stream.max().getAsInt();
	}

	private static int[][] get2Darray() {
		int[][] arr = {{1, 0, 1},
					   {1, 1, 1},
					   {1, 1, 1},
					   {0, 1, 0}
					  };
		return arr;
	}

}
