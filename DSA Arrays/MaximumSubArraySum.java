
// 📄 Problem: 2461. Maximum Sum of Distinct Subarrays With Length K

import java.util.HashSet;
import java.util.Set;

public class MaximumSubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();

        long sum = 0, max = 0;

        int window = 0;

        for(int  i = 0 ; i < nums.length ; i++)
        {
            while(set.contains(nums[i]) || set.size() == k)
            {
                set.remove(nums[window]);
                sum -= nums[window++];
            }

            sum += nums[i];
            set.add(nums[i]);

        // If all elements in the window are distinct, update maxSum

            if(set.size() == k)
            {
                max = Math.max(max , sum);
            }
        }

        return max;       
    }
}