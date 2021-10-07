//Sophia Eiden
//APCS
//HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
//2021-10-5
/*
DISCO
- constructors can have variable defs inside them
QCC

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
