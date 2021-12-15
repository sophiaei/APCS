// Strawberry JAM: Sophia Eiden, Melody Lew, Josiah Moltz
// APCS pd6
// HW47 -- Guess Again / "Binary" Search algorithm dictated by user / User guesses a number, and computer updates search window
// 2021-12-15
// time spent: .5 hrs

/***
QCC
0. (b-a+1) * Math.random() + a always ensures that the target is within the range.

DISCO
0. If the guess is out of bounds,
   the program says that the guess is too low/high
   regardless of the fact that we did not have a conditional that explicitly stated to do this
 ***/
import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]

    _target = (int)( (b - a + 1) * Math.random()) + a;
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo
    _guessCtr += 1;
    if (guess == _target){
      System.out.println("Correct! It took " + _guessCtr + " guesses.");
    }
    else if (guess > _target){
      System.out.println("too high :(");
      _hi = guess;
      playRec();
    }
    else {
      System.out.println("too low :(");
      _lo = guess;
      playRec();
    }
  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      //3 cases: we either found it, too hi, too lo

      if (guess == _target){
        System.out.println("Correct! It took " + _guessCtr + " guesses.");
        break;
      }
      else if (guess > _target){
        System.out.println("too high :(");
        _hi = guess;
      }
      else {
        System.out.println("too low :(");
        _lo = guess;
      }

      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    //playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {

    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);

    //start the game
    g.play();
    /*-----------------------------
    -----------------------------*/
  }

}//end class GuessNumber
