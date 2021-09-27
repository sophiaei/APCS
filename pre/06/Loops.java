import java.lang.Math;

public class Loops {
  public static double power(double x, int n){
    int a;
    double b = x;
    for (a=1; a<n; a++){
        b = b*x;
    }
    return b;
  }

  public static int factorial(int n){
    int a;
    int r =1;
    for (a=1; a<=n; a++){
      r = r*a;
    }
    return r;
  }

  public static double myexp( int x, int n){
    int i;
    double r=.0;
    for (i=0; i<n; i++){
      r = r + (Math.pow(x,i)/factorial(i));
      System.out.println(r);
    }
    return r;
  }

  public static double myexp2(int x, int n){
    int i;
    double r = x;
    double fact = x, pow = 1;
    for (i=1; i<n; i++){
      fact = fact*x;
      pow = pow*i;
      r = r+(fact/pow);
    }
    return r;
  }
  public static void check(int x, int n){
    System.out.println(x+"\t"+myexp2(x,n)+"\t"+Math.exp(x));
  }



  public static void main(String[] args){
    double i;
    for(i = 0.1; i<=100.0; i=i*10){
      check((int)i,26);
    }

  }

}
