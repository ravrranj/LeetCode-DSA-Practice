import java.util.ArrayList;
import java.util.List;

public class SubsetsGenerator {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int [] nums, List<Integer> current,List<List<Integer>> result ) {
        //Add current subset to result
        result.add(new ArrayList<>(current));

        //Try adding each element starting from 'start' index
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                    // choose
            backtrack(i + 1, nums, current, result); // explore
            current.remove(current.size() - 1);       // backtrack
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> allSubsets = subsets(nums);

        // Print the result
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}