/*
 * DAN LYNCH
 * BEVERLY HIGH SCHOOL
 * AP COMPUTER SCIENCE
 * Project 7.6 "Lucky Sevens Reloaded"
 * 
 * 28 NOVEMBER 2016
 * Mr. MacDonald
 */


import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main (String [] args){
		Scanner reader = new Scanner(System.in);
		Random generator = new Random();
		
		int die1, die2,
			dollars,
			count = 0,
			countTotal = 0,
			runs = 100;
		
		System.out.print("How many dollars do you have? ");
		dollars = reader.nextInt();
		
		for (int i = 0; i < runs; i++){
			while(dollars > 0){
				count++;
				
				die1 = generator.nextInt(6) + 1;
				die2 = generator.nextInt(6) + 1;
				
				if(die1 + die2 == 7)
					dollars += 4;
				else
					dollars--;
				
			}
			countTotal += count;
		}
		countTotal = countTotal / runs;
		
		System.out.println("The average amount of rolls over " + runs + " attempts is " + countTotal);
	}
}