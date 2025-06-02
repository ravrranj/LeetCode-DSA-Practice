import java.util.HashMap;

public class TwoSumOptimized {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  // nums -> index

        // First pass: Store all values
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Second pass: Find complement
        for ( int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement)};
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}