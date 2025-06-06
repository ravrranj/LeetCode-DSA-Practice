
// 238. Product of Array Except Self

public class ProductExceptSelf {
    public int [] productExceptself(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];
        
        answer[0] = 1;

        // prefix calculation
        
        for ( int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // finding suffix and then we will multiply with the prefix

        int suffix = 1;
        for ( int i = n -1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i]; 
        }
    return answer;
    }
}