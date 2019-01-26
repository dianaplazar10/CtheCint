package com.ctcin.arrays_n_strings;

/*
 * Nullify or set to zero, 
 * the entire row and column of an element,
 * whose value is zero in a given matrix.
 *  
 */
public class ZeroColRowMatrix_1_8 {

	public static void main(String[] args) {
		String[][] nmMatrix = createAndPrintNMmatrix(4,3);
		printmatrix(nmMatrix);
		System.out.println();
		System.out.println("The matrix after nullified: ");
		nmMatrix=nullifyColRow(nmMatrix);
		printmatrix(nmMatrix);
	}

	private static String[][] nullifyColRow(String[][] nmMatrix) {
		label :
		for (int i = 0; i < nmMatrix.length; i++) {
			for (int j = 0; j < nmMatrix[i].length; j++) {
				if(nmMatrix[i][j].equalsIgnoreCase("00")) {
					for (int k = 0; k < nmMatrix[i].length; k++) {
						nmMatrix[i][k]="00";
					}
					for (int k = 0; k < nmMatrix.length; k++) {
						nmMatrix[k][j]="00";
					}
					break label;
				}
			}
		}
		return nmMatrix;
	}

	private static String[][] createAndPrintNMmatrix(int rowSize, int colSize) {
		String[][] nmMatrix = new String[rowSize][colSize];
		for(int i = 0;i<rowSize;i++){
			for(int j=0;j<colSize;j++){
				nmMatrix[i][j] = i+""+j;
				//if(i==0 && j==0) nmMatrix[i][j] ="11";
				//if(i==2 && j==2) nmMatrix[i][j] ="00";
			}
		}
		return nmMatrix;
	}
	
	/*
	 * this method only prints the matrix row -wise, while the earlier also creates it.
	 */
	private static void printmatrix(String[][] nnmatrix) {
		for (int i = 0; i < nnmatrix.length; i++) {
			for (int j = 0; j < nnmatrix[i].length; j++) {	
				System.out.print(nnmatrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}


}

/*
 * Output:
11 01 02 
10 11 12
20 21 00 
30 31 32 

The matrix after nullified: 
11 01 00 
10 11 00 
00 00 00 
30 31 00 
 * 
 */
