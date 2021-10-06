public class BigSib {
  String helloMsg;

  public static String greet(String name){

    return(helloMsg + " " + name);
  }

  public static void setHelloMsg(String message){
    helloMsg = message;
  }
}
