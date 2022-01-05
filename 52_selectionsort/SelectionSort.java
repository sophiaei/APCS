// Balloons (Weichen Liu, Josiah Moltz, Sophia Eiden)
// APCS pd6
// HW52 -- implementing selection sort
// 2022-01-04
// time spent:  0.5 hrs

/******************************
 * class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
 * First we determine the greatest element in the array by looping through the entire unsorted section of the array.
 * Then we swap that element with the element at index pass.
 * We loop through the array of n elements n - 1 times.
 * Each time we loop through the array, the search window is cut to be from the 0th index to the pass index.
 *
 * DISCO
 * We can nest a set method inside another set method when we want to swap elements. It is more efficient.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1
 * q1: What do you know after pass p?
 * a1: The first p elements are in their final resting places (so morbid)
 * q2: How do you know if sorted?
 * a2: If we have completed n-1 passes
 * q3: What does a pass boil down to?
 * a3: Find the pth smallest number, and place it in the pth position (p-1 index)
 * Do we lose any efficiency in assigning maxPos to be 0 instead of another value (say pass)?
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; 0 < pass; pass-- ) {
      maxPos = 0; //If we don't reassign maxPos we will just end up reusing the largest value from the previous sort
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag


      for( int i = pass; 0 <= i; i-- ) {
        if ( data.get(maxPos).compareTo(data.get(i)) < 0 ) {
          maxPos = i;
        }
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag


      }

      data.set( pass, data.set( maxPos, data.get(pass) ) );
      System.out.println( "after swap: " +  data );//diag
    }
  }//end selectionSort

  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input ) {
      data.add( o );
    }

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort

  public static void main( String [] args )
  {

    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );

    glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    ArrayList glenSorted = selectionSort( glen );
    System.out.println( "sorted version of ArrayList glen:\n"
    + glenSorted );
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    ArrayList cocoSorted = selectionSort( coco );
    System.out.println( "sorted version of ArrayList coco:\n"
    + cocoSorted );
    System.out.println( "ArrayList coco after sorting:\n" + coco );

  }//end main

}//end class SelectionSort
