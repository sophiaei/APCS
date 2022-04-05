//Clyde Sinclair
//APCS pd0
//HW75 -- Node for a linked list
//2022-03-11f
//time spent: _h

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/
public class LLNode<T>
   {
     //instance vars
     private T _cargo;    //cargo may only be of type T
     private LLNode<T> _nextNode; //pointer to next LLNode<T>

     // constructor -- initializes instance vars
     public LLNode( T value, LLNode<T> next ) {
       _cargo = value;
       _nextNode = next;
     }


     //--------------v  ACCESSORS  v--------------
     public T getCargo() { return _cargo; }

     public LLNode<T> getNext() { return _nextNode; }
     //--------------^  ACCESSORS  ^--------------


     //--------------v  MUTATORS  v--------------
     public T setCargo( T newCargo ) {
       T foo = getCargo();
       _cargo = newCargo;
       return foo;
     }

     public LLNode<T> setNext( LLNode<T> newNext ) {
       LLNode<T> foo = getNext();
       _nextNode = newNext;
       return foo;
     }
     //--------------^  MUTATORS  ^--------------


     // override inherited toString
     public String toString() { return _cargo.toString(); }

   }//end class LLNode
