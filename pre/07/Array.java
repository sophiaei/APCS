import java.util.Arrays;
import java.lang.Math;

public class Array{
  public static double[] powArray(double[] a, int x){
    double[] b = new double[a.length];
    for (int i=0; i<a.length; i++){
      b[i] = Math.pow(a[i], x);
    }
    return b;
  }


  public static int indexOfMax(int[] a){
    int idx = 0;
    int val = 0;
    int i;
    for (i = 0; i < a.length; i++){
      if (a[i] > val){
        val = a[i];
        idx = i;
      }
    }
    return idx;
  }

  public static boolean[] sieve(int n){
    //create an array n long with all true values
    boolean[] a = new boolean[n];
    int p;
    for (p =0; p<a.length; p++){
      a[p] = true;
    }
    //System.out.println(Arrays.toString(a));

    int i, j;
    for (i=2; i*i<=n-1; i++){
      if (a[i] == true){
        for (j = i*i; j<= n-1; j+=i){
          //System.out.println(j);
          a[j] = false;
        }
      }
    }
    return a;

  }

  public static void main(String[] args){
    //double[] array = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
    //int[] integers = {2,3,5,7,4,1,5,8,9,10};

    System.out.println("this is running");
    System.out.println(Arrays.toString(sieve(15)));
  }
}

//int i;
//int j;
//for (i=0; i>n; i++){
  //System.out.println("hi");
//  for (j=0; j>n; j++){

  //  if (i%j == 0){
  //    System.out.println("true");
  //  }
//    else{
  //    System.out.println("false");
//    }
//  }
//}
