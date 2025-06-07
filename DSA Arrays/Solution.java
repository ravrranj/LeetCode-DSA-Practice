

// 3. Longest Substring Without Repeating Characters - version 2 using HashSet

import java.util.HashSet;

public class Solution{
    public int lengthOfLongestSubstring(String S) {

        int n = s.length();
        int i = 0, j = 0;
        int max = 0;

        HashSet<Character> window = new HashSet<>();

        while (j < n) {
            char ch = s.charAt(j);

            if (!window.contains(ch)) {
                window.add(ch);
                j++;                            // expand right edge

                max = Math.max(max, window.size()); 
                
            } else {

                window.remove(s.charAt(i));     // shrink left edge
                i++;
            }
        }
        return max;
    }
}

