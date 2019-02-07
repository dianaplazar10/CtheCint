package practice;
import java.util.Scanner;

abstract class Calculator {
    abstract int add(int a, int b);
}

/*
 * Write the implementations of Adder and Multiplier classes.
 */
 class Adder extends Calculator {
    public Adder() {
    }

    public int add(int a, int b) {
        return a + b;
    }
}

class Multiplier {
    public Multiplier() {
    }

    public int multiply(int a, int b, Calculator adderCalculator) {
        int result=0;
        for(int i=0; i<b;i++){
            result= result + a;
        }
        return result;
    }
}

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final Calculator CALCULATOR = new Adder();
    
    private static void testAddition(int a, int b) {
        System.out.println("Sum = " + CALCULATOR.add(a, b));
    }
    
    private static void testMultiplication(int a, int b) {
        System.out.println("Product = " + new Multiplier().multiply(a, b, CALCULATOR));
    }
    
    public static void main(String[] args) {
        int a = Integer.parseInt(INPUT_READER.nextLine());
        int b = Integer.parseInt(INPUT_READER.nextLine());
        
        System.out.println("Testing Addition");
        testAddition(a, b);
        
        System.out.println("\nTesting Multiplication");
        testMultiplication(a, b);
    }
}