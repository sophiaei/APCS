public class sum28{
  public boolean sum28(int[] nums) {
    int result = 0;
    for (int num: nums) {
      if (num == 2) {
        result = result + 2;
      }
    }
    return (result == 8);
  }
}
