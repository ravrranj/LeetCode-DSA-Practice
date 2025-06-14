//217. Contains Duplicate

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {
    public boolean containsDuplicates (int[] nums) {

        Map<Integer, Integer> ans = new HashMap<Integer, Integer>();  // map to store the number with respective index

        for (int i = 0; i < nums.length; i++) {
            if (ans.containsKey(nums[i])) return true;    // if we find the same number , contains duplicates
            else {
                ans.put(nums[i], i);                     // if next number is not same we traverse and check other index
            }
        }
        return false;
    }
}