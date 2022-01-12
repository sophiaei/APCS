// Balloons (Weichen Liu, Josiah Moltz, Sophia Eiden)
// APCS pd6
// Lab04 -- SORTS
// 2022-01-06
// time spent:  0.8 hrs

import java.util.ArrayList;

public class Sorts {
  //Bubble Sort
  public static void bubble( ArrayList<Comparable> data )
  {
    int compNum = 0;  //counts the number of comparisons
    int switchNum = 0;  //counts the number of switches
    for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
      //System.out.println( "commencing pass #" + passCtr + "..." );

      //iterate thru first to next-to-last element, comparing to next
      for( int i = 0; i < data.size()-1; i++ ) {

        //if element at i > element at i+1, swap
        if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
          data.set( i, data.set(i+1,data.get(i)) );
          switchNum += 1; //switch just made
        }
        compNum += 1; //At this point in the code, a new comparison will always have just been made

        //System.out.println(data); //diag: show current state of list
      }
    }

    System.out.println("Passes: " + (data.size()-1));
    System.out.println("Comparisons: " + compNum);
    System.out.println("Switches: " + switchNum);
  }

  //Selection Sort
  public static void selection( ArrayList<Comparable> data )
  {
    int compNum = 0;  //counts the number of comparisons
    int switchNum = 0;  //counts the number of switches
    //note: this version places greatest value at rightmost end,

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; pass > 0; pass-- ) {
      //System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
      maxPos = 0;
      for( int i = 1; i <= pass; i++ ) {
        //System.out.println( "maxPos: " + maxPos );//diag
        //System.out.println( data );//diag
        if ( data.get(i).compareTo( data.get(maxPos) ) > 0 ) {
          maxPos = i;
        }
        compNum += 1; //comparison just made
      }
      data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
      switchNum += 1; //switch just made
      //System.out.println( "after swap: " +  data );//diag
    }

    System.out.println("Passes: " + (data.size()-1));
    System.out.println("Comparisons: " + compNum);
    System.out.println("Switches: " + switchNum);
  }//end selection

  //Insertion Sort
  public static void insertion( ArrayList<Comparable> data )
  {
    int compNum = 0;  //counts the number of comparisons
    int switchNum = 0;  //counts the number of switches

    for( int partition = 1; partition < data.size(); partition++ ) {
      //partition marks first item in unsorted region

      //diag:
      //System.out.println( "\npartition: " + partition + "\tdataset:");
      //System.out.println( data );

      //traverse sorted region from right to left
      for( int i = partition; i > 0; i-- ) {

        compNum += 1; //comparison IMMINENT, don't want to place it after because of the break

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
          //diag:
          //System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
          data.set( i, data.set( i-1, data.get(i) ) );
          switchNum += 1;
        }
        else
          break;
      }
    }

    System.out.println("Passes: " + (data.size()-1));
    System.out.println("Comparisons: " + compNum);
    System.out.println("Switches: " + switchNum);
  }//end insertion


}
