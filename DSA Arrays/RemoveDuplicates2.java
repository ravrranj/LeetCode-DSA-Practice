
// 80. Remove Duplicates from Sorted Array II (sorted array where numbers can occur 2 times but not more than 2 times)

public class RemoveDuplicates2 {
       public int removeDuplicates(int[] nums) {
            
        int i = 0; // intial index value
        for (int num : nums) {

            if ( i < 2 || num != nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;

       }
}