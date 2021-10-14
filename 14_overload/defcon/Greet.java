//Team: Ameer Alnasser, Sophia Eiden, Jacob Kirmayer
//APCS
//HW14 -- Customize Your Creation / overloaded constructors
//10/7/21
/*
DISCO-

QCC-
*/
public class Greet{
  public static void main(String[] args ) {
     String greeting;
         BigSib richard = new BigSib("Word up");
         BigSib grizz = new BigSib("Hey ya");
         BigSib dotCom = new BigSib("Sup");
         BigSib tracy = new BigSib("Salutations");
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
