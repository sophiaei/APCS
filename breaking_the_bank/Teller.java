//TNPG: AwesomeName

public class Teller{
	public static void main(String[] args){
	
	//basic setup - not hacking here
		BankAccount ba = new BankAccount();
		ba.setName("Sophia Eiden");
		ba.setPasswd("herebapassword");
		ba.setPin((short)9999);
		ba.setPin((short)1423);
		ba.setAcctNum(1893);
		ba.setAcctNum(555555555);
		ba.setBalance((long)37898);
		System.out.println(ba.toString());
	//breaking it now
		for(int i = 1000; i < 9999; i++){
		 	boolean a = ba.authenticate(555555555,(short)i);
			if (a){
				System.out.println("got ur pin lol: " + i);
				break;
			}
		}

	
	}
}

