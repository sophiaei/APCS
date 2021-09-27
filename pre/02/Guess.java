import java.util.Scanner;
import java.util.Random;

public class Guess{
  public static void main(String[] args) {
    // declare variables
    int guess;
    int number;
    Random random;
    Scanner in = new Scanner(System.in);

    // pick a random number
    random = new Random();
    number = random.nextInt(100) + 1;

    System.out.println("Im thinking of a number between 1 and 100 (including both). Can you guess what it is?");
    System.out.println("Type a number: ");
    guess = in.nextInt();
    System.out.println("Your guess is " + guess);
    System.out.println("The number I was thinking of is:" + number);
    System.out.println("You were off by: " + (guess - number) );





  }
}
