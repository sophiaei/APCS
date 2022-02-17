import java.util.ArrayList;

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    boolean status = solveH(0);
    printSolution();
    return status;
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if (col >= _board.length){
      return true;
    }
    for (int i =0; i < _board.length; i++){
      if (addQueen(i,col)){
        if (solveH(col+1)) {
            return true;
        }
      }
      removeQueen(i, col);
    }
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    for (int[] row : _board) {
        for (int square : row) {
            if (square == 1) {
                System.out.print("Q ");
            }
            else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * places a queen at (row,column), and marks all the squares to the right that become attackable
   * precondition: row and column are valid array indices
   * postcondition: If the chosen square is attackable/invalid, return false
                    Else (the queen has been placed) return true
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * removes the queen at (row,column), and marks all the previously attackable squares to the right as neutral
   * precondition: row and column are valid array indices
   * postcondition: If the chosen square has no queen to remove, return false
                    Else (the queen has been removed) return true
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   *returns the board in string format
   * precondition: valid board of integer
   * postcondition: nxn board with all integer representations
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */

    b.solve();
    System.out.println();

    QueenBoard _8x8 = new QueenBoard(8);
    _8x8.solve();

    int pos = 0;
    ArrayList<String> impos = new ArrayList<String>();
    for (int i = 1; i <= 30; i++) {
        QueenBoard qb = new QueenBoard(i);
        if (qb.solvE()) {
            pos++;
        }
        else {
            impos.add(String.valueOf(i));
        }
    }
    System.out.printf("\nPossible / Total: %d/%d\n", pos, 30);
    System.out.println("Impossible for square arrays of length: " + String.join(", ", impos));
  }

  public boolean solvE() {
      return solveH(0);
  }

}//end class
