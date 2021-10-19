/**
Team "AwesomeName"; William Vongphanith and Sophia Eiden
APCS
HW19 -- building a more meaningful class
2021-10-18

DISCO
--> Not much except != meaning not equal to (this was obvious because we learned this in intro)
-->	Typecasting using (short) in front of the number to cast it
--> Oveloading the method allows multiple input data structure types. This isn't a problem in interpreted languages, but a real pain in the neck in compiled ones.
--> Do extra homework (with things learned before the class did) in another directory (according to the "WillyV Rule" that another student told me was supposedly posted in the classroom)

Qs, Cs, and more Cs:
-->	When will we learn ternary operators?
 **/

 //This code was jacked from the library code, obviously
public class Bankaccount {

	// instance variables
	private String name;
	private String passwd;
	private short pin;
	private int acctNum;
	private double balance;
	// ---------------------------------------------

	// mutators
	public String setName(String newName) {
		String oldName = name;
		name = newName;
		return oldName;
	}

	public String setPasswd(String newPasswd) {
		String oldPasswd = passwd;
		passwd = newPasswd;
		return oldPasswd;
	}

	/* edited code*/
	public short setPin(short newPin) {
		short oldPin = pin;

		if (!(newPin < 9999 && newPin > 999)) {
			pin = 9999;
			System.out.println("Your PIN you provided was invalid (not a 4 digit number), so we set it to 9999");
			return oldPin;
		}
		pin = newPin;
		return oldPin;
	}

	public int setAcctNum(int newAcctNum) {
		int oldAcctNum = acctNum;
		if (!(newAcctNum > 99999999 && newAcctNum < 999999999)) {
			acctNum = 999999999;
			System.out.println("Your account number you provided was invalid (not a 9 digit number), so we set it to 999999999");
			return oldAcctNum;
		}
		else {
			acctNum = newAcctNum;
			return oldAcctNum;
		}
	}
	/* edits end*/

	public double setBalance(double newBalance) {
		double oldBalance = balance;
		balance = newBalance;
		return oldBalance;
	}
	// ---------------------------------------------

	public void deposit(double depositAmount) {
		balance = balance + depositAmount;
	}

  /* edited code*/

	public Boolean withdraw(double withdrawAmount) {
    if (withdrawAmount > balance){
      System.out.println("You attempted to withdraw more money than you had - invalid action. Nothing was changed.");
      return false;
    }
    else{
      balance = balance - withdrawAmount;
      return true;
    }
  /* edits end */

	}

	// overwritten toString()
	public String toString() {
		String retStr = "\nAccount info:\n=======================";
		retStr = retStr + "\nName: " + name;
		retStr = retStr + "\nPassword: " + passwd;
		retStr = retStr + "\nPIN: " + pin;
		retStr = retStr + "\nAccount Number: " + acctNum;
		retStr = retStr + "\nBalance: " + balance;
		retStr = retStr + "\n=======================";
		return retStr;
	}

	/* edited code */

	// Notice that we overloaded the function to take either a pin or a password. It's good that the pin and the password use different data types.
	// The following function(s) should really be private, but are public for the testing purposes.
	public boolean checkAuth (short userPin) {
		if (userPin != pin) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean checkAuth (String userPasswd) {
		if (userPasswd != passwd) {
			return false;
		}
		else {
			return true;
		}
	}
	/* edits end */

	// main method for testing
	public static void main(String[] args) {
		// I started a checking account.
		Bankaccount ba = new Bankaccount();

		short pin = 2345;
    // account setup
		ba.setName("ThunderRedStar");
		ba.setPasswd("SecurePassw0rd");
		ba.setPin(pin);
		ba.setAcctNum(123456789);
		ba.setBalance(123456789.1023);

    // checking authorization functionality (true + false conditions for both overloads)
    System.out.println(ba.checkAuth((short)2345));
    System.out.println(ba.checkAuth((short)1643));

    System.out.println(ba.checkAuth("SecurePassw0rd"));
    System.out.println(ba.checkAuth("notthepassword"));

    // checking withdraw/deposit functions (incl. 'overdraft' restriction)
		ba.deposit(1234);
		System.out.println(ba.toString());
		System.out.println(ba.withdraw(12345));
		System.out.println(ba.toString());

    ba.setBalance(10);
    ba.withdraw(100);
    System.out.println(ba.toString());
	}

}// end class BankAccount
