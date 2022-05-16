// National Security Agency :: Nora Miller, Sophia Eiden, Ameer Alnasser
// APCS pd6
// HW99: Some Are More Equal Than Others, Codified
// 2022-05-13
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{
  public ArrayList<Integer> _container;
  public int max;
  public ArrayPriorityQueue(){
    _container=new ArrayList<Integer>();
     max=0;
  }
  public void add(int x){
    _container.add(x);
    if(x>=max){
      max=x;
    }
  }
  public boolean isEmpty(){
    return (_container.size()==0);
  }
  public int peekMin(){
    int y=max;
    for(int e: _container){
      if(e<=y){
        y=e;
      }
    }
    return y;
  }
  public int removeMin(){
    int z=peekMin();
  _container.remove(_container.indexOf(z));//_container.remove(_container.get(z))
    return z;
  }
  public String toString(){
    return _container.toString();
  }
  public static void main(String[] args){
    ArrayPriorityQueue x=new ArrayPriorityQueue();
    x.add(0);
    x.add(13);
    x.add(11);
    x.add(4);
    x.add(3);
    x.add(7);
    x.add(12);
    x.add(14);
    x.add(15);
    System.out.println("min:"+x.peekMin());
    System.out.println( x.removeMin());
    System.out.println(x);
    System.out.println("min:"+x.peekMin());

    System.out.println(x.removeMin());
    System.out.println(x);
    System.out.println("min:"+x.peekMin());

    System.out.println(x.removeMin());
     System.out.println(x);
     System.out.println("min:"+x.peekMin());

System.out.println(x.removeMin());
    System.out.println(x);
    System.out.println("min:"+x.peekMin());

  System.out.println(x.removeMin());
    System.out.println(x);


  }
}
