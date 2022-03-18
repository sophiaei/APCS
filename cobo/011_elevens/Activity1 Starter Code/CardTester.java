/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card queenofhearts = new Card("Queen", "Hearts", 12);
		System.out.println(queenofhearts.rank());
		System.out.println(queenofhearts.suit());
		System.out.println(queenofhearts.pointValue());
		System.out.println(queenofhearts);

		Card matchy = new Card("Queen", "Spades", 12);

		System.out.println(queenofhearts.matches(matchy));
	}
}
