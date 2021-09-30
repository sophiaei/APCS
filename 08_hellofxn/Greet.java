//Sophia Eiden
//APCS
//HW08 -- Refactor Freshie Zero / rewrite Greet.java into a function call
//2021-09-30

public class Greet{
	public static void greet(String name){
		System.out.println("Good day, "+ name + ". Fare you well?");
	}

	public static void main(String [] args) {
		greet("Stan");
		greet("John");
		greet("killer of god");
	}	
}
