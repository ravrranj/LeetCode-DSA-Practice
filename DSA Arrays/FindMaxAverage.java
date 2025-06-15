

// 643. Maximum Average Subarray I

public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;  // sum of the starting window
        for (int i = 0; i < k; i++) sum += nums[i];

        int maxSum = sum;

        //Start sliding window 
        int startIndex = 0;
        int endIndex = k;
        while (endIndex < nums.length) {
            sum -= nums[startIndex] ; // remove previous elemnet
            startIndex++;

            sum += nums[endIndex]; // Add next element
            endIndex++;

            maxSum = Math.max(maxSum, sum); // max sum updated 
        }

        return (double) maxSum / k;   // return the average value 
    }

}