# DSA HashMap-Based Solutions :


🧠 Contains Duplicate — README
📌 Problem:
Check if any value appears at least twice in the array nums.

💡 Approach:
We use a HashSet because it automatically handles duplicate detection for us — it only stores unique values.

Initialize a HashSet.

Traverse the array using a loop.

For each number:

If it already exists in the set → return true (duplicate found).

Otherwise, add it to the set.

After the loop, if no duplicates were found → return false.

🔁 Time & Space Complexity:
Time: O(n) — we visit each element once.

Space: O(n) — in the worst case, all elements are unique and stored in the HashSet.

🔥 Code snippet :

public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (seen.contains(num)) return true;
        seen.add(num);
    }
    return false;
}

🎤 In an Interview (Spoken Summary):
"To detect duplicates, I use a HashSet which helps me check for previously seen elements in constant time. As I loop through the array, I return true as soon as I find a duplicate. If the loop ends, I return false. This approach takes O(n) time and O(n) space."

🧠 Valid Anagram – Two Approaches

Problem Statement
Given two strings s and t, determine if t is an anagram of s.
An anagram is a word formed by rearranging the letters of another word, using all original characters exactly once.

Approach 1: Using an Array (Optimal for Lowercase English Letters)
Java Implementation

ppublic class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;  

        int[] arr = new int[26]; // Fixed array for 'a' to 'z'

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;  // Increment frequency
        }

        for (int i = 0; i < s.length(); i++) {
            arr[t.charAt(i) - 'a']--;  // Decrement frequency

            if (arr[t.charAt(i) - 'a'] < 0) return false;  // If `t` has extra chars
        }

        return true;
    }
}

Time & Space Complexity
✅ Time Complexity: O(n) → Each character is processed once, making it efficient.
✅ Space Complexity: O(1) → Uses a fixed-size array (26 elements), which is independent of input size.
When to Use This Approach?
✔ Best for lowercase English letters (a-z).
✔ Consumes minimal space (O(1)) since it uses a fixed array.
❌ Not suitable for Unicode characters or mixed case input.

Approach 2: Using a HashMap (Handles Unicode & Mixed Case)
Java Implementation

import java.util.HashMap;

public class IsAnagramMethod2 {
    public boolean isAnagramMethod2(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);  // Store character frequency
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;  // If `t` has an extra character

            map.put(c, map.get(c) - 1); // Reduce frequency
            if (map.get(c) < 0) return false; // If `t` has more occurrences than `s`
        }

        return true;
    }
}

Time & Space Complexity
✅ Time Complexity: O(n) → Each character is processed once.
✅ Space Complexity: O(n) → Uses extra space for HashMap, depending on input size.
When to Use This Approach?
✔ Works for Unicode characters (e.g., Chinese, Arabic, emojis, etc.).
✔ Handles mixed case characters (A-Z, a-z) correctly.
✔ Ideal when input size varies.
❌ Consumes more space (O(n)) due to HashMap storage.

Final Comparison
| Approach | Handles Only 'a-z'? | Supports Unicode? | Space Complexity | Time Complexity | 
| Array (int[26]) | ✅ Yes | ❌ No | O(1) | O(n) | 
| HashMap (HashMap<Character, Integer>) | ✅ Yes | ✅ Yes | O(n) | O(n) | 

Which Method Should You Use?
- Use the int[26] array version if the problem explicitly states lowercase English letters (a-z).
- Use the HashMap<Character, Integer> approach if you need support for Unicode, mixed case, or special characters.

Final Thoughts
Both methods are efficient in O(n) time, but choosing the right one depends on space trade-offs and character set requirements. If you're preparing for interviews, mentioning both approaches shows flexibility and deeper understanding! 🚀

This README should make your GitHub repo stand out and impress interviewers! Want me to tweak anything or add examples? 😊


