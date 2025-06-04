import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
    
        int index = 0;
       
        for (int i = 0; i < nums.length; i++) {
            if ( index == 0 || nums[index - 1] != nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,5,6,6};

        RemoveDuplicates remover = new RemoveDuplicates();
        int newLength = remover.removeDuplicates(nums);

        System.out.println("New Length: " + newLength);
        System.out.println("Modified array : " + Arrays.toString(Arrays.copyOf(nums, newLength)));      
    }
}