import java.io.*;
/*
 * DAN LYNCH
 * VHS AP COMPUTER SCIENCE
 * MR. MACDONALD
 * 
 * 15 NOVEMBER 2016
 * BEVERLY HIGH SCHOOL
 */

/*
 * EXPECTED FORMAT: FIRSTNAME__LASTNAME_PAYRATE_[NORMALHRS_OVERTIMEHRS].
 * Note the two spaces between the first and last name.
 * This is the format used in the file "VHSP35data1.txt".
 * The program will NOT function properly with only once space between the
 * first and last names.
 *
 * String input = "Kermit  D.Frogge 17.25 5.25 0.0 8.0 1.5 8.0 2.25 7.75 0.0 8.0 2.0";
*/

public class main {
	
	//Define variables that are used by the file reader to get information from the
	//File given as an input.
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static BufferedReader reader;
	
	//Main Method, where everything goes down.
	public static void main(String [] args) throws IOException{
		//Define the values used to calculate things in the program.
		double hoursRegular = 0, hoursOvertime = 0, payRate = 0, totalPay;
		
		//Set the directory location to locate the employee data file at.
		String input = args[0];
		
		//Call the file reader initialization function, so that everything is ready to use.
		initFile(input);
		
		//Take the value from the reader and store it in a variable for use later.
		String res =  reader.readLine();
		
		//Use the Split function to split the string into components. I used this function as opposed to the StringTokenizer function since it is explicitly stated in the official Java documentation that the StringTokenizer should *not* be used.
		String[] result = res.split("\\s");
		
		//Extract the pay rate from the array.
		payRate = Double.parseDouble(result[3]);
		
		//Loop through the values in the array of data extracted from the file. Skipping over the Name and Pay Rate, of course.
		for (double i = 4; i < result.length; i++){
			//Add the values to the total, alternating between regular and overtime pay.
			if(i % 2 == 0){ hoursRegular += Double.parseDouble(result[(int) i]); }
			else{ hoursOvertime += Double.parseDouble(result[(int) i]); }
		}
		
		//Calculate the total pay based on the given values.
		totalPay = ((hoursRegular * payRate) + (hoursOvertime * 1.5 * payRate));
		
		//Give the information to the user in a nice and pretty way.
		System.out.println( result[0] + " " + result[1] + " earned a total of $" + totalPay + ". That's " + hoursRegular + " regular time hours at " + payRate + ", and " + hoursOvertime + " overtime hours at " + payRate * 1.5);
	}
	
	//Define the function used by the program to fetch data from the file.
	public static void initFile(String input) throws IOException{
		inFile = new FileInputStream (input);
		inReader = new InputStreamReader(inFile);
		reader = new BufferedReader(inReader);
	}
}
