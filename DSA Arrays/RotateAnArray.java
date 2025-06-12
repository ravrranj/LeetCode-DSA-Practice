//189. Rotate Array

public class RotateAnArray {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k%n; //Handle cases where k > n

        reverse(nums, 0,n-1);  // rotate the whole array
        reverse(nums, 0, k-1); // rotate the first K elements
        reverse(nums, k, n -1); // rotate the rest of the elements

    }

    public static void reverse(int[] nums, int start, int end) {

        while (start<= end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp; 
            start++;
            end--;

        }
    }
}