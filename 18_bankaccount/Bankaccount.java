//Team "AwesomeName": Sophia Eiden, William Vongphanith
//APCS
//HW 18 - method implementation in practical function
//10-17-21
/*
DISCO
	- Private variables cannot be accessed outside of their class. You must access them through a method within the class.
	- If variables were public, you could access them from outside their class( i.e. as acct.accountName).
	- The assignment taught us to apply the concepts we learned in the pre-work and in class recently into a useful? class.
QCC
	- if an instance variable is private, but the method accessing the variable is public can u call the method from another class and access the variable?
		- and how semantic is the difference?
	- How do you truncate decimals so it displays in cents (i.e. $192.57 instead of 192.5728491923 or $928.50 instead of $928.5)?

Q2: How do you know BEFORE you wrote your own constructor, that Java provides one for you?
	We know that java provides us with a constructor because variables can be called without us initializing them ourselves - it is initalized as null, but initalized nonetheless

Q3: Describe a test to determine whether Java provides a mean of outputting a STRING REPRESENTATION of an OBJECT.
	Rather simply, one can run the method System.out.println(<<object_name>>.toString()). When I ran that on this code, it presented this: Bankaccount@4fccd51b. So yes, it does present a string representation of the object, but not one that is readily intelligible.
*/


class Bankaccount {
	// Notes:
		/*
		 * I don't think you can change your account number, so there's no method for that.
		 * The constructor generates a random 9-digit account number for you.
		 * Implemented proper security protocol. All information is private. So you can't set it without using proper methods.
		 * Implemented print function because I'm simply not going to type System.out.println every time.
		*/
	private String acct_name;
	private String acct_password;
	private int acct_pin;
	private int acct_number;
	private double acct_balance;

	public void print (String text) {
		System.out.println(text);
	}

	public Bankaccount (String name, String password, int pin) {
		acct_name = name;
		acct_password = password;
		acct_pin = pin;
		acct_number = Utils.random_acct_number();
		acct_balance = 0;
	}

	public void set_account_name (String password, String name) {
		if (password != acct_password) {
			print("Invalid password.");
		}
		else {
			acct_name = name;
		}
	}

	public void set_account_password (String old_password, String new_password) {
		if (old_password != acct_password) {
			print("Invalid password.");
		}
		else {
			acct_password = new_password;
		}
	}

	public void set_account_pin (String password, int pin) {
		if (password != acct_password) {
			print("Invalid password.");
		}
		else {
			acct_pin = pin;
		}
	}

	public void print_info (String password) {
		if (password != acct_password) {
			print("Invalid password.");
		}
		else {
			print("===== BEGIN ACCOUNT INFO =====");
			print("Account Number: " + acct_number);
			print("Account Name: " + acct_name);
			print("Account Password: " + "*".repeat(acct_password.length()));
			print("Account PIN: " + "****");
			print("=====  END ACCOUNT INFO  =====");
		}
	}

	public void get_balance (int pin) {
		if (pin == acct_pin) {
			print("Your balance is: $" + acct_balance);
		}
		else {
			print("Invalid PIN.");
		}
	}

	public void deposit (int pin, double amount) {
		if (pin == acct_pin) {
			acct_balance += amount;
			print("You have deposited $" + amount + ".");
		}
		else {
			print("Invalid PIN.");
		}
	}

	public void withdraw (int pin, double amount) {
		if (pin == acct_pin) {
			acct_balance -= amount;
			print("You have withdrawn $" + amount + ".");
		}
		else {
			print("Invalid PIN.");
		}
	}
}
