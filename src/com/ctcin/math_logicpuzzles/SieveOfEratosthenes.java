package com.ctcin.math_logicpuzzles;

import java.util.Arrays;

/*
 * 
 * Generating a list of Primes : The Sieve of Eratosthenes
 */
public class SieveOfEratosthenes {
	
	public static void main(String[] args) {
		int givenNum = 10;
		boolean[] primes = sieveOfEratosthens(givenNum);
		for (int j = 0; j < primes.length; j++) {
			if(primes[j]==true)
				System.out.print(j + " ");
		}
	}

	private static boolean[] sieveOfEratosthens(int givenNum) {
		int prime = 2;
		boolean[] primeflags = new boolean[givenNum+1];
		
		//- 1 - We will define all the primes upto given number, by caching them as false(not prime) ina bool array
		initPrimeFlags(primeflags);
		
		while(prime<=Math.sqrt(givenNum)){
			//- 2 - crossOff remaining bumbers fo curent prime.. ie, if current prime is 2, then all multiple of 2 is not prime, so that needs o cross off as false in primeflags[]
			crossOff(primeflags,prime);
			
			//- 3 - reset next prime. Simply retrive the next true in bool[]
			prime = getNextPrime(primeflags,prime);
		}
		return primeflags;
	}

	private static int getNextPrime(boolean[] primeflags, int prime) {
		int next = prime+1;
		while(next<primeflags.length && (primeflags[next]==false)){ // this conditions controlls that the iteration goes only until next true item in the array
			next++;
		}
		return next;
	}

	private static void crossOff(boolean[] primeflags, int prime) {
		/*
		 * Note here that the iteration starts from ( prime * prime ), 
		 * as the previous numbers ouwld all be covered while crossing off for previous primes.
		 */
		for (int i = prime*prime; i < primeflags.length; i=i+prime) {
			primeflags[i]=false;
		}
	}

	private static void initPrimeFlags(boolean[] primeflags) {
		Arrays.fill(primeflags, true);
		primeflags[0] = false;
		primeflags[1] = false;
	}

}
