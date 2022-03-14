// (FA)FSA:: Ameer Alnasser, Fang Min Chen, Sophia Eiden
// APCS pd6
// HW73: All About the About Face
// 2022-03-09
// time spent: 0.5 hours

/*
0. Augment block (javadocs) comment for partition method to document how it picks a pivot.

1. express the quicksort algorithm as cleanly as possible,

  If the array is longer than one element

    Select a random pivot pivotIndex
    Partition the array based on that index, note the final position.

    Partition all the elements higher than the pivotIndex recursively
    Partition all the elements smaller than the pivotIndex recursively

2. describe the best and worst pivot choices and categorize their time complexities,

    There isn't really a best/worst pivot choice, given that the pivotIndex says nothing
    about the content of the index. Best and worst, then depends on the content of the array.

    Runtime based on Pivot Number (looped 10000 times on randomly populated int[1000])
    0: 0.898 s
    99: 0.885 s
    199: 0.914 s
    299: 0.913 s
    399: 0.930 s
    499: 0.898 s
    599: 0.916 s
    699: 0.915 s
    799: 0.900 s
    899: 0.899 s
    999: 0.904 s
    
    Data doesn't show a clear relationship between pivot choice and runtime, though further
    tests can be made with larger arrays to clarify.
    Time complexity of the sort is nlogn, since it utilizes the partition (O(n)) in a
    logarithmic manner, cutting the length of focus in half every time, similar to binary search.

3. explain how you handle duplicate values in the array.
  We treated any duplicate value to act as if it is smaller than the element in
  the pivot position, thus increasing the new pivotIndex by however many duplicates
  there are.

*/

public class QuickSort
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
  }
  //--------------^  HELPER METHODS  ^--------------

  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    sorter(d, 0, d.length-1);
  }


  //you may need a helper method...

  public static void sorter(int[] list, int left, int right)
  {


    if (left < right){
      int pivotIndex = left + (int)(Math.random()*(Math.abs(left-right)));
      pivotIndex = partition(list, left, right, pivotIndex);

      sorter(list, left, pivotIndex - 1);
      sorter(list, pivotIndex + 1, right);
    }
  }




  //main method for testing
  public static void main( String[] args )
  {


    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
