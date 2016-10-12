import java.util.Scanner;

public class Nautical{
  public static void main(String [] args){
    //Define the variables-

    //Scanner, to read what the user inputs
    Scanner reader = new Scanner(System.in);

    //kilometer value, to be input by user
    double km;
    //nautical mile value, to be determined via calculation
    double naum;

    //write the question out to the user
    System.out.print("How many KM? Enter: ");
    //set the variable that was devined earlier to what the user entered
    km = reader.nextDouble();

    //do the math, based on the values that were given in the problem.
    naum = km * 90 * 60 / 10000;

    //Return the answer to the user in a nice and clean fashion.
    System.out.println("There are " + naum + " nautical miles in " + km + " kilometers.");
  }
}
