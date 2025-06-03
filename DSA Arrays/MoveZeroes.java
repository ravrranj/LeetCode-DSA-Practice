
// 283. Move Zeroes
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {

       int count = 0; // position to place next non-zero element
       
       // First pass: move non-zero elements to the front
       for (int i = 0; i < nums.length; i++) {
         if ( nums[i] != 0) {
            nums[count++] = nums[i];
         }
        }
 
         // Second pass: fill the rest with zeros
         while (count < nums.length) {
            nums[count++] = 0;
         }
      
    }
    public static void main(String[] args) {

        int[] nums = { 0, 1, 0, 0, 4, 14, 0, 11};
        moveZeroes(nums);

        System.out.print("Output array: ");
        for (int num : nums) {
        System.out.print(num + " ");
    }
}
}