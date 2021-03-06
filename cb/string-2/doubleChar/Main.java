// https://codingbat.com/prob/p165312

public class Main {
    public static void main(String[] args) {
        System.out.println(doubleChar("The")); // "TThhee"
        System.out.println(doubleChar("AAbb")); // "AAAAbbbb"
        System.out.println(doubleChar("Hi-There")); // "HHii--TThheerree"
    }

    /**
     * Given a string, return a string where for every char in the original,
     * there are two chars.
     */
    public static String doubleChar(String str) {
      String result = "";
      for (int i = 1; i <= str.length(); i++){
        result += str.substring(i-1, i) + str.substring(i-1, i) ;
      }
      return result;

    }
}
