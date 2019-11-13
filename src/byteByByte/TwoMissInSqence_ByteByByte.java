package byteByByte;
/*byte by byte palylists
 * -----------
 * 
 * Problem:
 * --------
 * Given last number of a sequencial number series starting from 1, find the 2 missing numbers.
 * 
 * SOLUTION:
 * ---------
 * 1) we can first find the sum of the actual series, i,e if given n=5, we need to find the sum from 1 to 5,
 * 2) formula to find sum of a series with n = (n * (n+1))/2, there, is given n, sum of 1+2+3+4+5 = (5*(5+1))/2 = 15.
 * 3) Now, we could find the sum of the gv series with the missing numbers. 
 * 4) The difference between the totalsum and the sum of gvSeries is the sum of the missing numbers.
 * 		ie, if gv series = {1,2,5}, then actual series ={1,2,3,4,5,6}. totalsum=15(from 2) ). and sum of gv series =(1+2+5) = 8.
 * 		ow, 15-8=7. Therefore, the sum of the 2 missing integer = 7.
 * 5) since the series will only have non repeated sequential numbers, i,e one must be smaller than (7/2) and th eother must be greater than(7/2)
 * 		Hemce, lets treat this as ateh pivot = 7/2 = 3.
 * 		hence, we try to find the smaller missing number  in the first half of the given series and then find the 2nd missing in the second half,(values greater than 3)
 * 6) We use the XOR stratergy here. XOR of 2 same numbers returns 0. also, x^x^y = y(always). Hence using this associative property of XOR,
 * 7) we XOR the elements of first half(until pivot) of the actual series with the first half(until pivot) of the gv series, which will return the first missing ,
 * 8) we then XOR the elements of second half(after the pivot) of actual series with that of the gv series, hence finding also the 2nd missing number.
 * 
 * 
 * Problem link : https://www.youtube.com/watch?v=75Jrba2uGFM&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj&index=40
 */

public class TwoMissInSqence_ByteByByte {

	public static void main(String[] args) {
		int[] gvSeries = {1,2,4,6};
		int n = gvSeries[gvSeries.length-1];//last element in the gv series
		int[] missingNums = findMissing2Num(gvSeries,n);
		for(int item : missingNums){
			System.out.print(item+" ");
		}
	}

	private static int[] findMissing2Num(int[] gvSeries, int lastElement) {
		int actualTotalSum = (lastElement * (lastElement+1))/2;
		int gvSeriesSum = getGvSeriesSum(gvSeries);
		
		int sumOfMissingNums = actualTotalSum-gvSeriesSum;
		int pivot=sumOfMissingNums/2;
		
		int[] actualSeriesXORs =getXOR_actualSeries(gvSeries, pivot,lastElement);
		int[] gvSeriesXORs=getXOR_gvSeries(gvSeries, pivot,lastElement);
		return new int[]{actualSeriesXORs[0]^gvSeriesXORs[0], actualSeriesXORs[1]^gvSeriesXORs[1]};
	}

	private static int[] getXOR_gvSeries(int[] gvSeries, int pivot, int lastElement) {
		int xor_1=0;
		int xor_2=0;
		for(int element : gvSeries){
			if(element<=pivot)
				xor_1^=element;
			else
				xor_2^=element;
		}
		return new int[]{xor_1,xor_2};
	}

	private static int[] getXOR_actualSeries(int[] gvSeries,int pivot,int n) {
		int xorActual_1=0;
		int xorActual_2=0;
		for (int i = 1; i <= n; i++) {
			if(i<=pivot)
				xorActual_1^=i;
			else
				xorActual_2^=i;	
		}
		return new int[]{xorActual_1,xorActual_2};
	}

	private static int getGvSeriesSum(int[] gvSeries) {
		int sum =0;
		for (int i : gvSeries) {
			sum+=i;
		}
		return sum;
	}

}
