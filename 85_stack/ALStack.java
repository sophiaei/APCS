public class ALStack<PANCAKE> implements Stack<PANCAKE> {

  private ArrayList<PANCAKE> _stack;

  public ALStack<PANCAKE>() {
    _stack = new ArrayList<PANCAKE>();
  }

  public int size() {
    return _stack.size();
  }

  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty() 
  {
    return size() == 0;
  }

  //Return top element of stack without popping it.
  public PANCAKE peekTop() 
  {
    return _stack.get(size() - 1);
  }
  
  //Pop and return top element of stack.
  public PANCAKE pop()
  {
    return _stack.remove(size() - 1);
  }

  //Push an element onto top of this stack.
  public void push( PANCAKE x )
  {
    _stack.add(x);
  }


}

