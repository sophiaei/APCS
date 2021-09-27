public class Date{
  public static void main(String[] args){
    
    String day = "Sunday";
    //System.out.println("The day is " + day);
    int date = 22;
    //System.out.println("The date is " + date);
    String month = "August";
    //System.out.println("The month is " + month);
    int year = 2021;
    //System.out.println("The year is " + year);
    System.out.println("American format:");
    System.out.println(day + ", " + month +" "+ date + ", " + year);
    System.out.println("European format:");
    System.out.println(day + ' ' + date + " " + month + " "+ year);

  }
}
