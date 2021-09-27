import java.util.Scanner;

public class Methods {
  public static boolean isDivisible(int n, int m){
    n = (int)n;
    m = (int)m;

    if ((n % m) == 0){
      System.out.println( n % m );
      return true;
    }
    else{
      System.out.println( n%m + "Hi" );
      return false;
    }

  }
  public static boolean isTriangle(int a, int b, int c){

    if ((a+b < c) || (a+c < b) || (b+c< a)){
      return false;
    }
    else{
      return true;
    }

  }
  public static int ack(int m, int n){
    if (m == 0){
      System.out.println(n+1);
      return n+1;
    }
    else if (m>0 && n==0){
      System.out.println(ack(m-1,1));
      return ack(m-1,1);
    }
    else {
      System.out.println(ack(m-1,ack(m,n-1)));
      return ack(m-1,ack(m,n-1));
    }
  }


  public static void main(String [] args){
    System.out.println(ack(1,0));

  }
}
