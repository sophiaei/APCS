public class Monster{


  public boolean isAlive(){
    return health > 0;
  }

  public void attack(Protagonist pat){
    pat.damage(atk);
  }


  public void damage(int hit){
    health -= hit/def;
  }

}
