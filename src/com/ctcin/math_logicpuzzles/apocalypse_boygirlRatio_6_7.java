package com.ctcin.math_logicpuzzles;

import java.util.Random;
import java.util.Scanner;

/*
 * This is an apocalypse problem where the queen devices a rule that any family should stop giving borth to children if a girl is born,
 * 
 * or rather , can give borth only until a girl is born.
 * 
 * Hence, a family of size 1 would like like G,
 * 			family of size 2 would look like BG,
 * 			family of size 3 would look like BBG,
 * 			family of size 4 would look like BBBG,
 * and so on. Hence, we are now implementinga method which takes in the size of the family and return the girl to total kids in family ratio.
 */
public class apocalypse_boygirlRatio_6_7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfFamilies = in.nextInt();
		double girl2TotChildren = getGirl2childrenRatio(noOfFamilies);
		System.out.println("girl2TotChildren :" +  girl2TotChildren);
	}

	private static double getGirl2childrenRatio(int noOfFamilies) {
		int boysTotal=0;
		int girlsTotal=0;
		for (int i = 0; i < noOfFamilies; i++) {
			int[] randomBoyGirlCountPerFamilyArr = getRandomBoyGirlCountPerFamily();
			girlsTotal = randomBoyGirlCountPerFamilyArr[0];
			boysTotal = randomBoyGirlCountPerFamilyArr[1];
		}
		
		return girlsTotal/(boysTotal+girlsTotal);
		
	}

	/**
	 * 
	 */
	private static int[]  getRandomBoyGirlCountPerFamily() {
		int boys=0;
		int girls=0;
		while(girls==0){ // increment girl or boy only until girl count !=0
			//generate random boolean, such as true for girl and false for boy
			Random random = new Random();
			boolean isGirl = random.nextBoolean();
			if(isGirl)
				girls++;
			else
				boys++;
		}
		int[] boyGirlCount = {girls,boys};
		System.out.println("Girls :" + girls + ":: Boys :" +boys);
		return boyGirlCount;
	}

}
