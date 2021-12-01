//Team Strawberry_JAM: Josiah Moltz, Melody Lew, Sophia Eiden
//APCS
// HW40 - Demand A Raise - 2D array basics
//2021-11-30
//time spent: 0.5 hours

/*
DISCO:

QCC:
0. what is pass-by-value and pass-by-reference in simple, easily understood english?

*/


/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/


public class TwoDimArray
{
  // FROM Loopier.java (34_array)
  // auxiliary function for simplicity
  public static String toString(int[] a) {
    String result = "[";
    result += a[0];
    for (int i = 1; i < a.length; i += 1) {
      result += ", " + a[i];
    }
    result += "]";
    return result;
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    for(int i=0; i < a.length; i++ ){
      System.out.println(toString(a[i]));
    }
    System.out.println();
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    for (int[] b : a){
      System.out.println(toString(b));
    }
    System.out.println();
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int sum = 0;
    for (int[] b : a){
      for (int i : b){
        sum += i;
      }
    }
    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int sum = 0;
    for (int i =0; i < m.length; i++ ){
      //sum += sumRow(i,m);
      sum += sumRow2(i, m);
    }
    return sum;
  }



  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int sum = 0;
    for (int i = 0; i < a[r].length; i++ ){
      sum += a[r][i];
    }
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    int sum = 0;
    for (int i : m[r]){
      sum += i;
    }

    return sum;
  }


  public static void main( String [] args )
  {

      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };

      print1(m1);
      print1(m2);
      print1(m3);

      print2(m1);
      print2(m2);
      print2(m3);

      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));

      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }

}//end class TwoDimArray
