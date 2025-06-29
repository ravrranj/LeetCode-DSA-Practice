
//303. Range Sum Query - Immutable

public class SumRange {
    int[] nums;
    public NumsArray(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++){
            nums[i] += s; // store running total directly in input array
            s = nums[i];
         }
         this.nums = nums;
    }
    public int sumRange(int left, int right) {
        if (left == 0) { return nums[right];} // sum from 0 to right
        else {return nums[right] - nums[left - 1];} // sum from left to right
    }
}