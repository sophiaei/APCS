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

public class BigSib {
  String helloMsg;

  public BigSib(){ // default greeting
    helloMsg = "Greetings!";
  }

  public BigSib(String message){ // overloaded constructor - for 'user' selection
    helloMsg = message;
  }

  public String greet(String name){
    return(helloMsg + " " + name);
  }//ends main
}//ends BigSib
