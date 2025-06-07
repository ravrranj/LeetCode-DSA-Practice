

// 🧠 "Longest Substring with Exactly K Distinct Characters"

import java.util.HashMap;

public class KdistinctSubstring {
    public int kdistinctSubstring(String s, int k) {
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int ans = -1;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            if (map.size() == k) {
                ans = Math.max(ans, right - left + 1);  
            }

            right++;
        }

        return ans;
    }
    public static void main(String[] args) {
    KdistinctSubstring sol = new KdistinctSubstring();
    System.out.println(sol.kdistinctSubstring("aabb", 2)); 
}

}
