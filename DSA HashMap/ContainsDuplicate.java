// 217. Contains Duplicate

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public int IndexoffirstDuplicate(Int[] nums) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) 
            return i; //returning index where duplicate occurs
                else 
                {

                hm.put(nums[i], i); //storing the first occurrence index
                }
            }
        
            return -1; // no duplciate found
        }

    }
