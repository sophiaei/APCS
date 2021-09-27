public class Time{
  public static void main(String[] args){
    int hour = 13;
    int minute = 05;
    int second = 55;
    int elapsed;
    final int total_seconds = 24 * 3600;
    int remaining;
    double percent;
    int current;
    int passed;

    //find seconds since midnight
    elapsed = (hour * 3600) + (minute * 60) + second;
    System.out.println( elapsed + " seconds have elapsed since midnight.");

    //remaining seconds in the day
    remaining = total_seconds - elapsed;
    System.out.println( remaining + " seconds remain in the day.");
    System.out.println(total_seconds);

    //percentage of the day left
    percent = (double)elapsed / (double)total_seconds;
    System.out.println(percent);

    // update time
    hour = 13;
    minute = 18;
    second = 20;

    //find time worked on the exercise
    current = (hour * 3600) + (minute * 60) + second;
    passed = current - elapsed;
    System.out.println("I have worked on this exercise for " + passed + " seconds.");

  }
}
