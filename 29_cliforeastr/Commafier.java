/*
Team ___ : Sophia Eiden, Fang Chen
APCS
HW29: Which Way Do You Roll? / for each loops, integer & string manipulation
2021-11-01
time spent: 1.1 hrs


DISCO
0: The main method MUST have the a String[] (not any other primitive datatypes or arrays) as the argument.
	0.1: The terminal will return "Error: Main method not fount in class [className]..." if you try running the class.
1: Since the datatype int is 32-bit, it can only hold a total of 2^32 numerical values (-2,147,483,648 to 2,147,483,647).
	1.1: This means that Integer.parceInt() will not work with Strings containing values outside the int range.
	1.2: When 2491273112 was inputted, the terminal returned...
		"Exception in thread "main" java.lang.NumberFormatException: For input string: "2491273112"
	        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	        at java.base/java.lang.Integer.parseInt(Integer.java:652)
	        at java.base/java.lang.Integer.parseInt(Integer.java:770)
	        at Commafier.main(Commafier.java:15)"
2: Integer.toString(int) --> string representation of int
  2.1: also String.valueOf(int) does the same i think
3: for each
  3.1: need to declar var type for iterating variable
  3.2: args are in strings, need to convert for functionality

QCC
0: Is it possible to commafy a double value with an unknown number of decimal places?
1. is there a better way to incorporate the counter in commafyF? it seems inelegant now.
*/

public class Commafier{
  public static String commafyR(int n){
    String commafied = "";
    String s = Integer.toString(n);

    if (s.length()<= 3){
      return s;
    }else{
      return commafyR(Integer.parseInt(s.substring(0,s.length()-3))) + "," + s.substring(s.length()-3);
    }

    // commafyR(Integer.parseInt(nStr.substring(0, strLen-3))) + "," + nStr.substring(strLen -3);
  }

  public static String commafyF(int num) {
		String s = Integer.toString(num);
		String commafied = "";

		for (int i = s.length(); i > 3; i = i - 3) {
			if (commafied.equals("")) {
				commafied = s.substring(i - 3);
			}
			commafied = "," + commafied;
			s = s.substring(0, i - 3);
		}
		commafied = s + commafied;
		return commafied;
	}

  public static void main(String[] args) {
    for (String str:args){
      int i = Integer.parseInt(str);
      System.out.println(commafyF(i));
    }

  }
}
