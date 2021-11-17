public class sum67 {
  public int sum67(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++){
      if (nums[i] == 6){
        while (i < nums.length-1 && nums[i] != 7){
          i ++;
        }
      }
      else{
        sum += nums[i];
      }
    }
    return sum;
  }
}
