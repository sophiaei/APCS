// (FA)FSA -- Fang, Sophia, Ameer
// APCS Pd06
// HW 87 -- The English DO Not Wait in Line for Soup!!!!!!!
// 2022-04-01
// time spent: 1.0 hrs

/*
Disco:
Gang signs do be important
if you are calling a method with a null object, it will give u an error, which kind of makes sense, but now we know :)
QCC:
<local2> error?!?!?!!?!?!?!?!?!?!?!?
Our toString did not work for null NodeQueues
Why dont the english wait for soup :()
*/
public class NodeQueue<QUASAR> implements Queue<QUASAR>{

  LLNode<QUASAR> _tail=null;

  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue(){
    if(isEmpty()||_tail.getNext()==null){
      _tail=null;
      return null;
    }
    QUASAR output=peekFront();
    LLNode<QUASAR> tmp=_tail;
    while(tmp.getNext().getNext()!=null){
      tmp=tmp.getNext();
    }
    tmp.setNext(null);
    return output;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ){
    _tail=new LLNode<QUASAR>(x,_tail);
  }
  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){
    return (_tail==null);
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront(){
    if (isEmpty()){
      return null;
    }
    LLNode<QUASAR> tmp=_tail;
    while(tmp.getNext()!=null){
      tmp=tmp.getNext();
    }
    return tmp.getCargo();
  }
  public String toString(){
  String output="";
  LLNode<QUASAR> tmp=_tail;
  if (isEmpty()){
    return null;
  }
  while(tmp.getNext()!=null){
    output+=tmp.getCargo()+"<-";
    tmp=tmp.getNext();
  }
  output+=tmp.getCargo();
  return output;
}
  public class LLNode<QUASAR>
  {
    //instance vars
    private QUASAR _cargo;
    private LLNode<QUASAR> _nextNode;

    // constructor
    public LLNode( QUASAR value, LLNode<QUASAR> next )
    {
      _cargo = value;
      _nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo()
    {
      return _cargo;
    }

    public LLNode<QUASAR> getNext()
    {
      return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public QUASAR setCargo( QUASAR newCargo )
    {
      QUASAR foo = getCargo();
      _cargo = newCargo;
      return foo;
    }

    public LLNode<QUASAR> setNext( LLNode newNext )
    {
      LLNode<QUASAR> foo = getNext();
      _nextNode = newNext;
      return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
      return (String)_cargo;
    }
  }//end class LLNode

  public static void main(String[] args){
    NodeQueue fangMeanie= new NodeQueue();
    fangMeanie.enqueue("Ameer");
    System.out.println(fangMeanie);
    fangMeanie.enqueue("Phosia");
    System.out.println(fangMeanie);
    fangMeanie.dequeue();
    System.out.println(fangMeanie);
    fangMeanie.dequeue();
    System.out.println(fangMeanie);

  }
}
