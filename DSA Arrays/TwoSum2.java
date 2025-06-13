
// 167. Two Sum II - Input Array Is Sorted

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based indexing
            }

            if (sum < target) {
                left++; // Move left pointer forward
            } else {
                right--; // Move right pointer backward
            }
        }
        
        return new int[]{}; // Return an empty array if no solution found
    }
}