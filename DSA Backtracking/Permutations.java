//46. Permutations(using if (tempList.contains(number)) continue;) -- runtime per call is slow as it checks the numver us alreay used every time

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permutate(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums); // backtracking helper method
        return result;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {
        
        // If we match the length, it is a permutation
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
         for (int number : nums) {
            
            // skip if we get the same element
            if (tempList.contains(number)) continue;

            //Add the new element
            tempList.add(number);

            //Go back to try other element
            backtrack(resultList, tempList, nums);

            //Remove the element
            tempList.remove(tempList.size() - 1);
         }
    }
}