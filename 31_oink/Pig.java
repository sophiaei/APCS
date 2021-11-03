/*
Team ___: Sophia Eiden, Fang Chen
APCS
HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay/linear search
2021-11-03
time spent: 0.45 hrs

DISCO:
QCC:
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 */

public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";

  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ){
    for (int i = 1; i <= w.length(); i++){
      if (w.substring(i-1,i).equals(letter)){
        return true;
      }
    }
    return false;
    /* YOUR IMPLEMENTATION HERE */
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ){
    for (int i = 0; i < VOWELS.length(); i ++){
      if (VOWELS.substring(i,i+1).equals(letter)){
        return true;
      }

    }
    /* YOUR IMPLEMENTATION HERE */
    return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ){
    int counter = 0;
    for (int i = 0; i < w.length(); i++){
      for (int j = 0; j < VOWELS.length(); j ++){
        if (w.substring(i,i+1).equals(VOWELS.substring(j,j+1))){
          counter += 1;
        }
      }
    }

    return counter;
    /* YOUR IMPLEMENTATION HERE */
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ){
    for (int i = 0; i < w.length(); i++){
      for (int j = 0; j < VOWELS.length(); j ++){
        if (w.substring(i,i+1).equals(VOWELS.substring(j,j+1))){
          return true;
        }
      }
    }

    return false;
    /* YOUR IMPLEMENTATION HERE */
  }

  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ){
    String vowels = "";
    for (int i = 0; i < w.length(); i++){
      for (int j = 0; j < VOWELS.length(); j ++){
        if (w.substring(i,i+1).equals(VOWELS.substring(j,j+1))){
          vowels += VOWELS.substring(j,j+1);
        }
      }
    }

    return vowels;
    /* YOUR IMPLEMENTATION HERE */
  }


  public static void main( String[] args ){
    /* YOUR TEST CALLS HERE */
    System.out.println(hasA("cat", "a"));
    System.out.println(hasA("cat", "p"));
    System.out.println(isAVowel("e"));
    System.out.println(isAVowel("p"));
    System.out.println(countVowels("cat"));
    System.out.println(countVowels("minimum"));
    System.out.println(hasAVowel("cat"));
    System.out.println(hasAVowel("xpwtc"));
    System.out.println(allVowels("old macdonald had a farm"));
    System.out.println(allVowels("xptcs"));
    System.out.println(allVowels("eieio"));
  }//end main()

}//end class Pig
