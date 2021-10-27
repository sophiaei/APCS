/*
Team ___: Sophia Eiden, Fang Min Chen
APCS
HW25 - Do I repeat myself? - while loops/recursion
10/26/21
time spent: 9:18-9:46 or, 0.47 hours.

DISCO
- recursion in java can be broken down into an if statement
  - the if{} is the recursive case and the else{} is the base case, or at least, that syntax makes the most sense to me.

QCC
- are there any other ways to write a recursion in java without an if statement?
*/

public class Repeater{

  public static String fenceW(int numPosts){
    int counter = 1;
    String fenceString = "|";

    while (counter < numPosts){
      fenceString += "--|";
      counter ++;
    }

    return fenceString;
  }

  public static String fenceR(int numPosts){

    if (numPosts > 1){
      return (fenceR(numPosts-1) + "--|");
    }
    else {
      return "|";
    }
  }

  public static void main(String[] args) {
    System.out.println(fenceW(1));
    System.out.println(fenceW(2));
    System.out.println(fenceW(3));

    System.out.println(fenceR(1));
    System.out.println(fenceR(2));
    System.out.println(fenceR(3));

  }
}
