//Team: Ameer Alnasser, Sophia Eiden, Jacob Kirmayer
//APCS
//HW14 -- Customize Your Creation / overloaded constructors
//10/7/21

public class BigSib {
  String helloMsg;

  public BigSib(String message){
    helloMsg = message;
  }

  public String greet(String name){
    return(helloMsg + " " + name);
  }

}
