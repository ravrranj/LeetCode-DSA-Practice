
// 46. Permutations using visited as runtime per call is faster 

import java.util.ArrayList;
import java.util.List;

public class Permutations1 {
    public List<List<Integer>> permutation(int[] nums) {

        // empty arraylist to store the results
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue; // if we find the same element we skip it 

            visited[i] = true;
            current.add(nums[i]);

            backtrack(result, current, nums, visited);

            current.remove(current.size() - 1); // backtrack: remove the last element and mark as unvisited
            visited[i] = false; 
        }
    }
}