import java.util.Scanner;

//declare variables + scanner for input
public class Convert {
  public static void main(String[] args) {
    int inch;
    double cm;
    final double CM_PER_INCH = 2.54;
    Scanner in = new Scanner(System.in);

    //input inches value
    System.out.print("How many inches?");
    inch = in.nextInt();

    // multiply by 2.54 to find cm equivalent, print rest out
    cm = inch * CM_PER_INCH;
    System.out.print(inch + " in = ");
    System.out.println (cm + " cm");

  }
}
