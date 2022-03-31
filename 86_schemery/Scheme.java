/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 **/
import java.util.Stack;
import java.util.ArrayList;

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
   Stack<String> stack = new Stack<String>();
   String[] parsed = expr.split("\\s+");
   String operand = "";

   for (int i = 0; i < parsed.length; i++){

     if (parsed[i] == ")"){

       if (operand == "+"){stack.push(unload(1, stack));}
       else if (operand == "-"){stack.push(unload(2, stack));}
       else if (operand == "*"){stack.push(unload(3, stack));}
       else{ return "i think something went wrong";}
     }
     else if (isNumber(parsed[i]) || parsed[i] == "("){
       stack.push(parsed[i]);
     }
     else{ operand = parsed[i]; }
   }
   return ""+(stack.peek());

  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    int temp;
    int result;

    if (op == 1){
      result = 0;
      while (numbers.peek() != "(") {
        result += Integer.parseInt(numbers.pop());
      }
    }
    else if (op == 2){
      result = Integer.parseInt(numbers.pop());
      while (numbers.peek() != "(") {
        result -= Integer.parseInt(numbers.pop());
      }
    }
    else{
      result = 1;
      while (numbers.peek() != "(") {
        result *= Integer.parseInt(numbers.pop());
      }
    }
    numbers.pop();
    return ""+result;
  }//end unload()


  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
