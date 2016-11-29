/*
 * Dan Lynch
 * Beverly Public High School
 * AP Computer Science A - Mr. MacDonald
 * "Revised" Project 3.5
 * 
 * (I think that my first one was better).
 */

import java.util.Scanner;

public class main {
	
	//declare variables that hold the total values for important things. -> calculated
	public static double hours = 0;
	public static double overtime = 0;
	
	//declare a variable to hold the user's age -> user input
	public static double wage = 0;
	
	//create a scanner object to be used by the program
	public static Scanner reader = new Scanner(System.in);
	
	//main method used to call all of the other methods
	public static void main(String args[]){
		//ask for the users hourly wage
		askerWage();
		
		//ask about hours worked/how many of those hours were overtime for eah day
		askerDay("Monday");
		askerDay("Tuesday");
		askerDay("Wednesday");
		askerDay("Thursday");
		askerDay("Friday");
		
		//log the total earnings to the console for the user to see
		loggerEarnings(wage, hours, overtime);
	}

	public static void askerWage(){
		//ask the question
		System.out.println("What is your hourly wage?");
		System.out.print("Hourly wage: ");
		
		//record the answer
		wage = reader.nextDouble();
	}
	
	public static void askerDay(String day){
		//call the functions to ask about each day.
		askerHours(day);
		askerOvertime();
	}
	
	public static void askerHours(String day){
		//ask about the earnings for a particular day
		System.out.println("How many total hours did you work on " + day + "?");
		System.out.print("Total Hours: ");
		
		//add them to the total
		hours += reader.nextDouble();
	}
	
	public static void askerOvertime(){
		//ask about how many hours of a given day were overtime
		System.out.println("How many of those hours of those were overtime?");
		System.out.print("Amount of hours overtime: ");
		
		//add them to the total
		overtime += reader.nextDouble();
	}
	
	public static void loggerEarnings(double wage, double hours, double overtime){
		//display the answers to the user. Calculations were simple, so I kept them in the printlns.
		System.out.println("You earned a total of $" + (((hours - overtime) * wage) + (overtime * wage * 1.5)) + ".");
		System.out.println("That's a total of " + (hours - overtime) + " hours at $" + wage + "/hr and " + overtime + " overtime hours at $" + wage*1.5 + "/hr.");
	}
}
