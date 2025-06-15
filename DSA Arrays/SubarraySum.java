
// 560. Subarray Sum Equals K

import java.util.HashMap;

public class SubarraySum {

public int subarraySum(int[] nums, int k) {
    //To store how many times a perfix sum has occurred 
    HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
    prefixSumCount.put(0, 1); //prefix sum 

    int currentSum = 0;
    int count = 0;

    for (int num : nums) {
        currentSum += num; // Updated current prefix sum


        // check if there is a prefix sum that if removed, would give sum = k
        if (prefixSumCount.containsKey(currentSum - k)) {
            count += prefixSumCount.get(currentSum - k);
        }

        // update the map with the current prefix sum
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0)+ 1);
    }

    return count;
}
}