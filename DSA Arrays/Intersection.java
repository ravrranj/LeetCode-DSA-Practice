
// 349. Intersection of Two Arrays
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection (int[] nums1, int[] nums2) {
    
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add elements of num1 to set1
        for (int nums : nums1) {
            set1.add(nums);
        }

        // Check which elements in nums2 exist in set1
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        // converting the result set to array
        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }
}