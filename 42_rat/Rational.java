// Team Strawberry_JAM: Josiah Moltz, Melody Lew, Sophia Eiden
// APCS pd 06
// HW41 - Be More Rational / Rational ++
// 2021-12-2
// time spent: 0.6 hrs


/*
DISCO
0. Order of the print statements in main matter because our rational parameters
change after each arithmetic operation.

QCC
0. If we make the variables final, would the parameters stay the same after whichever
operation?
*/

public class Rational {
  private int p;
  private int q;

  public Rational() {
    p = 0;
    q = 1;
  }

  public Rational( int m, int n ) {
    this(); // slick
    if (n != 0) {
      p = m;
      q = n;
    }
  }

  public double floatValue() {
    return (double) p / q;
  }

  public String toString() {
    return p + "/" + q;
  }

  //from Stats.java
  public static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    int i = 1;
    int gcd = 1;
    if (a == 0){
      return b;
    }
    while (i <= Math.min(a, b)) {
        if ((a % i == 0) && (b % i == 0)) {
            gcd = i;
        }
        i ++;
    }
    return gcd;
  }

  public void reduce(){
    int g = gcd(p,q);
    p = p / g;
    q = q / g;
  }

  //calling object: object we are calling from...
  public int compareTo(Rational r){
    if (this.floatValue() == r.floatValue()){
      return 0;
    }
    else if (this.floatValue() > r.floatValue()){
      return 1;
    }
    else {
      return -1;
    }
  }

  public void add(Rational addend){
    if (addend.q == q){ //same denominator
      p = addend.p + p;
    }
    else{ //get common denominator
      p = (p * addend.q) + (q * addend.p);
      q = (q * addend.q);
    }
  }

  public void subtract(Rational subtrahend){
    if (subtrahend.q == q){ //same denominator
      p = subtrahend.p - p;
    }
    else{ //get common denominator
      p = (p * subtrahend.q) - (q * subtrahend.p);
      q = (q * subtrahend.q);
    }
  }

  public void multiply(Rational multiplier) {
    // if we multiply p/q and m/n, the result is p * m (numerator) / q * n (denominator)
    p = p * multiplier.p; // *SNIFF SNIFF* I SMELL A QAF POST :)))))))))))
    q = q * multiplier.q;
  }

  public void divide(Rational divisor) {
    // if we divide p/q and m/n, the result is p * n (numerator) / q * m (denominator)
    if (divisor.p != 0){
      p = p * divisor.q;
      q = q * divisor.p;
    }
  }

  public static void main(String[] args) {
    Rational r = new Rational(2,3); //Stores the rational number 2/3
    Rational s = new Rational(1,2); //Stores the rational number 1/2
    Rational t = new Rational(4,18); //Stores the rational number 4/18
    Rational u = new Rational(4,6); //Stores the rational number 4/6
    Rational v = new Rational(6,4); //Stores the rational number 6/4
    System.out.println(r.compareTo(u));
    r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
    System.out.println(r);
    t.reduce(); //Changes t to 2/9
    System.out.println(t); //should be 2/9
    r.subtract(s);
    System.out.println(r);//should be 8/12
    v.reduce();
    System.out.println(v); //should be 3/2
  }

}
