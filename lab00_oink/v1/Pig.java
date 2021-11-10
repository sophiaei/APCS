/***
 * Team: Pig Feeders
 * APCS
 * L00: Etterbay Odingcay Oughthray Ollaborationcay
 * 2021-11-09

 NEW IN v1: Added the necessary methods

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
 ***/

public class Pig {

  private static final String VOWELS = "aeiou";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!?";

  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA(String w, String letter){
    /* YOUR IMPLEMENTATION HERE */
    return w.indexOf(letter) != -1;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel(String letter){
    /* YOUR IMPLEMENTATION HERE */
    return VOWELS.indexOf(letter) != -1;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels(String w){
    /* YOUR IMPLEMENTATION HERE */
    return allVowels(w).length();
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel(String w){
    /* YOUR IMPLEMENTATION HERE */
    return countVowels(w) > 0;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels(String w){
    /* YOUR IMPLEMENTATION HERE */
    String str = "";
    for (int x = 0; w.length() > x; x += 1){
      if (isAVowel(w.substring(x, x + 1))){
        str += w.substring(x, x + 1);
      }
    }
    return str;
  }

  /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
  public static boolean isPunc(String symbol){
    return PUNCS.indexOf(symbol) != -1;
  }

  /*=====================================
    boolean isUpperCase(String) -- tells whether a letter is uppercase
    pre:  letter.length() == 1
    post: isUpperCase("a") -> false
          isUpperCase("A") -> true
    =====================================*/
  public static boolean isUpperCase(String letter){
    return CAPS.indexOf(letter) != -1;
  }

  /*=====================================
    boolean hasPunc(String) -- tells whether a String contains punctuation
    pre:  w != null
    post: hasPunc("cat.") -> true
          hasPunc("cat") -> false
    =====================================*/
  public static boolean hasPunc( String w ) {
    int count = 0;
    for (int x = 0; x < w.length(); x += 1){
      String sub = w.substring(x, x + 1);
      if (isPunc(sub)){
        count += 1;
      }
    }
    return count != 0;
  }

  /*=====================================
    boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
    pre:  w != null and w.length() > 0
    post: beginsWithUpper("Apple") -> true
          beginsWithUpper("apple") -> false
    =====================================*/
  public static boolean beginsWithUpper(String w){
    return isUpperCase(w.substring(0, 1) );
  }

  /**
    String firstVowel(String) -- returns first vowel in a String
    pre:  w != null
    post: firstVowel("") --> ""
    firstVowel("zzz") --> ""
    firstVowel("meatball") --> "e"
    **/
  public static String firstVowel(String w){
    String ans = "";
    if (hasAVowel(w)){
      ans = allVowels(w).substring(0, 1);
    }
    return ans;
  }

  /**
    boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
    pre:  w != null and w.length() > 0
    post: beginsWithVowel("apple")  --> true
    beginsWithVowel("strong") --> false
    **/
  public static boolean beginsWithVowel(String w){
    return isAVowel(w.substring(0, 1));
  }

  /**
    String engToPig(String) -- converts an English word to Pig Latin
    pre:  w.length() > 0
    post: engToPig("apple")  --> "appleway"
    engToPig("strong") --> "ongstray"
    engToPig("java")   --> "avajay"
    **/
  public static String engToPig(String w){
    String ans = "";
    if ( beginsWithVowel(w) )
      ans = w + "way";
    else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }
    return ans;
  }

  public static void main(String[] args){
    for (String word : args){
      System.out.println("allVowels \t" + allVowels(word));
      System.out.println( "firstVowels \t" + firstVowel(word) );
      System.out.println( "countVowels \t" + countVowels(word) );
      System.out.println( "engToPig \t" + engToPig(word) );
      System.out.println( "---------------------" );
    }
  }//end main()

}//end class Pig
