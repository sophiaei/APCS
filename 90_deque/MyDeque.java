// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW 90: Swabbing the Deque
// 2022-04-13
// time spent: 0.7 hrs

public class MyDeque<Card> implements Deque<Card> 
{
    private LLQueue<Card> _deque;

    public MyDeque() 
    {
        _deque = new LLQueue<Card>();
    }

    // Inserts the specified element at the front of this deque
    public void addFirst(Card x) 
    {
        _deque.addFirst(x);
    }

    // Inserts the specified element at the end of this deque
    public void addLast(Card x)
    {
        _deque.addLast(x);
    }

    // Retrieves, but does not remove, the first element of this deque
    // Returns null if this deque is empty
    public Card peekFirst()
    {
        return _deque.peekFirst();
    }

    // Retrieves, but does not remove, the last element of this deque
    // Returns null if this deque is empty
    public Card peekLast() 
    {
        return _deque.peekLast();
    }

    // Retrieves and removes the first element of this deque
    public Card removeFirst()
    {
        return _deque.removeFirst()
    }

    // Retrieves and removes the last element of this deque
    public Card removeLast()
    {
        return _deque.removeLast();
    }

    // Returns true if this deque is empty, otherwise returns false
    public boolean isEmpty()
    {
        return _deque.isEmpty();
    }

    // Returns the size of the deque
    public int size()
    {
        return _deque.size();
    }

}