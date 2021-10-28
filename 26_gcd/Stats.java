/*
Team ___: Sophia Eiden, Fang Min Chen
APCS
HW26 - GCD Three Ways
10/27/21
time spent: 0.5 hrs
*/

public class Stats {

  public static int mean(int a, int b) {
    return (a + b) / 2;
  }

  public static double mean(double a, double b) {
    return (a + b) / 2;
  }

  public static int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
        return b;
  }
}

  public static double max(double a, double b) {
    if (a > b) {
      return a;
    } else {
        return b;
  }
}

  public static int geoMean(int a, int b) {
    int product = a * b;
    double meanD = Math.pow(product, 1.0/2);
    long meanL = Math.round(meanD);
    int meanI = Math.round(meanL);
    return meanI;
  }

  public static double geoMean(double a, double b) {
    double product = a * b;
    return Math.pow(product, 1.0/2);
  }

  public static int max(int a, int b, int c) {
    if ((a > b) && (a > c)) {
      return a;
    } else {
        if ((b > a) && (b > c)) {
          return b;
        } else {
            return c;
        }
     }
  }

  public static double max(double a, double b, double c) {
    if ((a > b) && (a > c)) {
      return a;
    } else {
        if ((b > a) && (b > c)) {
          return b;
        } else {
            return c;
        }
     }
  }

  public static int geoMean(int a, int b, int c) {
    int product = a * b * c;
    double meanD = Math.pow(product, 1.0/3);
    long meanL = Math.round(meanD);
    int meanI = Math.round(meanL);
    return meanI;
  }

  public static double geoMean(double a, double b, double c) {
    double product = a * b * c;
    return Math.pow(product, 1.0/3);
  }

  // begin HW26
  public static int gcd(int a, int b){
    int gcd = 1;
    int counter = 1;
    while (counter <= Math.min(a,b)){
      if ((a % counter == 0) && (b% counter == 0)){
        gcd = counter;
      }
      counter ++;
    }
    return gcd;
  }

  public static int gcdER(int a, int b){
    if (b == a){
      return a;
    }
    if (a>b){
      return (gcdER(a-b,b));
    }else{
      return gcdER(a, b-a);
    }

  }


  public static int gcdEW(int a, int b){
    int larger = Math.max(a,b);
    int smaller = a + b - larger;
    int divisor = smaller;
    while (divisor <= smaller){
      if ((larger%divisor == 0) && (smaller % divisor ==0)){
        return divisor;
      }
      else {
        divisor --;
      }
    }
    return 1;
  }

  //main method for testing functionality
  public static void main( String[] args ) {
    System.out.println(gcd(15,13));
    System.out.println(gcdER(52,130));
    System.out.println(gcdEW(34, 123454));
  }

}//end class
