//Team Elder Gods: Sophia Eiden, Prattay Dey
//APCS
//HW13 -- Where do BigSibs Come From? / Constructors
//2021-10-6
/*
DISCO:
- Constructors can have variable defs inside them
- You can call on the constructor to create an object in the class, using keyword "new"
- Constructors can have multiple parameters

QCC:
- What are the benefits of using a constructor compared to a method?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib("Word up");
    greeting = richard.greet("freshman");
    System.out.println(greeting);

    richard.helloMsg = "Saluations";
    greeting = richard.greet("Dr. Spaceman");
    System.out.println(greeting);

    richard.helloMsg = ("Hey ya");
    greeting = richard.greet("Kong Fooey");
    System.out.println(greeting);

    richard.helloMsg = ("Sup");
    greeting = richard.greet("Mom");
    System.out.println(greeting);

  } //end main()
} //end Greet
