public class Protagonist{
  private String name;
  private int health;
  private int def;
  private int atk;
  private double accuracy;

  /*=============================================
    constructor Protagonist() -- sets everything up
    pre: String title, ints health atk def, double accuracy
    post: sets name heatlh atk def and accuracy to the appropriate values
    =============================================*/
  public Protagonist() {
    name = "Bilbo";
    health = 20;
    atk = 5;
    def = 4;
    accuracy = 0.75;
  }

  /*=============================================
    constructor Protagonist( String title ) -- sets everything up
    pre: String title, ints health atk def, double accuracy
    post: sets name to title, and sets heatlh atk def and accuracy to the appropriate values
    =============================================*/
  public Protagonist( String title) {
    name = title;
    health = 20;
    atk = 5;
    def = 4;
    accuracy = 0.75;
  }

  /*=============================================
    int getName() -- returns players name
    pre:  name is an initialized String
    post: returns players name
    =============================================*/
  public String getName() {
    return name;
  }

  /*=============================================
    int getHealth() -- returns players health
    pre:  health is an initialized int
    post: returns players health
    =============================================*/
  public int getHealth() {
    return health;
  }

  /*=============================================
    boolean isAlive() -- returns true if player is alive, and false otherwise
    pre:  health is an initialized int
    post: if the player has remaining health return true, return false otherwise
    =============================================*/
  public boolean isAlive(){
    return health > 0;
  }

  /*=============================================
    int attack(Class smaug) -- damages the opponent
    pre: Class smaug has damage and ouch methods
    post: returns and reduces smaug's health by the appropriate manner
    =============================================*/
  public int attack(Monster smaug) {
    int turnAtk = atk * hitOrMiss();
    smaug.damage( turnAtk );
    return smaug.ouch( turnAtk );
  }

  /*=============================================
    int ouch(int hit) -- returns damage incurred from a hit
    pre: hit and def are initialized ints
    post: returns hit / def
    =============================================*/
  public int ouch(int hit) {
    return hit / def;
  }

  /*=============================================
    void damage(int hit) -- applies the damage incurred from a hit
    pre:  health is an int
    post: subtracts the appropriate damage from health
    =============================================*/
  public void damage(int hit){
    health -= ouch( hit );
  }

  /*=============================================
    void normalize() -- updates atk and def for a normal attack
    pre: atk and def are ints
    post: resets atk and def to standard values for a normal attack
    =============================================*/
  public void normalize(){
    atk = 5;
    def = 4;
  }

  /*=============================================
    void specialize() -- updates atk and def for a special attack
    pre:  atk and def are ints
    post: updates atk to a randomly higher value, and lowers def
    =============================================*/
  public void specialize() {
    atk = (int) ( luck() * 10 ) + 1;  //feeling lucky?
    def = 2;
  }

  /*=============================================
    int hitOrMiss() -- determines whether a hit lands or not
    pre:  accuracy is an initialized double
    post: returns 1 with probability accuracy, and 0 with probability 1-accuracy
    =============================================*/
  public int hitOrMiss() {
    if ( Math.random() <= accuracy ) {
      return 1;
    }
    else {
      return 0;
    }
  }

  /*=============================================
    double luck() -- returns how luck you are
    pre:
    post: returns a double corresponding to how much your specialized attack damage is boosted
    =============================================*/
  public double luck() {
    double luckocity = 4 * Math.random();
    if (luckocity > 2) {
      luckocity = 2;  //ensures you can't quadruple your atk, no matter how well you think you can spinning thuner kick
    }
    return luckocity;
  }

}
