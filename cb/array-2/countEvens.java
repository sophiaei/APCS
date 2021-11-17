public class countEvens{
  public int countEvens(int[] nums) {
    int count = 0;
    for (int element = 0; element < nums.length; element++){
      if (nums[element]%2 == 0){
        count = count+1;
      } else {
       count = count;
      }
    } return count;
  }
}
