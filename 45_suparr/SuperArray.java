// Strawberry JAM: Melody Lew, Sophia Eiden, Josiah Moltz
// APCS pd6
// HW45 -- Array of Titanium / Writing an interface / writing ListInt as an interface to implement in SuperArray
// 2021-12-08
// time spent: .7

/*
DISCO:
0. An interface makes a "contract":
  if used it REQUIRES the class implementing it to have the specified methods
1. Abstract methods CANNOT have a body
2. A body contsitutes of curly brackets (?)

QCC:
0. What exactly do curly brackets do?
1. Why do you abstract in a practical sense? (Seems oddly/agravatingly restrictive with little payoff)

*/

public class SuperArray implements ListInt
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    _size = _size+1;
    return temp;
  }


  //adds an item after the last item
  public boolean add( int newVal )
  {
    if( _size >= _data.length ) {
      expand();
    }
    add(_size, newVal);
    return true;  //NECESSARY since ListInt add returns boolean (not 100% sure why)
  }


  //inserts an item at index
  public boolean add( int index, int newVal )
  {
    if ( index >= _data.length || index < 0 ){
      return false;
    }
    if ( _size >= _data.length ) {
      expand();
    }
    for (int i = _size; i > index; i--){
      _data[i] = _data[i-1]; //replaces the value of this index with the value to the left
    }
    _data[index] = newVal;
    _size = _size + 1;
    return true;
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public boolean remove( int index )
  {
    if ( index >= _data.length || index < 0 ) {
      return false;
    }
    _size = _size-1; //shift elements by 1 to the left without going out of bounds
    for (int i = index; i < _size; i++){
      _data[i] = _data[i+1];
    }
    _data[_size] = 0;
    return true;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);
      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);
      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(-42);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(42);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(11,187);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(-1,55);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      System.out.println("Mayfield is yay big: " + mayfield.size());
  }//end main()


}//end class
