// 39. Combination Sum

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
        List<List<Integer>> result = new ArrayList<>();
        int startIndex = 0;
        backtrack(candidates, target, new ArrayList<>(), 0, result);
        return result;

    }
    public void backtrack(int[] candidates, int target, List<Integer> current, int startIndex,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = startIndex; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], current, i , result);
            current.remove(current.size() - 1);
        }
    }
}