//Sophia Eiden, duck: Willy
//APCS
//HW09 -- What Are BigSibs Good For? / Working with multiple classes
//2021-10-01
	//refer to BigSib.java for more code
	
/* 
DISCOVERIES
class BigSib (in same dir) is referenced in here

--> class definition is linked to file name
	class ?= file
class file must begin w/ 'public' or 'private'	
 
UNRESOLVED QS
 why use multiple classes?
 is it possible to declare multiple classes on one file?
 
*/

public class Greet{
	public static void main(String [] args) {
		BigSib.greet("Flim");
		BigSib.greet("Flam");
		BigSib.greet("Kazaam");
	}	
}
