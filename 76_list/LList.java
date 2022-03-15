// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW76 -- We Got a Little Ol' Convoy
// 2022-03-15
// time spent: 1 hr
// KtS consumed: 2

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
  public LList(  )
  {
    _head = new LLNode(null, null);
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    if (_size == 0) {
      _head.setCargo(newVal);
    } else {
      LLNode alias = _head;
      for (int i = 0; i < _size - 1; i ++) {
        alias = alias.getNext();
      }
      alias.setNext(new LLNode(newVal, null));
    }

    _size ++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode alias = _head;
    for (int i = 0; i < index; i++) {
      alias = alias.getNext();
    }

    return alias.getCargo();
  }


  public String set( int index, String newVal )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode alias = _head;
    for (int i = 0; i < index; i ++) {
      alias = alias.getNext();
    }

    String oldVal = alias.getCargo();
    alias.setCargo(newVal);
    return oldVal;
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    LLNode alias = _head;
    String str = "[";

    if (_size == 0) {
      return str + "]";
    }

    while (alias.getNext() != null) {
        str += alias + ", ";
        alias = alias.getNext();
    }
    return str + alias + "]";

  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
