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

public class BigSib {
  String helloMsg;

  public BigSib(String message){
    helloMsg = message;
  }

  public String greet(String name){
    return(helloMsg + " " + name);
  }

}
