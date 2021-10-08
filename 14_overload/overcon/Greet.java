//Team: Ameer Alnasser, Sophia Eiden, Jacob Kirmayer
//APCS
//HW14 -- Customize Your Creation / overloaded constructors
//10/7/21
/*
DISCO
 - overloading constructors allows for more flexibility
    -> in this instance, if the user doesnt set a var, the code sets it to a default
 -
QCC
 - how far can you go with overloading?
 - why did we do the 2 options of defcon and overcon? just to demonstrate the difference?
*/


public class Greet{
  public static void main(String[] args ) {
        String greeting;
            BigSib richard = new BigSib();
            BigSib grizz = new BigSib();
            BigSib dotCom = new BigSib();
            BigSib tracy = new BigSib();
            greeting = richard.greet("freshman");
            System.out.println(greeting);
            greeting = grizz.greet("Dr. Spaceman");
            System.out.println(greeting);
            greeting = dotCom.greet("Kong Fooey");
            System.out.println(greeting);
            greeting = tracy.greet("mom");
            System.out.println(greeting);
    } //end main()
} //end Greet
