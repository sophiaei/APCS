//Sophia Eiden
//APCS
//HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
//2021-10-5

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
