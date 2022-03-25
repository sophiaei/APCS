// (FA)FSA: Fang, Sophia, Ammer
// APCS pd06
// HW81 -- Thank you, Next
// 2022-03-24r
// time spent: .5 hrs



/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    Every time itr.next() is run, the pointer immediately jumps to the next element, with no means of going back.
    This is akin to the Singly Linked nodes we worked
    QCC
    Why do we need an interim variable?
    Is there a way to have a pointer "backwards" like the doubly linked node
    SUMMARY THE FIRST:

    SUMMARY THE SECOND:

**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for (int i : L){
      if (i == key){
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator itr = L.iterator();
    while ( itr.hasNext()){
      if (itr.next() == key){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    //ArrayList??? maybe look at this
    List<Integer> returner = new ArrayList<Integer>();
    for (int i : L){
      if (i%2 == 1){
        returner.add(i);
      }
    }
    return returner;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    List<Integer> returner = new ArrayList<Integer>();
    Iterator itr = L.iterator();
    while ( itr.hasNext()){
      int x=(int)itr.next();
     if (x%2 != 0){
         returner.add(x);
      }
    }
    return returner;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator itr = L.iterator();
    while ( itr.hasNext()){
      int x=(int)itr.next();
     if (x%2 == 0){
         itr.remove();
      }
    }
    }


  public static void main( String [] args )
  {


    //var type: List   obj type: ?
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ ){
      L.add(i);
    }

    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    String output="[";
    for(int i:L){
      output+=i + ", ";
    }
    output+="]";
    System.out.println(output);
    // b) explicitly using an iterator
    output="[";
    Iterator it= L.iterator();
    while(it.hasNext()){
      output+= it.next()+ ", ";
    }
    output+="]";
    System.out.println(output);

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);

  }//end main

}//end class ItrWork
