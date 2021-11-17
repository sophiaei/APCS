public class firstLast6 {
  public boolean firstLast6(int[] nums) {
    if (nums[0] == 6){
      return true;
    }
    else if (nums[nums.length-1] == 6){
      return true;
    }
    else{
      return false;
    }
  }
}
