/*
Team Strawberry_JAM: Sophia Eiden, Melody Lew, Josiah Moltz
APCS
HW43: Array of Steel // encapsulation // wrapping a class
2021 - 12 - 06
time spent: 0.8 hrs

DISCO:
 - figured out what left-justify is exactly
QCC:

*/


/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray(){
    _size = 10;
    _data = new int[_size];
  }

  //output SuperArray in [a,b,c] format
  public String toString(){
    String result = "[";
    result += _data[0];
    for (int i = 1; i < _data.length; i += 1) {
      result += ", " + _data[i];
    }
    result += "]";
    return result;
  }

  //accessor -- return value at specified index
  public int get( int index ){

    return _data[index];
  }

  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal ){
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }

  // mutator - swap null entries with the next right hand entry
  //** auxiliary method for left-justify **
  public void swap(int index){
    if (this.get(index) == 0){
      for (int i = index; i < _size; i++){
        if (this.get(i) != 0){
          this.set(index, this.get(i));
          this.set(i,0);
          break;
        }
      }
    }
  }

  //double capacity of SuperArray
  private void expand(){
      _size = _size * 2;
    int[] _a = new int[_size];
    for (int i = 0; i < _data.length; i++){
      _a[i] = _data[i];
    }
    _data = _a;
  }

  //main method for testing
  public static void main( String[] args ){
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
        curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);


      for( int i = 0; i < 3; i++ ) {
        curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);

      }
      curtis.set(42, 5);
      curtis.expand();
      System.out.println(curtis.get(42));
      System.out.println(curtis);
      curtis.swap(10);
      System.out.println(curtis);
  }//end main()
}//end class
