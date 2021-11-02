/*
Team ___ : Sophia Eiden, Fang Chen
APCS
HW29: Which Way Do You Roll? / for each loops, integer & string manipulation
2021-11-01
time spent: 1.1 hrs


DISCO
- Integer.toString(int) --> string representation of int
  - also String.valueOf(int) does the same i think
- for each
  - need to declar var type for iterating variable
  - args are in strings, need to convert for functionality

QCC
- is there a better way to incorporate the counter in commafyF? it seems inelegant now.
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

  public static String commafyF(int n){
    String commafied = "";
    String s = Integer.toString(n);

    //System.out.println(s);
    int c = 0;
    for (int i = s.length(); i > 0; i -= 1){
        if (c%3 == 0 && c != 0){
          commafied = ","+commafied;
        }
      commafied = s.substring(i-1, i) + commafied;
      c += 1;
      }

    return commafied;
  }

  public static void main(String[] args) {
    for (String str:args){
      int i = Integer.parseInt(str);
      System.out.println(commafyF(i));
    }

  }
}
