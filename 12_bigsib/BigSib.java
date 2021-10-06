//Sophia Eiden
//APCS
//HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
//2021-10-5
/*
DISCO
- inst. vars defined outside of method
- state protection + return type of methods
QCC
- what is the diff btwn. inst. vars and the variables up to now?
- advantages of using instance vars?
*/

public class BigSib {
  String helloMsg;

  public String greet(String name){
    return(helloMsg + " " + name);
  }

  public void setHelloMsg(String message){
    helloMsg = message;
  }
}
