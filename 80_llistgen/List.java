/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 *
 * new in version 2.0:
 * REMOVE-AObject-INDEX
 * ADD-AObject-INDEX
 **/

public interface List<Object>
{
  //add node to list, containing input Object as its data
  public boolean add( Object x );

  //insert at specified index
  public void add( int index, Object newVal );

  //remove node from list, return its data
  public Object remove( int index );

  //return data in element at position i
  public Object get( int i );

  //overwrite data in element at position i
  public Object set( int i, Object x );

  //return length of list
  public int size();

}//end interface
