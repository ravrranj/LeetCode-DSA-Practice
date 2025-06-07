// 3. Longest Substring Without Repeating Characters

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int left = 0;
        HashMap<Character, Integer> lastPos = new HashMap<>(); // keeps track of the last seen position of each character.

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (lastPos.containsKey(ch) && lastPos.get(ch) >= left) {
                                                                      // duplicate inside window → jump `left` forward
                left = lastPos.get(ch) + 1;
            }
            lastPos.put(ch, right);

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}