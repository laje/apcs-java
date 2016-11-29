/*
 * Dan Lynch
 * Beverly High School
 * ------------------
 * AP Computer Science (VHS)
 * Project 7.1
 * Mr. MacDonald
 * 
 * 22 November 2016
 */

import java.util.Scanner;

public class main {
	
	/* Initialize variables:
		Count: keeps track of the turn number.
		Number: the number that is randomly selected
		Guess: the number that the player guessed on a given turn
		Reader: user input */
		
	public static int count = 1;
	public static int number = (int) selectRandomNumber();
	public static int guess = -1;
	public static Scanner reader = new Scanner(System.in);
	
	//main function just calls the playgame function
	public static void main(String [] args){
		playGame();
	}
	
	//selects and returns a number between 1 and 100 (inclusive)
	public static double selectRandomNumber(){
		return Math.ceil(Math.random() * 100);
	}
	
	//
	public static void playGame(){
		// (for testing) System.out.println(number);
		
		//while the person hasn't guessed the number, keep playing the game
		while(guess != number){
			//take the player's input
			playerTurn();
			
			//check if they got it right
			checkWin();
		}
	}
	
	public static void playerTurn(){
		//define a variable to hold a message to be sent to user
		String msg;
		
		//set a message depending on if it's the first turn.
		if(count == 1){
			System.out.println("[---- Turn " + count + " ----]");
			msg = "Let's play a game! Guess a number between one and one hundred, inclusive.";
		} else {
			msg = "Wrong guess! Try again!";
		}
		
		//Send the message to the user and ask for their next guess.
		System.out.println(msg);
		System.out.print("Enter your guess here: ");
		
		//add one to the turn counter
		count++;
	}
	
	public static void checkWin(){
		//get the next thing the user types.
		guess = (int) reader.nextDouble();
		
		//if they win, end it
		if (guess == number){
			System.out.println("[-----------------]");
			System.out.println("Nice guess, you win!");
		} else {
			//write out the information about if the user guessed high or low,
			System.out.println("[---- Turn " + count + " ----]");
			if(guess < number){
				System.out.println("The number is greater than your guess.");
			} else {
				System.out.println("The number is less than your guess.");
			}
		}
	}
}
