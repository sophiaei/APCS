public class bigDiff{
  public int bigDiff(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    for ( int i : nums){
      if (i > max){
        max = i;
      }
      else if (i < min){
        min = i;
      }
    }
    return max - min;
  }

}
