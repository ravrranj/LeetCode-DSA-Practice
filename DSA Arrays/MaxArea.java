// 11. Container With Most Water

public class MaxArea {
    public int maxArea(int[] height) {

        int maxWater = 0; // ans

        int lp = 0, rp = height.length - 1;

        while (lp < rp) {
            int w = rp - lp; // Width = distance between the lines
            int ht = Math.min(height[lp], height[rp]); // Height = shorter of the two lines
            int currWater = w * ht; // Area = width × height
            maxWater = Math.max(maxWater, currWater); //  Keep track of the max area found so far

            if (height[lp] < height[rp]) {
            lp++;
            } else {
            rp--;
            }
        }
        
        return maxWater;
    }
}