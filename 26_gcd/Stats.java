/*
Team ___ {Fang, Sophia, and duckies}
APCS
HW26 -- GCD Three Ways
2021-10-28
time spent: 0.8 hr
*/

/*
DISCOVERIES
0: A recursion can easily be translated to a while loop function.
1: The gcdER and gcdEW methods would not work for values less than 1 because a would never equal b.
1.1: Thus the function would loop infinitely.
QCC
0: Is there any reason you would use a recursion over a while loop?
ALGO
Given inputs of int a and int b. Until a = b, if a is greater than b, a = a - b; if b is greater than a, b = b - a. When a = b, the gcd will be either a (or b).
*/

public class Stats {

	public static int mean(int a, int b) {
		return (a + b) / 2;
	}

	public static double mean(double a, double b) {
		return (a + b) / 2;
	}

	public static int max(int a, int b) {
		if (a > b) {
		  return a;
		} else {
		    return b;
		}
	}

	public static double max(double a, double b) {
		if (a > b) {
		  return a;
		} else {
		    return b;
		}
	}

	public static int geoMean(int a, int b) {
		int product = a * b;
		double meanD = Math.pow(product, 1.0/2);
		long meanL = Math.round(meanD);
		int meanI = Math.round(meanL);
		return meanI;
	}

	public static double geoMean(double a, double b) {
		double product = a * b;
		return Math.pow(product, 1.0/2);
	}

	public static int max(int a, int b, int c) {
		if ((a > b) && (a > c)) {
		  return a;
		} else {
		    if ((b > a) && (b > c)) {
		      return b;
		    } else {
		        return c;
		    }
		 }
	}

	public static double max(double a, double b, double c) {
		if ((a > b) && (a > c)) {
		  return a;
		} else {
		    if ((b > a) && (b > c)) {
		      return b;
		    } else {
		        return c;
		    }
		}
	}

	public static int geoMean(int a, int b, int c) {
		int product = a * b * c;
		double meanD = Math.pow(product, 1.0/3);
		long meanL = Math.round(meanD);
		int meanI = Math.round(meanL);
		return meanI;
	}

	public static double geoMean(double a, double b, double c) {
		double product = a * b * c;
		return Math.pow(product, 1.0/3);
	}

  // HW 26

	public static int gcd(int a, int b) {

		int i = 1;
		int gcd = 1;
		while (i <= Math.min(a, b)) {
			if ((a % i == 0) && (b % i == 0)) {
				gcd = i;
			}
			i ++;
		}
		return gcd;

	}

	public static int gcdER(int a , int b) {

		if (a != b) {
			if (a > b) {
				return gcdER(a - b, b);
			} else {
				return gcdEW(a, b - a);
			}
		} else {
			return a;
		}

	}

	public static int gcdEW(int a, int b) {

		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;

	}

	public static void main(String[] args) {

		System.out.println(gcd(18, 12));
		System.out.println(gcdER(18, 12));
		System.out.println(gcdEW(18, 12));

		System.out.println(gcd(4, 4));
		System.out.println(gcdER(4, 4));
		System.out.println(gcdEW(4, 4));

		System.out.println(gcd(3, 29));
		System.out.println(gcdER(3, 29));
		System.out.println(gcdEW(3, 29));

	}

}
