// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW 89: Queue Two Ways
// 2022-04-12
// time spent: 0.5 hrs

/***
 * DISCO
 * 0: The Oracle java API has official documentation of all the methods in the
 * the java library class, including many not included in the duke documentation.
 * 1: Encapsulation diagrams are of gods' grace.
 *
 * QCC
 * 0: What's the difference between using the lower indexes as the front as opposed
 * as opposed to the back in ArrayList? In other words, is there a benefit to making
 * the enqueue method linear run time instead of the dequeue method?
***/

import java.util.ArrayList;

public class ALQueue<P> implements Queue<P>
{

    private ArrayList<P> _queue;

    public ALQueue() {
        _queue = new ArrayList<P>();
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public P dequeue()
    {
        return _queue.remove(0);
    } // O(n)

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
        return _queue.get(0);
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
        ALQueue<String> test = new ALQueue<String>();

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
