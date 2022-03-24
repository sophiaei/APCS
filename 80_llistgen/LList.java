// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW78 -- Double Up
// 2022-03-17
// time spent: .5 hrs

/***
 * class LList
 * Implements a linked list of DLLNode<Object>s, each containing Object data
 **/

public class LList<Object> implements List<Object> //interface def must be in this dir
{

  //instance vars
  private DLLNode<Object> _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( Object newVal )
  {
    if (_size == 0) {
      _head = new DLLNode<Object>(null, newVal, null);
    } else {
      DLLNode<Object> tmp = _head;
      tmp.setPrev( new DLLNode<Object>( null, newVal, tmp ) );
      _head = tmp.getPrev();
    }
    _size++;
    return true;
  }


  public Object get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    Object retVal;
    DLLNode<Object> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public Object set( int index, Object newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode<Object> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    Object oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }

  public void add(int index, Object newVal)
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode<Object> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    if (tmp.getPrev() != null) {
      tmp.setPrev( new DLLNode<Object>( tmp.getPrev(), newVal, tmp ) );
      tmp = tmp.getPrev();
      tmp.getPrev().setNext(tmp);
    } else {
      add(newVal);
    }
    _size ++;
  }

  public Object remove(int index)
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode<Object> tmp = _head; //create alias to head
    Object oldVal = null;
    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    if (tmp.getPrev() != null) {
      tmp.getPrev().setNext(tmp.getNext());
    }
    if (tmp.getNext() != null) {
      oldVal = tmp.getNext().getCargo();
      tmp.getNext().setPrev(tmp.getPrev());
    }

    _size --;

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toObject
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode<Object> tmp = _head; //init tr
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
    LList<String> james = new LList<String>();

    System.out.println( james );

    james.add("beat");

    james.add("a");

    james.add("need");

    james.add("I");

    james.set( 1, "got" );

    System.out.println( james );
    System.out.println( james.size() );

    james.add( 3, "blah" );

    System.out.println( james );
    System.out.println( james.size() );

    james.remove( 3 );

    System.out.println( james );
    System.out.println( james.size() );
  }

}//end class LList
