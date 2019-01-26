package com.ctcin.arrays_n_strings;


/*
 * Given an NxN matrix, Rotate the matrix by 90 degree
 * 
 * This problem involves 2 major steps
 * 1)find the transpose of the matrix
 * 2)Inverse the transpose(colum-wise for 90 degree rotate)
 */

public class RotateNbyNmatrix_1_7 {

	public static void main(String[] args) {
		String[][] nnmatrix = createNprintNxNmatrix(4);
		
		System.out.println();
		System.out.println("Transpose of above matrix: ");
		nnmatrix=getTranspose(nnmatrix);
		printmatrix(nnmatrix);
		
		System.out.println();
		System.out.println("Inverse of the Transpose: ");
		nnmatrix=getInverseFromTranspose(nnmatrix);
		printmatrix(nnmatrix);
		
		System.out.println();
		System.out.println("Inverse of the Transpose / vertical flip / column-wise flip: ");
		nnmatrix=getInverse(nnmatrix);
		printmatrix(nnmatrix);
	}
	
	/*
	 * This is an inverse of matrix, also a column-wise/vertical flip of the matrix
	 * 
	 * This method takes in an matrix and flips it vertically,
	 * hence mirroring the matrix right to left
	 */
	private static String[][] getInverseFromTranspose(String[][] nnmatrix) {//This is also a column-wise/vertical flip of the matrix
		 int firstIndex=0; int lastIndex=nnmatrix.length-1;
		 while(firstIndex<lastIndex){
			 for (int i = 0; i < nnmatrix.length; i++) {
				String temp = nnmatrix[i][firstIndex];
				nnmatrix[i][firstIndex] = nnmatrix[i][lastIndex];
				nnmatrix[i][lastIndex]=temp;				
			}
			 firstIndex++;
			 lastIndex--;
		 }
		
		return nnmatrix;
	}

	/*
	 * This is an inverse of matrix, also a row-wise/horizontal flip of the matrix
	 * 
	 * This method takes in an matrix and flips it horizontally,
	 * hence mirroring the matrix upside down
	 */
	private static String[][] getInverse(String[][] nnmatrix) {
		 int firstIndex=0; int lastIndex=nnmatrix.length-1;
		 while(firstIndex<lastIndex){
			 for (int i = 0; i < nnmatrix.length; i++) {
				String temp = nnmatrix[firstIndex][i];
				nnmatrix[firstIndex][i] = nnmatrix[lastIndex][i];
				nnmatrix[lastIndex][i]=temp;				
			}
			 firstIndex++;
			 lastIndex--;
		 }
		
		return nnmatrix;
	}
	
	

	private static String[][] getTranspose(String[][] nnmatrix) {
		String[][] nnmatrixTransposed=nnmatrix;
		for (int i = 0; i < nnmatrixTransposed.length; i++) {
			for (int j = i; j < nnmatrixTransposed.length; j++) {
				String temp = nnmatrixTransposed[i][j];
				nnmatrixTransposed[i][j] = nnmatrixTransposed[j][i];
				nnmatrixTransposed[j][i]=temp;				
			}
		}
		return nnmatrixTransposed;
	}

	/**
	 * This method takes in a the size of an N by N matrix and creates one.
	 * Once created, prints it row-wise
	 */
	private static String[][] createNprintNxNmatrix(int n) {
		String[][] nnmatrix=new String[n][n];
		for (int i = 0; i < nnmatrix.length; i++) {
			for (int j = 0; j < nnmatrix.length; j++) {				
				nnmatrix[i][j] = (i + "" +j);
				System.out.print(nnmatrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		return nnmatrix;
	}
	
	/*
	 * In comparison to the method: createNprintNxNmatrix,
	 * this method only prints the matrix row -wise, while the earlier also creates it.
	 */
	private static void printmatrix(String[][] nnmatrix) {
		for (int i = 0; i < nnmatrix.length; i++) {
			for (int j = 0; j < nnmatrix.length; j++) {	
				System.out.print(nnmatrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
