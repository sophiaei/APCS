public class Driver{
  public static void main(String[] args) {
  //42_rat test cases
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

  //49_rat equals cases
  System.out.println(r.equals(r)); //true
  System.out.println(r.equals(v)); //false
  System.out.println(r.equals(42)); //false
  System.out.println(r.equals(42.0)); //false
  System.out.println(r.equals("Strawberry JAM is jammin'")); //false
  }
}
