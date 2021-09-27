import java.util.Scanner;

public class CtoF{
  public static void main(String[] args){
    double cel;
    double fahr;
    Scanner in = new Scanner(System.in);


    System.out.println("Input a temperature in Celsius.");
    cel = in.nextDouble();
    fahr = (cel * 9.0/5.0) + 32.0;

    System.out.println( cel + " C = " + fahr + " F");
  }
}
