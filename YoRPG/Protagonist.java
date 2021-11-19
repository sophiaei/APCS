public class Protagonist{
  private String name;
  private int health;
  private int def;
  private int atk;

  public Protagonist(){
    name = "Bilbo";
    health = 20;

  }
  public Protagonist(String title){
    name = title;
    health = 20;

  }

  public String getName(){
    return name;
  }
  public boolean isAlive(){
    return health > 0;
  }

  public void attack(Monster smaug){
    smaug.damage(atk);
  }
  public void damage(int hit){
    health -= hit/def;
  }

  public void normalize(){
    atk = 5;
    def = 4;
  }
  public void specialize(){
    atk = 10;
    def = 2;
  }

}
