package practice;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'countSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static long countSum(List<Integer> numbers) {
        //In order to find sum of odd factors for a single integer, we simply need to ignore even factors and 
        //their powers. 

        //In order to remove all even factors, we repeatedly divide num while it is divisible by 2. Now, we 
        //only get odd factors. Note that 2 is the only even prime.
        long sum = 0l;
        for(int num : numbers){
            int oddDivisorSumFornum = 1;// since starting with first prime - odd divisor.
            //eliminate even factors by ignoring all powers of 2
            while(num%2==0)
                num=num/2;
            for(int i =3;i<Math.sqrt(num);i++){
                int count = 0,curr_sum=1;
                int curr_term=1;
                while(num%i==0){
                    count++;
                    num = num/i;
                    curr_term *= i;
                    curr_sum += curr_term;
                }
                oddDivisorSumFornum *=curr_sum;
            }

            //to handle sum when num is a prime in itself
            if(num>=2)
                oddDivisorSumFornum *= (1+num);
            
            sum = (long) sum + oddDivisorSumFornum;
        }
        return sum;
    }

}

public class OddDivisorsSum {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(21);
        numbers.add(11);
        numbers.add(7);//{21,11,7};

//        for (int i = 0; i < numbersCount; i++) {
//            int numbersItem = Integer.parseInt(bufferedReader.readLine().trim());
//            numbers.add(numbersItem);
//        }

        long result = Result.countSum(numbers);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
