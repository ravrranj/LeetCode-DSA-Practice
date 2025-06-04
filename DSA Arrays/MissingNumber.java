
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xorNums = 0;
        int xorFull = 0;

        for (int num : nums) {
            xorNums ^= num;  // XOR all elements in nums
        }

        for (int i = 0; i <= nums.length; i++) {
            xorFull ^= i;    // XOR all numbers from 0 to n
        }

        return xorNums ^ xorFull;  // XOR of these gives missing number
    }
}