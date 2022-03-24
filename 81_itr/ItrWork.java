/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO

    QCC

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
      if (((int)itr.next())%2 == 1){
        returner.add((int)itr.next());
      }
    }
    return returner;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    L = oddsB(L);
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
