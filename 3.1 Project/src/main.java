import java.util.Scanner;

/*
 * Dan Lynch
 * Beverly Public High School
 * AP COMPTUER SCIENCE - Mr. MacDonald
 * 
 * Updated October 25th, 2016.
 */

public class main {
	public static void main(String [] args){
		//Declare the variable which the user will provide.
		double sideLength;
		//Declare the variable to store the 
		double cubeSurface;
		
		//Declare the reader
		Scanner reader = new Scanner(System.in);
		
		//Ask the user a question
		System.out.print("Enter the side length of a cube: ");
		sideLength = reader.nextDouble();
		
		/*
		Multiply the side length by itself to get the area of the side,
		then by six, the amount of sides on a cube.
		*/
		cubeSurface = sideLength * sideLength * 6;
		
		//give the output of the calculations.
		System.out.println("The total surface area of the cube is: " + cubeSurface);
	}
}
