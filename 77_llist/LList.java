// (FA)FSA: Fang, Sophia, Ammer
// APCS pd06
// HW77 -- Insert|Remove
// 2022-03-14m
// time spent: .5 hrs

/*
DISCO
- If you modify an alias, the original Object is modified as well.
QCC
- Regarding the DISCO, since java is pass-by-value, why does setting the LLNode
tmp to _head give it the reference of _head instead of a copy of the contents?
ALGO ADD
- Traverse to the node with given index.
- Set next to a new node with the cargo as that of the current node and next as
that of the current node
- Set the cargo to the new value.
ALGO REMOVE
- Traverse to the node with given index.
- Set the cargo as that of the next node.
- Set next to that of the next node.
*/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }

  public void add(int index, String newVal)
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    tmp.setNext( new LLNode( tmp.getCargo(), tmp.getNext() ) );
    tmp.setCargo( newVal );
  }

  public String remove(int index)
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    String oldVal = tmp.getCargo();
    tmp.setCargo( tmp.getNext().getCargo() );
    tmp.setNext( tmp.getNext().getNext() );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );

    james.add("beat");

    james.add("a");

    james.add("need");

    james.add("I");

    james.set( 1, "got" );

    System.out.println( james );

    james.add( 3, "blah" );

    System.out.println( james );

    james.remove( 3 );

    System.out.println( james );
  }

}//end class LList
