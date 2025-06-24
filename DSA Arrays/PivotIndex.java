//724. Find Pivot Index

public class PivotIndex {
    public int pivotIndex(int[] nums) {

        int total = 0; //0(n)
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;

        for (int i = 0 ; i < nums.length; i++) {
            int rightSum = total - nums[i] - leftSum;
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
          
            return -1;  // if no pivot index found
        }

    }
