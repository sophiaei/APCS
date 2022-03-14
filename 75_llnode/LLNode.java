// (FA)FSA:: Ameer Alnasser, Fang Min Chen, Sophia Eiden
// APCS pd6
// HW75: Nodal Recall
// 2022-03-09
// time spent: 0.5 hours

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String car="";
  private LLNode cdr;
  // constructor
  public LLNode( String value, LLNode next )
  {
    car=value;
    cdr=next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return car;
  }

  public LLNode getNext()
  {
    return cdr;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
   car=newCargo;
   return newCargo;
  }

  public LLNode setNext( LLNode newNext )
  {
    cdr=newNext;
    return newNext;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
    {
      String str = "[";
      LLNode current = this;
      while (current != null) {
        str += current.getCargo() + ", ";
        current = current.getNext();
      }
      str = str.substring(0, str.length() - 2) + "]";
      return str;
    }

  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first);
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: the node still exists, it just isn't reflected with the print
    //...so better: ?so true bestie
    //
    //
    //

  }//end main

}//end class LLNode
