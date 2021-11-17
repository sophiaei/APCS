public class maxEnd3{
  public int[] maxEnd3(int[] nums) {
    int val = Math.max(nums[0],nums[2]);
    int[] result = {val, val, val};
    return result;
  }
}
