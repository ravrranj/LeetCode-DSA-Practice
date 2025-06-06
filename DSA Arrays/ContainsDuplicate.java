// LeetCode 217 - Contains Duplicate

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean ContainsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for ( int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}