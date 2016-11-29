/*
 * DAN LYNCH
 * AP COMPUTER SCIENCE - MR. MACDONALD
 * 7.5 PROBLEM SET
 * OCTOBER 25TH, 2016
 * 
 * BEVERLY PUBLIC HIGH SCHOOL 
 */

import java.util.Scanner;

public class main {	
	public static void main(String [] args){
		Scanner reader = new Scanner(System.in);
		
		System.out.println("-------------------------");
		System.out.println("|    Math Operations    |");
		System.out.println("-------------------------");
		
		//ask the user for any number
		System.out.println("Please enter a number");
		System.out.print("Number: ");
		
		//record the response
		double number = reader.nextFloat();
		
		//show some information about the number that the user gave.
		System.out.println("That number would round up to: " + Math.ceil(number));
		System.out.println("That number would round down to: " + Math.floor(number));
		System.out.println("The absolute value of that number is: " + Math.abs(number));
		
		//ask the user for another number to use in the following number comparisons.
		System.out.println("Please enter a second number");
		System.out.print("Second Number: ");
		
		//record the response
		double number2 = reader.nextFloat();
		
		//give some information based on the comparison of those numbers.
		System.out.println("The larger of the two numbers would be " + Math.max(number, number2));
		System.out.println("The smaller of the two numbers would be " + Math.min(number, number2));
	
		
		//Switch into the string operations.
		
		System.out.println("-------------------------");
		System.out.println("|   String  Operations  |");
		System.out.println("-------------------------");
		
		//prompt the user for some string. it can be as long as they want, whatever.
		System.out.println("Please enter a string of text");
		System.out.print("Text: ");
		
		//I guess i have to define a new scanner here. If i don't then it just goes on without waiting for an input. it took me *way* to long to figure that out.
		Scanner reader2 = new Scanner(System.in);
		
		//record the response
		String text = reader2.nextLine();
		
		//shows use of isEmpty() : if the user entered nothing at the prompt, tell'em they're stupid.
		if (text.isEmpty()) {
			//give a snappy response if the user didn't enter anything.
			System.out.println("Ha, ha. Very funny. There's nothing in that string. We can't do anything with that.");
		} else {
			//pick a random letter position from the user's string. shows my use of .length() method - make sure not to select a letter at a position that does not exist.
			double randomNumber = Math.floor(Math.random()*text.length());
			
			//do the calculation of the substring, since I use it a few times later on. The random number was a double, and it had to be cast to an integer to be used with the substring method.
			String randomLetter = text.substring((int) randomNumber, (int) randomNumber + 1);
			
			//show my use of the substring method to the user.
			System.out.println("Starting from zero, the character at position " + (randomNumber) + " in the string is " + randomLetter);
			
			//Show my use of the indexOf method to the user.
			System.out.println("The letter " + randomLetter + " first occurs in the position " + text.indexOf(randomLetter));
			
			//show that I know how to use text.replace . I couldn't really think of a nice way to fit it into the program cleanly. 
			System.out.println("By the way, that letter stinks. Let's replace all instances of it. ");
			System.out.print("Enter a letter to replace " + randomLetter + " with: ");
			
			//decorate the response a little bit.
			System.out.println("~~ " + text.replace(randomLetter, reader.next()) + " ~~");
			System.out.println("See, isn't that so much nicer?");
		}
	}
}
