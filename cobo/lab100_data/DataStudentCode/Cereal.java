
public class Cereal{
  public String name;
  public char type;
  public int calories, protein, fats,sodium, fiber, carbs, sugar, potassium, vitamins, shelf;
  public double cups, weight, rating;

public Cereal(String Name, char Type, int Calories, int Protein, int Fats, int Sodium, int Fiber, int Carbs, int Sugar, int Potassium, int Vitamins, int Shelf, double Weight, double Cups, double Rating){
  name=Name;
  type=Type;
  calories=Calories;
  protein=Protein;
  fats=Fats;
  sodium=Sodium;
  fiber=Fiber;
  carbs=Carbs;
  sugar=Sugar;
  potassium=Potassium;
  vitamins=Vitamins;
  shelf=Shelf;
  weight=Weight;
  cups=Cups;
  rating=Rating;
}
  public String getName(){
    return name;
  }
  public int getCalories(){
    return calories;
  }
  public char getType(){
    return type;
  }
  public int getCarbs(){
    return carbs;
  }
  public int getProtein(){
    return protein;
  }
  public int getFats(){
    return fats;
  }
  public int getSodium(){
    return sodium;
  }
  public int getFiber(){
    return fiber;
  }
  public int getSugar(){
    return sugar;
  }
  public int getPotassium(){
    return potassium;
  }
  public int getVitamins(){
    return vitamins;
  }
  public int getShelf(){
    return shelf;
  }
  public double getRating(){
    return rating;
  }
  public double getWeight(){
    return weight;
  }
  public double getCups(){
    return cups;
  }
  // TOSTRING? Acessors
  public String toString() {
    String retString = "";
    retString = "\n\n name: "  + this.getName() + "; \n" + "type: "  + this.getType() + "; \n" + "cals: "  + this.getCalories() + "; \n" + "protein: "  + this.getProtein() + "; \n" + "fat: "  + this.getFats() + "; \n" + "sodium: "  + this.getSodium() + "; \n" + "fiber: "  + this.getFiber() + "; \n" + "carbs: "  + this.getCarbs() + "; \n" + "sugar: "  + sugar + "; \n" + "potassium: "  + potassium + "; \n" + "shelf: "  + shelf + "; \n" + "weight: "  + weight + "; \n" + "cups: "  + cups + "; \n" + "rating: "  +rating + ";";
    return retString;
  }
  //

  public static void main(String[] args){
    Cereal CornPops= new Cereal("Corn Pops", 'C', 110,1,0,90,1,13,12,20,25,2,1,1,35.782791);
    Cereal Cheerios= new Cereal("Cheerios", 'C',11,6,2,290,2,17,1,105,25,1,1,1.25,50.76499);
    Cereal CornFlakes= new Cereal("Corn Flakes",'C',100,2,0,290,1,21,2,35,25,2,1,1,22.396513);
    System.out.println(CornPops);
    System.out.println(Cheerios);
  }
}
