/*
Team SOB: Sophia Eiden, Brian Kang + duckies
APCS
HW27: FOR the love of strings
2021-10-28
time spent: 0.71 hours

DISCO
-
QCC
- used structure of fenceR from last HW to build reverseR
*/

public class Rof{
	public static String fenceF(int posts){
		String fenceString = "|";
		for (int i = 1; i < posts; i++){
			fenceString += "--|";
		}
		return fenceString;
	}

	public static String reverseF(String s){
		String reversed = "";
		for (int i = 1; i <= s.length(); i++){
			reversed += (s.substring((s.length() - i), s.length()- i+1));
		}
		return reversed;
	}

	public static String reverseR(String s){
		if (s.length() > 1){
			return s.substring(s.length() - 1) + reverseR(s.substring(0, s.length()-1));
		}else{
			return s.substring(s.length() - 1);
		}
	}

	public static void main(String[] args){

		System.out.println(fenceF(1));
		System.out.println(fenceF(2));
		System.out.println(fenceF(3));

		System.out.println(reverseF("stressed"));
		System.out.println(reverseR("deliver"));

	}
}
