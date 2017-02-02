/*
 * Dan Lynch
 * AP Computer Science A
 * 8 December 2016
 * 
 * Beverly High School, VHS, Mr. MacDonald
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class acslchallenge {
	
	//The main method simply calls another method, with an argument passed through.
	public static void main(String[] args) throws IOException{
		//Run the loop so that each of the entries forms are calculated.
		loopProblemSolver(getUserInput());
	}
	
	//This function grabs the input file, and creates a string from its contents.
	public static String[] getUserInput() throws IOException{
		//Declare variables to read the file.
		FileInputStream inFile;
		InputStreamReader inReader;
		BufferedReader reader;
		
		//The test file that I used in order to run the program.
		String input = "test.txt";
		
		//Process the file, get it into a bufferedreader
		inFile = new FileInputStream (input);
		inReader = new InputStreamReader(inFile);
		reader = new BufferedReader(inReader);

		//The only reason I do this thing where I make a big long string and then break it up
		//Is because I wasn't too sure about the rules surrounding things we haven't learned (Arrays)
		String fileData = "";
		
		//If there's more data, add the line to the end of the FileData String, with a space in between.
		while(reader.ready()){
			fileData += (reader.readLine() + " ");
		}
		
		//Then, break that line up into an array using the split function.
		return breakInput(fileData);
	}
	
	//Splits the string based on spaces.
	public static String[] breakInput(String input){
		//Split the thing up on spaces,
		String[] inputSplit = (input.split("\\s"));
		return inputSplit;
	}
	
	//Loop through the different words, give the information for all of them through function calls.
	public static void loopProblemSolver(String[] userInput){
		//Repeat for all entries in the array.
		for( int i = 0; i < userInput.length; i++){
			userInput[i] = userInput[i];
			//Since the array goes "WORD SUFFIX", only every other entry is a word (even numbered entries).
			if(i % 2 == 0){
				//Display to the user all of the information. Functions are called which return the expected values.
				// i is the word, i+1 is the suffix of that word.
				System.out.println("----------------------");
				System.out.println("Org. String: " + userInput[i] + " " + userInput[i+1]);
				System.out.println("Plural Form: " + createPluralWord(userInput[i]));
				System.out.println("With Suffix: " + appendSuffix(userInput[i], userInput[i+1]));
			}
		}
	}
	
	//Function to append the suffix, making sure to apply the right rules to each situation.
	public static String appendSuffix(String word, String suffix){
		//This value is used a lot, so I store it.
		int typeWordEnd = determineWordType(word);
		
		//The DetermineSuffixType Method returns true if the first character of the suffix is a vowel, false otherwise.
		if(determineSuffixtype(suffix)){
			//If the suffix begins with a vowel
			//These if statements just carry out the specified procedure in the document.
			if(typeWordEnd == 1){
				return (word + suffix);
			} else if(typeWordEnd == 2){
				return (word + suffix.substring(1));
			} else if(typeWordEnd == 3){
				return (word + suffix.substring(0, 1) + suffix);
			} else {
				return "Error: invalid tpye";
			}
		} else {
			//If the suffix begins with a consonant
			//These if statements just carry out the specified procedure in the document.
			if(typeWordEnd == 1){
				return(word + suffix);
			} else if (typeWordEnd == 2) {
				return (word + suffix.substring(0, 1) + suffix);
			} else if (typeWordEnd == 3) {
				return (word.substring(0, (word.length() - 2)) + word.substring(word.length() - 1) + suffix);
			} else {
				return "Error: invalid tpye";
			}
		}
	}
	
	//Determines the type of the suffix (begins with vowel v. begins with consonant)
	//This was just getting repetitive..
	public static boolean determineSuffixtype(String suffix){
		/*
		 * First character
		 * True: vowel
		 * False: consonant
		 */
		String firstchar = suffix.substring(0, 1);
		if(isVowel(firstchar)){
			return true;
		} else {
			return false;
		}
	}
	
	//Creates the plural of a word
	public static String createPluralWord(String word){
		//Keep the type in a variable since it's called a lot
		int typeWordEnd = determineWordType(word);
		
		String pluralWord;
		
		//These just make the string with respect to the table given in the problem document.
		// Relatively simple use of string functions involved.
		if(typeWordEnd == 1){
			pluralWord = word + "gh";
		} else if(typeWordEnd == 2){
			pluralWord = ((word.substring(0, word.length() - 1)) + "g");
		} else if(typeWordEnd == 3){
			pluralWord = (word + (word.substring(word.length() - 1)) + "h");
		} else {
			//Just in case something strange happens. I don't know why it would, but I guess it might as well be there.
			pluralWord = "Error: Unexpected word type.";
		}
		
		//Return the value...
		return pluralWord;
	}
	
	//Determines the ending type of different words
	public static int determineWordType(String word){
		/*
		 * typeWordEnds:
		 * 0: Default, nothing set
		 * 1: Single Consonant End
		 * 2: Single Vowel End
		 * 3: Double Vowel or Double Consonant end
		 */
		
		//This function is called throughout the program, since determining the type
		//of the word's ending is critical to pretty much everything.
		
		int typeWordEnd = 0;
		String endChars = word.substring((word.length() - 2));
		
		//For the word abcde[fg],
		//endCharFrist would be f,
		//endChar would be g.
		//This is used for the case in which more than one vowel or consonant is at the end of the string.
		String endCharFirst = endChars.substring(0, 1);
		String endChar = endChars.substring(1);
		
		//For single vowel/cons ends
		if(isVowel(endChar)){
			typeWordEnd = 2;
		} else {
			typeWordEnd = 1;
		}
		
		//If there's a double vowel or a double "not vowel" (consonant).
		if((isVowel(endCharFirst) && isVowel(endChar)) || (!isVowel(endCharFirst) && !isVowel(endChar))){
			typeWordEnd = 3;
		}
		
		return(typeWordEnd);
	}
	
	//Simple comparison that I used a fair bit throughout the program. It was getting repetitive, so I made it a function
	public static boolean isVowel(String endChar){
		if(endChar.equalsIgnoreCase("a") || endChar.equalsIgnoreCase("c") || endChar.equalsIgnoreCase("s") || endChar.equalsIgnoreCase("l")){
			//If the word ends in a vowel
			return true;
		} else {
			//If the word ends in a consonant
			return false;
		}
	}
	
	//Again, writing this indexOf statement so much was getting tiresome, so I made this function. 
	public static boolean contains(String word, String letter){
		if (word.indexOf(letter) != -1){
			return true;
		} else {
			return false;
		}
	}
	
}