// (FA)FSA -- Fang, Sophia, Ameer
// APCS Pd06
// HW 87 -- The English DO Not Wait in Line for Soup!!!!!!!
// 2022-04-01
// time spent: 1.0 hrs

/*
QCC:

We were so unsure of how to proceed. In the end, we kept enqueue and dequeue
pretty much the same as 87 -  just added sample in enqueue.

The issue lies in how sample works. There's a couple of approaches
- fully shuffling the queue. We don't like this option since it has a long
  runtime and feels unclean.
- changing front ? but then we lose too much data. This might be remedied by
  adding a _truefront variable? but not very nice.
*/


/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    //special case: when enqueuing to an empty list,
    //make _front && _end point to same node
    if ( isEmpty() ) {
      _front = _end = new LLNode( enQVal, null );
    }
    else {
      _end.setNext( new LLNode( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
  //  System.out.println("enqueued " + enQVal);
  }//O(?)

  public SWASHBUCKLE dequeuefront()
    {
      SWASHBUCKLE retVal = peekFront();
      _front = _front.getNext();

      if ( _front == null ) //just moved past last node
        _end = null;      //update _end to reflect emptiness

      _size--;

      return retVal;
    }


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    int random = (int)(Math.random()*(_size+1));

    LLNode tmp=_end;
    for (int i = 0; i <= random; i++){
      sample();
    }
    SWASHBUCKLE output = peekFront();
    dequeuefront();

    for (int i = 0; i < _size - random; i++){
      sample();
    }
    _size--;
    return output;
  }//O(?)


  public SWASHBUCKLE peekFront()
  {
    return _front.getCargo();
  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   randomly assigns the front to any node on the line (thats us)
   **/
  public void sample ()
  {
    enqueue(dequeuefront());
  }//O(??)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {



    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    System.out.println( PirateQueue );
    PirateQueue.enqueue("Pirate");
    System.out.println( PirateQueue );
    PirateQueue.enqueue("Roberts");
    System.out.println( PirateQueue );
    PirateQueue.enqueue("Blackbeard");
    System.out.println( PirateQueue );
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");



    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...


    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );
  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
