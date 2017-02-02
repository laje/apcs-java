/*
 * Dan Lynch
 * Mr. MacDonald
 * AP Computer Science A
 * 6 December 2016
 */

import java.util.Scanner;

public class main {
	
	//Define the variables that are used in program.
	public static String userInput;
	public static int sentenceLength;
	public static double wordLength;
	
	public static void main(String [] args){
		//Call the functions of the program.
		getUserInput();
		analyzeString(breakString());
		returnInformation();
	}
	
	//Get the user's input.
	public static void getUserInput(){
		//Create a new scanner that reads the user's inputs.
		Scanner s = new Scanner(System.in);
		
		//Ask the user for their sentence.
		System.out.println("Please enter some text..");
		System.out.print("Text: ");
		
		//Set the variable for the user's input to whatever they wrote.
		userInput = s.nextLine();
	}
	
	//break the string into words based on spaces.
	public static String[] breakString(){
		//Split the string based on spaces and return it.
		//I have this in its own method since it's sort of separate from the analysis
		return userInput.split("\\s");
	}
	
	//Analyze the string
	public static void analyzeString(String[] input){
		//Look at all of the values in the returned array, and complete an action for each of them.
		for(int i=0; i < input.length; i++){
			//Increase a variable by the amount of letters in a given word.
			wordLength += input[i].length();
		}
		//Since I haven't averaged the wordLength yet, I can just use that as the sentence value.
		sentenceLength = (int) wordLength;
		
		//(If you wanted to include spaces,)
		//sentenceLength += (input.length - 1);
		
		//This is the last step in averaging the word length in the sentence.
		wordLength /= input.length;
	}
	
	//Just displaying the information that the user needs to know.
	public static void returnInformation(){
		//The amount of words in the sentence is equal to the amount of items in the array returned by splitting the input.
		System.out.println("Words in Sentence: " + breakString().length +
				"\nSentence Length: " + sentenceLength + " characters, excluding " + (breakString().length - 1) + " spaces." +
				"\nAverage Word Length: " + wordLength + " characters."
				);
	}
}
