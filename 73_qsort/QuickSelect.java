// (FA)FSA:: Ameer Alnasser, Fang Min Chen, Sophia Eiden
// APCS pd6
// HW72 ::So So Fast
// 2022-03-08t
// time spent: too long hrs
/*
ALGO:
Inspired by the piazza traffic, Team Pink Lemonade seemed to be on the right pace, and we understood where they were coming from.
BEST CASE SCENARIO: (logn)
WORST CASE SCENARIO: (n^2)
DISCO
QCC:
We are stuck on a runtime error and we could not find the source, despite trying literally everything for an hour and a helf. Why?
What is suppsoed to be the otuput of partition!?!?!?!?!?!??!/
//Time Complexity: N/A, stuck on a runtime error. Trying for O(log n), despite best efforts
*/
public class QuickSelect
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }


  //--------------^  HELPER METHODS  ^--------------


  public static int partition( int[] arr, int a, int b, int c)
  {
    int v = arr[c];
    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,b,arr);

    return s;
  }//end partition

  public static int select(int[] list, int left, int right, int k){

      int pivotIndex = (int)(Math.random()*(Math.abs(left-right)));

      pivotIndex = partition(list, left, right, pivotIndex);

      if (k-1 == pivotIndex){
        return list[pivotIndex];
      }
      else if (pivotIndex < k - 1){
          return select(list, pivotIndex + 1, right, k);
        }
      else{
          return select(list, left, pivotIndex - 1, k);
        }
      }

  //main method for testing
  public static void main( String[] args )
  {

    //init test arrays of magic numbers
    int[] arr1 = {343,69,21,17,8};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};

    // run partition on each array,
    // holding a & b fixed, varying c...
    for( int y = 1; y < 6; y++ ) {
      System.out.println("arr1: ");
      printArr(arr1);

      System.out.println("after partition w/ a=0,b=4,c="
                         + y +"...");
      System.out.println(select(arr1,0,4,y));//-> n (40,1,2)
      System.out.println("-----------------------");

      System.out.println("arr3: ");
      printArr(arr3);

      System.out.println("after partition w/ a=0,b=4,c="
                         + y +"...");
      System.out.println(select(arr3,0,4,y));//-> n (40,1,2)
      System.out.println("-----------------------");
      //
      // System.out.println("arr4:");
      // printArr(arr4);
      // partition(arr4,0,4,y);
      // System.out.println("after partition w/ a=0,b=4,c="
      //                    + y +"...");
      // printArr(arr4);
      // System.out.println("-----------------------");
      //
      // System.out.println("arr5:");
      // printArr(arr5);
      // partition(arr5,0,4,y);
      // System.out.println("after partition w/ a=0,b=4,c="
      //                    + y +"...");
      // printArr(arr5);
      // System.out.println("-----------------------");
      // /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      //   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }
  }//end main

}//end class partition
