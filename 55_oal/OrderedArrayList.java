import java.util.ArrayList;

public class OrderedArrayList {
  public ArrayList<Integer> jam;

  public OrderedArrayList() {
    jam = new ArrayList<Integer>();
  }

  public boolean add(int i) {
    int index = 0;
    while (index < size() && i > get(index)) {
      index += 1;
    }
    jam.add(index, i);
    return true;
  }

  public int remove(int index) {
    return jam.remove(index);
  }

  public int get(int index) {
    return jam.get(index);
  }

  public int size() {
    return jam.size();
  }

  public String toString() {
    return jam.toString();
  }
}
