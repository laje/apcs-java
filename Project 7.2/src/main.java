/*
 * Dan Lynch
 * Beverly High School
 * ------------------
 * AP Computer Science (VHS)
 * Project 7.2
 * Mr. MacDonald
 * 
 * 22 November 2016
 */

import java.util.Scanner;

public class main{
	//define all of the variables that will be used in the in the program.
	static int maxval = 100, minval = 0, turn = 0;
	static double guess = 0;
	static boolean complete = false;
	
	//define the scanner
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String [] args){
		//initialize the game, which really just starts a loop.
		initGame();
	}
	
	public static void initGame(){
		//Start the previously mentioned loop, keep it going until the user says the computer guessed the numbers
		while(!complete){
			computerGuess();
		}
	}
	
	public static void computerGuess(){
		//Choose a guess for the computer. It's random so things are a little more interesting.
		//I know this isn't the most efficient way, but it's not excruciatingly boring.
		guess = minval + Math.ceil(Math.random() * (maxval - minval) / 2);
		
		//Write out the computers guess and prompt for the person's response
		System.out.println("The computer's guess is: " + guess + ". Did the computer guess the number? If not, is the number greater or less than that guess?");
		System.out.print("Enter \"c\" if the computer was correct, \"l\" for less or \"g\" for greater: ");
		
		//record the user's response, 
		char userIn = reader.next().charAt(0);
		
		//add one to the turn counter
		turn++;
		
		//different conditions based on the user's response and change the max/min values if needed
		if( userIn == 'l' ){
			maxval = (int) guess;
		} else if ( userIn == 'g' ){
			minval = (int) guess;
		} else if (userIn == 'c'){
			//change set the game state to complete and let the user know how long it took the computer to guess.
			System.out.println("Nice! It took the computer " + turn + " guesses to get the number.");
			complete = true;
		} else {
			//If the user didn't put in a valid answer, let them know. Also lose a count on the turn since this shouldn't really count as one.
			System.out.println("That's not a valid answer!");
			turn--;
		}
	}
	
}