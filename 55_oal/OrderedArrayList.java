// Balloons (Weichen Liu, Josiah Moltz, Sophia Eiden)
// APCS pd6
// HW55 -- implementing insertion sort
// 2022-01-11
// time spent:  0.5 hrs

/*
DISCO
0. It was interesting to see addBinary was still O(n)
1. It was interesting that addLinear had no best/worst case while addBinary did.
QCC
0.
*/

import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;

  //O(1), assigning memory
  //No best/worst case
  // default constructor
  // initializes instance variables
  public OrderedArrayList() {
    _data = new ArrayList<Integer>();
  }

  //O(n), loops through the list once to print out each element.
  //No best/worst case
  public String toString()
  {
    return _data.toString();
  }

  //O(n), has to shift ~n elements after removing
  //Best case: i is last element
  //Worst case: i is first element
  public Integer remove( int i )
  {
    return _data.remove(i);
  }

  //O(1), accessing a memory value
  //No best/worst case
  public int size()
  {
    return _data.size();
  }

  //O(1), accessing a memory value
  //No best/worst case
  public Integer get( int i )
  {
    return _data.get(i);
  }

  //O(n), loops through list to find proper place, then preforms O(n) action add.
  //No best/worst case, we always have to find its index, and then shift each element after it over by one
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  public void addLinear(Integer newVal)
  {
    int index = 0;
    while (index < size() && newVal > get(index)) {
      index += 1;
    }
    _data.add(index, newVal);
  }

  //O(n), uses binary sort for O(log(n)) but then uses add which is O(n)
  //Best case: newVal is larger than all the others. We want add to be O(1), which only happens when newVal is added at the end of the list.
  //Worst case: newVal is smaller than all the others.
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  public void addBinary(Integer newVal)
  {
    int start = 0;
    int middle = 0;
    int finish = size();

    int oldMiddle = -1;

    if (finish == 0) {
      _data.add(0,newVal);
    }
    else {
      while (oldMiddle != middle){
        oldMiddle = middle;

        middle = (start + finish) / 2;

        if (newVal < get(middle)){
          finish = middle;
        }
        else {
          start = middle;
        }// end else
      }// end while
      _data.add(finish, newVal);
    }// end else
  }// end method

  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear searchadd(middle, newVal);
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );
    // testing binary search
    Franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ )
      Franz.addBinary( (int)( 50 * Math.random() ) );
    System.out.println( Franz );
  }//end main()

}//end class OrderedArrayList
