//219. Contains Duplicate II

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int prevIndex = indexMap.get(nums[i]);
                if (Math.abs(i - prevIndex) <= k) {
                    return true;
                }
            }
            // Update the index to the latest one
            indexMap.put(nums[i], i);
        }

        return false;
    }
}