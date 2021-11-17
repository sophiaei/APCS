public class centeredAverage{
  public int centeredAverage(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int result = 0;
    for (int i : nums){
      min = Math.min(min, i);
      max = Math.max(max, i);
      result += i;
    }
    result -= min + max;
    result /= (nums.length-2);
    return result;
  }

}
