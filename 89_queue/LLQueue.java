// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW 89: Queue Two Ways
// 2022-04-12
// time spent: 0.5 hrs

import java.util.LinkedList;

public class LLQueue<P> implements Queue<P>
{

    private LinkedList<P> _queue;

    public LLQueue() {
        _queue = new LinkedList<P>();
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public P dequeue()
    {
        return _queue.removeFirst();
    } // O(1)

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( P x ) {
        _queue.add(x);
    } // O(1)

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
        return _queue.isEmpty();
    } // O(1)

    //Returns the first element of the queue without dequeuing it.
    public P peekFront() {
        return _queue.peekFirst();
    } // O(1)

    //toString
    public String toString() {
        String str = "";
        if (_queue.isEmpty()) { return str; }
        for (P item : _queue) {
            str += (String) item + ", ";
        }
        return str.substring(0, str.length() - 2);
    }

    //main method for testing
    public static void main(String[] args)
    {
        LLQueue<String> test = new LLQueue<String>();

        System.out.println("Empty? " + test.isEmpty());
        System.out.println(test);

        test.enqueue("Fang");
        test.enqueue("Sophia");
        test.enqueue("Ameer");
        System.out.println("Empty? " + test.isEmpty());
        System.out.println(test);

        System.out.println(test.peekFront());
        test.dequeue();
        System.out.println(test);

        System.out.println(test.peekFront());
        test.dequeue();
        System.out.println(test);

        System.out.println(test.peekFront());
        test.dequeue();
        System.out.println(test);
    }

}
