// Strawberry JAM: Melody Lew + Ollie, Sophia Eiden + Giraffe, and Josiah Moltz + Hedwig
// APCS pd06
// HW38 -- Shmoney //Spin Class / Arrays / Casino Slot Machine
// 2021-11-18
// time spent: .8 hour (45 minutes)


/*
DISCO:
0. .equals() compares the content of two objects while == compares the memory.
1. Do NOT remake your variable inside of the constructor, you will wish for the sweet release of death
  Just don't use String[]
2. Randomizing was so simmppllee that was really cool

QCC:
0. When autoboxing, does the wrapper class HAVE to be the same type as the primitive?
*/
public class Slots {

 //instance variable to represent master copy for slot machine
 private static final String[] FRUITS = {
   "lime", "lime", "lime",
   "lemon", "lemon", "lemon",
   "cherry", "cherry", "cherry",
   /*
     add extra fruits until your heart is content...
     Some suggestions:
   "orange", "orange", "orange",
   "grapefruit", "grapefruit", "grapefruit",
   "tangerine", "tangerine", "tangerine",
   "ugli", "ugli", "ugli",
   */
   "peach", "peach", "peach"
 };

 private String[] _fruits; //to be init'd by each instance


 /*=====================================
   Slots() -- default constructor
   pre:  constant array FRUITS exists, has been initialized
   post: mutable array _fruits contains same elements as FRUITS
   =====================================*/
 public Slots()
 {
   //allocate memory for _fruits based on size of FRUITS:
   _fruits = new String[FRUITS.length];

   //copy elements of FRUITS into _fruits:
   for (int i = 0; i < FRUITS.length; i++){
     _fruits[i] = FRUITS[i];
   }
 }


 /*=====================================
   String toString() -- overrides inherited toString()
   pre:
   post: returns String of elements in slots 0 thru 2, separated by tabs
   =====================================*/
 public String toString()
 {
   return _fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2];
 }


 /*=====================================
   void swap(int,int) -- array swap util fxn
   pre:  _fruits array exists
   post: elements at indices i, j are swapped
   =====================================*/
 private void swap( int i, int j )
 {
   String old = _fruits[i];
   _fruits[i] = _fruits[j];
   _fruits[j] = old;
 }


 /*=====================================
   void spinOnce() -- simulate a pull of the slot machine lever
   pre:  _fruits array exists
   post: randomized order of elements in _fruits array
   =====================================*/
 public void spinOnce()
 {
   // A simple approach to shuffling:
   // iterate through the array, swapping
   // the val at each index with a randomly chosen other index
   for(int i = 0; i<_fruits.length; i++ ){
     swap(i, (int)(Math.random() * _fruits.length));
   }
 }


 /*=====================================
   boolean jackpot() -- checks for a winning combo
   pre:  _fruits is existing array
   post: returns true if first 3 slots represent winning combo,
   false otherwise
   =====================================*/
 public boolean jackpot() {
   boolean retBoo = false;
   if ( _fruits[0].equals(_fruits[1]) && _fruits[0].equals(_fruits[2]) ) {
     retBoo = true;
   }
   return retBoo;
 }


 /*=====================================
   boolean miniWin() -- checks for a winning combo
   pre:  _fruits is existing array
   post: returns true if first 3 slots represent winning combo,
   or if first 3 slots mutually distinct,
   false otherwise
   =====================================*/
 public boolean miniWin()
 {
   boolean retBoo = false;
   if ( _fruits[0].equals(_fruits[1]) && _fruits[0].equals(_fruits[2]) ) {
     retBoo = true;
   }
   else if( !_fruits[0].equals(_fruits[1]) && !_fruits[1].equals(_fruits[2]) && !_fruits[0].equals(_fruits[2]) ) {
     retBoo = true;
   }

   return retBoo;
 }


 //main() method for testing
 public static void main( String[] args ) {
   //usage: move bar below down 1 line at a time to test functionality...


   Slots machine01 = new Slots();
   Slots machine02 = new Slots();

   /*
   System.out.println(machine01._fruits);
   System.out.println(machine02._fruits);
   */
   //test to verify slot machines function indepently
   System.out.println();
   System.out.println( "Machine01 initial state:\t" + machine01.toString() );
   System.out.println( "Machine02 initial state:\t" + machine02.toString() );
   System.out.println( "\nSpinning machine01...\n" );
   machine01.spinOnce();
   System.out.println();
   System.out.println( "Machine01 state:\t" + machine01 );
   System.out.println( "Machine02 state:\t" + machine02 );
   System.out.println();
   //test gamble-until-you-win mechanism
   System.out.println( "Preparing to spin until a mini win! . . ." );
   System.out.println( "------------------------------------" );
   //if you haven't won, spin again until you win!
   while( machine01.miniWin() == false ) {
     System.out.println( "Your spin..." + "\t" + machine01 );
     System.out.println( "LOSE\n" );
     machine01.spinOnce();
   }
   System.out.println( "====================================" );
   System.out.println( "Your spin..." + "\t" + machine01 );
   System.out.println( "WIN\n" );
   System.out.println( "Preparing to spin until...jackpot! . . ." );
   System.out.println( "------------------------------------" );
   //if you haven't won, spin again until you win!
   while( machine01.jackpot() == false ) {
     System.out.println( "Your spin..." + "\t" + machine01 );
     System.out.println( "LOSE\n" );
     machine01.spinOnce();
   }
   System.out.println( "====================================" );
   System.out.println( "Your spin..." + "\t" + machine01 );
   System.out.println( "JACKPOT!\n" );
 }//end main

}//end class Slots
