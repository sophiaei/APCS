// (FA)FSA: Fang, Sophia, Ameer
// APCS pd06
// HW 90: Swabbing the Deque
// 2022-04-13
// time spent: 0.7 hrs

public interface Deque<Card> {

    // Inserts the specified element at the front of this deque
    public void addFirst(Card x);

    // Inserts the specified element at the end of this deque
    public void addLast(Card x);

    // Retrieves, but does not remove, the first element of this deque
    // Returns null if this deque is empty
    public Card peekFirst();

    // Retrieves, but does not remove, the last element of this deque
    // Returns null if this deque is empty
    public Card peekLast();

    // Retrieves and removes the first element of this deque
    public Card removeFirst();

    // Retrieves and removes the last element of this deque
    public Card removeLast();

    // Returns true if this deque is empty, otherwise returns false
    public boolean isEmpty();

    // Returns the size of the deque
    public int size();

}