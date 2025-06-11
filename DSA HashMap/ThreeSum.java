// Brute force appraoch for 15. 3Sumss

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum (Int[] nums) {
        
         // Use a Set of strings (or lists) to deduplicate triplets.
        // Each string will be the sorted triplet, e.g. "-1,0,1"
        Set<String> seen = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {s
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] trip = { nums[i], nums[j], nums[k] };
                        Arrays.sort(trip);                 // canonical order
                        String key = trip[0] + "," + trip[1] + "," + trip[2];
                        if (seen.add(key)) {               // adds & returns true if new
                            ans.add(Arrays.asList(trip[0], trip[1], trip[2]));
                        }
                    }
                }
            }
        }
        return ans;

    }
}