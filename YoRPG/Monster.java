public class Monster{
  private int health;
  private int def;
  private int atk;
  private double accuracy;

  /*=============================================
    constructor Protagonist( int difficulty ) -- sets everything up
    pre: ints health atk def, double accuracy are all set up
    post: sets heatlh atk def and accuracy to the appropriate values
    =============================================*/
  public Monster() {
    health = 30;
    def = 5;
    atk = 4;
    accuracy = 0.4;
  }

  /*=============================================
    constructor Protagonist( int difficulty ) -- sets everything up
    pre: ints health atk def, double accuracy are all set up according to how difficult the play wishes it to be
    post: sets heatlh atk def and accuracy to the appropriate values
    =============================================*/
  public Monster(int difficulty) {
    health = 30;
    def = 5;
    atk = 4;
    accuracy = 0.4;
    if (difficulty == 1) {
      //foo easy
    }
    if (difficulty == 2) {
      //foo medium
    }
    if (difficulty == 3) {
      //foo hard
    }
  }

  /*=============================================
    int getHealth() -- returns monsters health
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
    int attack(Class pat) -- damages the opponent
    pre: Class pat has damage and ouch methods
    post: returns and reduces smaug's health by the appropriate manner
    =============================================*/
  public int attack(Protagonist pat){
    int turnAtk = atk * hitOrMiss();
    pat.damage(turnAtk);
    return pat.ouch(turnAtk);
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
  public void damage(int hit) {
    health -= ouch( hit );
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

}
