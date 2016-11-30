import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Disappointment.

public class main {

	//Define variables that are used by the file reader to get information from the
	//File given as an input.
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static BufferedReader reader;
	
	//From the file: The result and the person's name.
	public static String name, res;
	
	//Define the values used to calculate things in the program.
	public static double payRate,
						 hoursRegular = 0,
						 hoursOvertime = 0,
						 totalPay;
	
	//Main Method, where everything goes down.
	public static void main(String [] args) throws IOException{
		res = "Kermit D.Frogge  17.25 5.25 0.0 8.0 1.5 8.0 2.25 7.75 0.0 8.0 2.0";
	
		readFile();
		breakString();
		calculatePay();
		displayFinal();
		
	}
	
	//Use the stringtokenizer..
	public static void breakString(){
		StringTokenizer st = new StringTokenizer(res);
	    
		//for the person's name.
		name = st.nextToken();
	    name += " " + st.nextToken();
	    
	    //their pay rate
	    payRate = Double.parseDouble(st.nextToken());
	    
	    //each day has two entries, so it's okay to put these together.
	    while(st.hasMoreTokens()){
	    	hoursRegular += Double.parseDouble(st.nextToken());
	    	hoursOvertime += Double.parseDouble(st.nextToken());
	    }
	}
	
	public static void calculatePay(){
		//Calculate the total pay based on the given values.
		totalPay = ((hoursRegular * payRate) + (hoursOvertime * 1.5 * payRate));
	}
	
	public static void displayFinal(){
		//Give the information to the user in a nice and pretty way.
		System.out.println( name + " earned a total of $" + totalPay + ". That's " + hoursRegular + " regular time hours at " + payRate + ", and " + hoursOvertime + " overtime hours at " + payRate * 1.5);
	}
	
	public static void readFile() throws IOException{
		//Set the directory location to locate the employee data file at.
		String input = "VHSP35data1.txt";
		
		//Call the file reader initialization function, so that everything is ready to use.
		initFile(input);
		
		//Take the value from the reader and store it in a variable for use later.
		res =  reader.readLine();

	}
	
	//Define the function used by the program to fetch data from the file.
	public static void initFile(String input) throws IOException{
		inFile = new FileInputStream (input);
		inReader = new InputStreamReader(inFile);
		reader = new BufferedReader(inReader);
	}
}
