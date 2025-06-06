//1752. Check if Array Is Sorted and Rotated

public class CheckSortedAndRotated {
    public boolean check(int[] nums) {
       
    int count = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        int next = (i + 1) % n;
        if (nums[i] > nums[next]) {
            count++;
        }
    }

    return count <= 1;
    }
}