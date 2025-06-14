
// 53. Maximum Subarray

public class MaxSubarray {
    public int maxSubarray(int[] nums) {

        int maxSum = nums[0];  // max sum found so far
        int sum = 0;           // current sum of subarray

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];                // accumulate sum
            if (sum > maxSum) maxSum = sum; // update max if needed
            if (sum < 0) sum = 0;           // reset if sum goes negative
        }

        return maxSum;
    }
}