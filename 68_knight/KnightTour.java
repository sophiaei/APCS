<<<<<<< HEAD
// Submarine Cable History: Jing Yi Feng, Sophia Eiden, David Deng
// APCS pd6
// HW68 -- ...and T-, Tr-, Tri-, Tries Again Until It's Done
// 2022-03-02w
// time spent: 0.5 hrs
=======
// Clyde Sinclair
// APCS pd0
// HW68 -- recursively probing for a closed cycle
// 2022-02-28m
// time spent:  hrs
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
<<<<<<< HEAD
 * Base Case: Tour has been completed if all squares are nonzero.
 * Check whether current position of knight is valid.
 * If so, move onto next position
 * Else, backtrack.
 * If backtrack is at initial position, tour is not possible.
 *
 * DISCO
 * Command line arguments are given in an array of Strings. Can read them as we would for any other array by calling index of position.
 * QCC
 * Is there another way to approach this problem?
 *
 * Mean execution times for boards of size n*n:
 * n=5   4.57s    across 5 executions
=======
 *
 * DISCO
 *
 * QCC
 *
 * Mean execution times for boards of size n*n:
 * n=5   __s    across __ executions
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a
 * n=6   __s    across __ executions
 * n=7   __s    across __ executions
 * n=8   __s    across __ executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
<<<<<<< HEAD
    int startX = (int) (Math.random() * n);
    int startY = (int) (Math.random() * n);
    tf.findTour( startX, startY, 1 );   // 1 or 0 ?
=======
    //int startX = //YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    //int startY = //YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    //tf.findTour( startX, startY, 1 );   // 1 or 0 ?
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
<<<<<<< HEAD
    for (int i = 2; i < n + 2; i++) {
        for (int j = 2; j < n + 2; j++) {
            tf.findTour(i, j, 1);
        }
    }
=======
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
<<<<<<< HEAD
    _board = new int[_sideLength + 4][_sideLength + 4];
=======
    _board = new int[n+4][n+4];
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
<<<<<<< HEAD
    for (int i = 0; i < _board.length; i++) {
        for (int j = 0; j < _board.length; j++) {
            if (i == 0 || i == 1 || i == _board.length - 2 || i == _board.length - 1 ||
                j == 0 || j == 1 || j == _board.length - 2 || j == _board.length - 1) {
                _board[i][j] = -1;
            }
            else {
                _board[i][j] = 0;
            }
        }
=======
    for (int i = 0; i < n+4; i++){
      for (int j = 0; j< n+4; j++){
        if ((j == 0 || j == 1 || j == n+2 || j == n+3) &&
          (i == 0 || i == 1 || i == n+2 || i == n+3)){
          _board[i][j] = -1;
        }
        else{
          _board[i][j] = 0;
        }
      }
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a
    }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
<<<<<<< HEAD
    if ( _solved ) System.exit(0);

    //primary base case: tour completed
    if ( moves == _sideLength * _sideLength + 1) {
      _solved = true;
=======
    if ( ??? ) System.exit(0);

    //primary base case: tour completed
    if ( ??? ) {
      ???
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
<<<<<<< HEAD
    if (_board[x][y] != 0 ) {
=======
    if ( ??? ) {
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
<<<<<<< HEAD
      _board[x][y] = moves;
=======
      _board[x][y] = ???
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
<<<<<<< HEAD
      findTour(x + 1, y + 2, moves + 1); // a
      findTour(x + 2, y + 1, moves + 1); // b
      findTour(x + 2, y - 1, moves + 1); // c
      findTour(x + 1, y - 2, moves + 1); // d
      findTour(x - 1, y - 2, moves + 1); // e
      findTour(x - 2, y - 1, moves + 1); // f
      findTour(x - 2, y + 1, moves + 1); // g
      findTour(x - 1, y + 2, moves + 1); // h

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
        _board[x][y] = 0;
=======
      ???

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
        ???
>>>>>>> e0e7ba2ac060cd11f24f6ee5d3ffad746b66fa4a

      System.out.println( this ); //refresh screen
    }
  }//end findTour()

}//end class TourFinder
