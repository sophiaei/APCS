// SCH: David, Sophia, Jing
// APCS pd06
// HW71 - Whut Dis.
// 2022-03-07
// time spent: 30mins
/*
As an initial starting point, I transcribed the pseudo-code from the paper to
workable java code.

Interesting! With reverse sorted and sorted configurations of the array,
  it returns a sorted array.
  Perhaps sorting is something related to it?

It always gets at least close to sorted, with one or two spots wrong.
No idea where to go from here - also too late.
*/

import java.util.Arrays;
public class Mysterion{

  public static int[] unknown(int[] arr, int a, int b, int c) {
    int v = arr[c];
    //swap arr[c], arr[b]
    int temp = arr[c];
    arr[c] = arr[b];
    arr[b] = temp;
    //
    int s = a;
    for (int i = 0; i < b; i++){
      if (arr[i] < v){
        //swap arr[s], arr[i]
        temp = arr[s];
        arr[s] = arr[i];
        arr[i] = temp;
        //
        s+=1;
      }
    }
    //swap arr[b], arr[s]
    temp = arr[b];
    arr[b] = arr[s];
    arr[s] = temp;

    return arr;
  }

  public static void main(String[] args) {
    int[] array = {7,1,5,12,3};

    System.out.println(Arrays.toString(unknown(array, 0,4,2)));

    int[] array2 = {12,7,5,3,1};

    System.out.println(Arrays.toString(unknown(array2, 0,4,2)));

    int[] array3 = {1,3,5,7,12};

    System.out.println(Arrays.toString(unknown(array3, 0,4,2)));

    int[] array4 = {5,3,1,12,7};

    System.out.println(Arrays.toString(unknown(array4, 0,4,2)));

  }
}
