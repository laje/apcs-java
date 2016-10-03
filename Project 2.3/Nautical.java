import java.util.Scanner;

public class Nautical{
  public static void main(String [] args){
    Scanner reader = new Scanner(System.in);
    double km;
    double naum;

    System.out.print("How many KM? Enter: ");
    km = reader.nextDouble();

    naum = km * 90 * 60 / 10000;

    System.out.println("There are " + naum + " nautical miles in " + km + " kilometers.");
  }
}
