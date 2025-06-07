
// Longest Substring with At Most K Distinct Characters

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.isEmpty()) return 0;

        int left = 0, maxLength = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window until we’re back to ≤ k distinct chars
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) freq.remove(leftChar);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the string : ");
            String s = sc.nextLine();

            System.out.print("Enter k           : ");
            int k = sc.nextInt();

            int ans = new LargestSubstringKDistinct()
                      .lengthOfLongestSubstringKDistinct(s, k);

            System.out.println("Longest substring length = " + ans);
        }
    }
}
