// Team Strawberry_JAM: Josiah Moltz, Melody Lew, Sophia Eiden
// APCS
// HW40 - Be Rational / Rational class / Constructor, Multiply, Divide, toString, floatValue
// 2021-12-1
// time spent: 0.5 hour
// A HUGE THANKS TO LAUREN LEE FOR PROVIDING THE MAJORITY OF OUR TEST CASES !!!! <3

/*
DISCO
0. When printing an object, uses toString method (the redefined one)
1. Just a semicolon runs
2. Without a semicolon, the if is not "complete" (?)

QCC
0. Why to DISCO 2.
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

    /* OG code... a possible code killer
    if (n == 0) ; // Huh... that lonely semicolon... INTERESTING!?!?!?!?
    // IF ; IS NOT INCLUDED... we're screwed else is highlighted differently and the previous if is not registered
    else {
      p = m;
      q = n;
    }
    */
  }

  public float floatValue() {
    return (float) p / (float) q;
  }

  public String toString() {
    return p + "/" + q;
  }

  public void multiply(Rational multiplier) {
    // if we multiply p/q and m/n, the result is p * m (numerator) / q * n (denominator)
    p = p * multiplier.p; // *SNIFF SNIFF* I SMELL A QAF POST :)))))))))))
    q = q * multiplier.q;
  }

  public void divide(Rational divisor) {
    // if we divide p/q and m/n, the result is p * n (numerator) / q * m (denominator)
    p = p * divisor.q;
    q = q * divisor.p;
  }

  public static void main(String[] args) {
    // TY LAUREN LEE WE STAN YOUUUU
    Rational def = new Rational();
    System.out.println("Default contructor: " + def + " ...should be 0/1");
    System.out.println("//====================================");

    Rational d0 = new Rational(1, 0);
    System.out.println("Denominator set to 0: " + d0 + " ...should be 0/1");
    System.out.println("//====================================");

    Rational r = new Rational(1 , 8);
    Rational s = new Rational(1 , 2);
    Rational t = new Rational(21 , 5);
    System.out.println("r: " + r + " ...should be 1/8");
    System.out.println("s: " + s + " ...should be 1/2");
    System.out.println("t: " + t + " ...should be 21/5");
    System.out.println("float value of r " + r.floatValue() + " ...should be 0.125");
    System.out.println("float value of s " + s.floatValue() + " ...should be 0.5");
    System.out.println("float value of t " + t.floatValue() + " ...should be 4.2"); // :)
    r.multiply(s);
    System.out.println("value of r after multiplication: " + r + " ...1/16");
    System.out.println("value of s after multiplication: " + s + " ...1/2");
    r.divide(s);
    System.out.println("value of r after division: " + r + " ...2/16");
    System.out.println("value of s after division: " + s + " ...1/2");
    r.multiply(t);
    System.out.println("value of r after multiplication: " + r + " ...42/80");
    System.out.println("value of t after division: " + t + " ...21/5");
    r.divide(t);
    System.out.println("value of r after multiplication: " + r + " ...210/1680");
    System.out.println("value of t after division: " + t + " ...21/5");
  }

}
