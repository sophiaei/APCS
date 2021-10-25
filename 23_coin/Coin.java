/*
Team SN(Snooty Snickers): Nada Hameed, Sophia Eiden
APCS
HW23: What does equality look like?
2021-10-24
time spent: 37 mins (utilitarian methods completed in 30 minutes (exactly!)

DISCO:
 - objects can communicate directly to other objects via obj.var/method.
 - fun probability stuff with flip()! how to put biases into the flip.
QCC:
 - why does bias need to be a variable and not hardcoded if we are not going to manipulate it?
*/

/***
based on:
 *  class Coin
 *  by Clyde "Thluffy" Sinclair
 *  SKELETON
 ***/

public class Coin {

  //attributes aka instance vars
  double value;
  String upFace;
  String name;
  int flipCtr = 0;
  int headsCtr = 0;
  int tailsCtr = 0;
  double bias;

  /***
   *  Coin() -- default constuctor
   *  precond: n/a
   *  postcond: set upFace to "heads", value to 0, name to "null", and bias to 50/50 odds
   ***/
  public Coin() {
    value = 0;
  	upFace = "heads";
  	name = "null";
  	bias = 0.5;
  }

  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    //sets value to the value of the coin
    name = s;
    upFace = "heads";
    bias = 0.5;
  }

  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
  	upFace = nowFace;
    name = s;
    bias = 0.5;
  }

  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------

  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/

  private double assignValue( String s ) {
    name = s;
  	 if (name == "penny") {
  		value = 0.01;
  	}if (name == "nickel"){
  		value = 0.05;
  	}if (name == "dime") {
  		value = 0.1;
  	}if (name == "quarter"){
  		value = 0.25;
  	}if (name == "half dollar"){
  		value = 0.5;
  	}if (name == "dollar"){
  		value = 1.0;
  	}else{
      value = 0;
      System.out.println("invalid coin, value set to 0.");
    }
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
    value = 0;
  	upFace = "heads";
  }

  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/

  public String flip() {
    flipCtr ++ ;
    double probability = Math.random();
    System.out.println(probability);
    if (probability < 0.5){
      upFace = "heads";
      headsCtr ++;
    }
    else{
      upFace = "tails";
      tailsCtr ++;
    }
    return upFace;
  }

  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
  ***/

  public boolean equals( Coin other ) {
    if (upFace == other.upFace){
      return true;
    }
    else{
      return false;
    }
  }

  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/

  public String toString() {
    return (name +" -- " + upFace);
  }

}//end class
