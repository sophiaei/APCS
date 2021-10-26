/*
Team SN(Snooty Snickers): Nada Hameed, Sophia Eiden
APCS
HW24: Get It While You Can - while loops
2021-10-25
time spent: 40 mins

DISCO:

QCC:
- refreshed while loop notation, lots more practice w/ booleans. did tons of experiments!
- we used OR statements instead of ANDs, since we couldn't figure out the syntax for all of the bullets to be true with AND statements

POST-v0 MODS:
- refactored reset to more closely align w/ given solution in the interest of mutual intelligibility with other groups
- nixed a pesky print statement.
*/

/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {

  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin

    //test default constructor
      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin("quarter");

      //test 2nd overloaded constructor
      Coin wayne = new Coin("dollar", "heads" );

      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);

      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();

      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);

      //test equals() method
      if (yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }

      int matchCtr = 0;
      int x = 10;
      int y = 15;
      while (((yours.headsCtr + wayne.headsCtr) < x) || (matchCtr < y) || (matchCtr < 65536) || ((matchCtr % 2005) == 0)){
        yours.flip();
        wayne.flip();
        if (yours.equals(wayne) ) {
          matchCtr ++;
        }
        else{continue;}
      }
      System.out.println("matches - " + matchCtr + "\nheads in total (both objects) - "+ (yours.headsCtr + wayne.headsCtr) + "\ntails in total - " + (yours.tailsCtr + wayne.tailsCtr));

      /*===================TOP==========================
      ====================BOTTOM======================*/

  }//end main()
}//end class
