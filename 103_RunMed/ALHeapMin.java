// National Security Agency: Nora Miller, Sophia Eiden, Ameer Alnasser
// APCS pd6
// HW102 -- Heap o' Trouble
// 2022-05-16m
// time spent: 1 hrs

/*
DISCO:
ArrayLists have some methods that are used in ALHeap
QCC:
N/A
*/

/**
 * class ALHeapMin
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeapMin
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeapMin()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    return _heap.toString();
  }//O(?)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.isEmpty();
  }//O(?)

  public int size(){
    return _heap.size();
  }
  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(?)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   *
   Minheap: smallest on top. adding value x
   Assuming that all children of minheap are also minheaps:
   if x> all values
   we should go find the first empty child hole and place it there
   if some values < x < some values,
   starts at the "leaves", then stops when it is smaller than all eelments under it
   if in between,
   if x < all values,
   replace root with x, take root and do the algo for some values <x < some vals
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal); // add at first open index
    if (isEmpty()){return;}

    // initialize index pointers
    int current = _heap.size() - 1;
    int p = (current -1 )/2;

    // while the added one is less than the parent, move the value up
    while (addVal < _heap.get(p)){
      swap(p, current);
      current = p;
      p = (current - 1) / 2;
    }
  }//O(?)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * Minheap: smallest on top. removing value x
   Assuming that all children of minheap are also minheaps:
   if x>all values
   set that heap to null
   if val<x<val
   take the smallest value under x and replace it with x
   if x < all values,
   x is the root, take the smallwst value under x and replace it, then adjust accordingly
   */
  public Integer removeMin()
  {
    if (isEmpty()){return null;}

    // save the minimum val
    int removed = _heap.get(0);
    // move the "last" (latest added value) to the top
    _heap.set(0, _heap.get(_heap.size()-1));
    _heap.remove(_heap.size()-1);
    //initialize index pointers
    int root = 0;
    int minChild;
    //swap the new "root" to its correct place
    while ((((2*root + 1) < _heap.size()) && _heap.get(root) > _heap.get(2*root + 1)) ||
            (((2*root + 2) < _heap.size()) &&_heap.get(root) > _heap.get(2*root + 2))) {
      minChild = minChildPos(root);
      swap(root, minChild);
      root = minChild;
    }
    return removed;
  }//O(?)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    //index pointers
    int left = 2 * pos + 1;
    int right = 2 * pos + 2;

    // out of bounds?
    if (left >=_heap.size()) {
      if (right >= _heap.size()) {
        return -1;
      }
      return right;
    }
    if (right >= _heap.size()) {
      return left;
    }

    // comparison
    if (_heap.get(left) > _heap.get(right)) {
      return right;
    }
    return left;
  }//O(?)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {

      ALHeapMin pile = new ALHeapMin();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
