/*
Strawberry Jam: Melody Lew + Ollie, Sophia Eiden + Giraffe, Josiah Moltz + Hedwig
APCS pd6
HW34 -- A Pirate's Life for Me / Array work / Frequency, linSearch, as iterative and recursive
2021-11-12
time spent: 1.5 hours (90 minutes)
*/

/*
DISCO:
0. To print an array (in string version) we can use Array.toString
1. To get the length of an array we can use .length (no parentheses)
2. Arrays package provides a default toString for arrays.
QCC:
0. Why does .length work for arrays when it is a string method
1. Why doesn't .length require parentheses?
2. What class is .length from??? It doesn't seem to be in Array or (italicized) Array, or Arrays
3. Whats up with Array and (italicized) Array in the AP subset?
*/

public class Loopier{
  public static void rInt(int[] a){
    for (int i = 0; i < a.length; i++){
      a[i] = (int)(Math.random()*100);

    }
  }

  public static String toString(int[] a) {
    String result = "[";
    result += a[0];
    for (int i = 1; i < a.length; i += 1) {
      result += ", " + a[i];
    }
    result += "]";
    return result;
  }

  public static int linSearch( int[] a, int target) {
    for (int i = 0; i < a.length; i += 1) {
      if (a[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static int linSearchR( int[] a, int target) {
    //THIS TOOK US FOREEEEEVER
    if (a.length == 0) {
      return -1;
    }

    if (a[0] == target) {
      return 0;
    }

    int[] aNext = new int[a.length - 1];

    for (int i = 1; i < a.length; i += 1) {
      aNext[i - 1] = a[i];
    }

    int next = linSearchR(aNext,target);  //prevents machine abuse from occuring

    if (next == -1) {
      return -1;
    }

    return 1 + next;
  }

  public static int freq(int[] a, int target) {
    int result = 0;
    for (int i = 0; i < a.length; i += 1) {
      if (a[i] == target) {
        result += 1;
      }
    }
    return result;
  }

  public static int freqR(int[] a, int target) {
    if (a.length == 0) {
      return 0;
    }

    int[] aNext = new int[a.length - 1];

    for (int i = 1; i < a.length; i += 1) {
      aNext[i - 1] = a[i];
    }

    if (a[0] == target) {
      return 1 + freqR( aNext, target );
    }
    else {
      return freqR( aNext, target );
    }

  }

  public static void main(String[] args) {
    int[] array = new int[100];
    rInt(array);
    System.out.println(toString(array));
    System.out.println(linSearch(array, 10));
    System.out.println(linSearchR(array, 10));
    System.out.println(freq(array, 10));
    System.out.println(freqR(array, 10));
  }
}
