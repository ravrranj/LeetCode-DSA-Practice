
// 136. Single Number

public class SingleNumber {
    public int singleNumber(int[] nums) {

        int single = nums[0]; // variable to store the XOR result

        for (int i = 1; i < nums.length; i++) {
            single = single ^ nums[i]; // XOR each element
        }

        return single;
    }
}