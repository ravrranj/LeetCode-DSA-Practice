
// 88. Merge Sorted Array

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Pointer for nums1 (valid elements)
        int j = n - 1;  // Pointer for nums2
        int k = m + n - 1;  // Pointer for final position in nums1
        
        while (j >= 0) {  // While nums2 still has elements to merge
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];  // Move larger element from nums1
            } else {
                nums1[k--] = nums2[j--];  // Move element from nums2
            }
        }
    }
}