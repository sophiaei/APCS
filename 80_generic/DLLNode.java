// (FA)FSA: Fang, Sophia, Ammer
// APCS pd06
// HW78 -- Double Up
// 2022-03-16m
// time spent: .5 hrs


public class DLLNode<Object>
{
  //instance vars
  private Object _cargo;
  private DLLNode _nextNode;
  private DLLNode _prevNode;

  // constructor
  public DLLNode( DLLNode prev, Object value, DLLNode next )
  {
    _prevNode = prev;
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public Object getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _nextNode;
  }

  public DLLNode getPrev()
  {
    return _prevNode;
  }

  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUObjectAObjectORS  v--------------
  public Object setCargo( Object newCargo )
  {
    Object foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev( DLLNode newPrev )
  {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUObjectAObjectORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return (String) _cargo;
  }


  //main method for testing
  public static void main( String[] args )
  {

  }//end main

}//end class DLLNode
