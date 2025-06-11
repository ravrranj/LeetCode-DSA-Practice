//  347. Top K Frequent Elements

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];       // bucket array
        HashMap<Integer, Integer> frequencyMap = new HashMap<>(); // for frequency tracking 
        
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0)+ 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if(bucket[pos] != null) {
                for (Integer integer : bucket[pos]) {
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }
}