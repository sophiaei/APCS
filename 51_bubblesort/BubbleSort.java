// Strawberry JAM: Sophia Eiden, Melody Lew, Josiah Moltz
// APCS pd6
// HW51 -- QUESTIONABLE QUESTIONABLE QUESTIONABLE / implementing bubblesort / applying a bubble sort to ArrayLists
// 2022-01-03
// time spent: .9 hrs (50 minutes)

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 *  0. Starting from the right, look at an element and its neighbor to the left.
 *  1. If the left neighbor is bigger than the element, swap the two.
 *  2. Proceed by looking to the next element to the left until the second element (at position 1) is reached.
 *  3. Repeat until no changes are made (for utilized version, for commented version repeat length-1 times)
 * DISCO
 *  0. It is called a Bubble Sort because it essentially spawns a bubble at the right
    that drags the smallest element to the end (sort of?)
 *  1. EPIC SWAPPING METHOD IN SHUFFLE WOAH
 *
 * QCC
 *  q0: If a pass requires no swaps, what do you know?
 *  a0: We are done!
 *  q1: After pass p, what do you know?
 *  a1: The beginning p elements are properly sorted!
 *  q2: How many passes are necessary to completely sort?
 *  a2: length of list - 1
 *  0. Is it more important to look at number of changes made, or just repeat until worst case scenario reached.
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
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
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );  //WOAH SO COOL
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    // VERSION THAT TERMINATES BASED ON NUMBER OF CHANGES MADE EACH PASS
        int changes = 1;
        int passNum = 0;
        while ( changes > 0 ) {
          changes = 0;
          for( int i = data.size() - 1; i > passNum; i-- ) {
            if ( data.get(i).compareTo( data.get(i - 1) ) < 0 ) {
              changes++;
              data.set( i, data.set( i - 1, data.get(i) ) );  // COOL SWAPPING B)
            }
          }
        }
      }
  }

/* VERSION THAT TERMINATES BASED ON NUMBER OF PASSES (always goes to worst case scenario)
  for( int passNum = 0; passNum < data.size(); passNum++ ) {
    for( int i = data.size() - 1; i > passNum; i-- ) {
      if ( data.get(i).compareTo( data.get(i - 1) ) < 0 ) {
        data.set( i, data.set( i - 1, data.get(i) ) );  // COOL SWAPPING B)
      }
    }
  }
*/


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    //create a "deep-copy" (different memory address) of input
    ArrayList<Comparable> copy = new ArrayList<Comparable>();
    for( int i = 0; i < input.size(); i++ ) {
      copy.add( input.get(i) );
    }
    //actually sorting
    bubbleSortV( copy );
    return copy;
  }


  public static void main( String [] args )
  {

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

  }//end main

}//end class BubbleSort
