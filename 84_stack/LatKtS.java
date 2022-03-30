// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW 83 -- Latkes
// 2022-03-28m
// time spent: 0.5 hrs
/*
DISCO
- can reverse strings pretty easily
- 2nd method was more difficult ( i think mostly in java inner workings)
- don't think we have the nicest solution for allMatched, but alas

QCC
- how would the efficiency improve compared to a different implementation (like loops)?

*/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes str = new Latkes(s.length());
    for (int i = 0; i < s.length(); i ++) {
      str.push(s.substring(i, i + 1));
    }
    String flipped = "";
    for (int i = 0; i < s.length(); i ++) {
      flipped += str.pop();
    }
    return flipped;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    Latkes tails = new Latkes(s.length()); //
    Latkes heads = new Latkes(s.length()); //
    String tempt = ""; // )
    String temph = ""; // (
    Boolean match = false;
    for (int i = 0; i < s.length(); i ++) {
      tails.push(s.substring(s.length() - i - 1, s.length() - i));
    }

    while (!(tails.isEmpty())) {

      tempt = tails.pop();
      if (tempt.equals("[") || tempt.equals("(") || tempt.equals("{")) {
        heads.push(tempt);
        temph = tempt;
      } else {
        if (temph.equals("")) {return false;}
        if (tempt.equals("]")) {match = temph.equals("[");}
        if (tempt.equals(")")) {match = temph.equals("(");}
        if (tempt.equals("}")) {match = temph.equals("{");}
        if (match) {
          heads.pop();
          if (!(heads.isEmpty())) {
              temph = heads.pop();
              heads.push(temph);
          }
        } else {return false;}
      }
    }
    if (heads.isEmpty()) {return true;}
    return false;
  }


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
  }

}//end class
