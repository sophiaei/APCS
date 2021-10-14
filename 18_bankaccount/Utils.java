//Team "AwesomeName": Sophia Eiden, William Vongpurithan
//APCS
//HW 18 - method implementation in practical function
//10-13-21

import java.util.Random;

// uTiLiLiLiLiLiTiEs

class Utils {
	public static int random_acct_number () {
		Random random = new Random();
		return random.nextInt(1000000000 - 100000000) + 100000000;

		// Java is a hot mess.
	}
}
