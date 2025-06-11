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

## Using HashMap : 

To detect duplicates efficiently, we use a HashMap because it offers constant-time lookups.

🔸 Why HashMap?
Maps allow us to store key-value pairs.

For this problem, the key is the number, and the value is its index (or any dummy value, really — we only care about the key for existence check).

🧠 Step-by-Step Logic:
We initialize a HashMap<Integer, Integer> called hm.

We iterate over the array using a loop from index 0 to nums.length - 1.

For each number:

We check if it's already present in the hashmap using containsKey(nums[i]).

If it is present, that means we’ve seen it before → return true (duplicate found).

If it is not present, we add it to the map using put(nums[i], i).

If the loop finishes without returning, that means all elements were unique → return false.

✅ Java Code

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(Integer[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                return true;
            } else {
                hm.put(nums[i], i);
            }
        }

        return false;
    }
}

🧪 Example Dry Run:
Input:
nums = [1, 2, 3, 1]

Steps:
i = 0: 1 not in map → add it

i = 1: 2 not in map → add it

i = 2: 3 not in map → add it

i = 3: 1 already in map → return true

⏱️ Time & Space Complexity:
Time: O(n) — Single pass through array

Space: O(n) — In worst case, all elements are unique and go into the map



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


# 387. First Unique Character in a String

We solve it two ways:

### ✅ 1. Array-Based (O(1) space)

1. **Edge case** – if `s` is empty, return `-1`.
2. **Count** – use an `int[] freq = new int[26]`; for each `ch`, do `freq[ch - 'a']++`.
3. **Scan again** – first `i` where `freq[ch - 'a'] == 1` → return `i`.

```java
int[] freq = new int[26];
for (char c : s.toCharArray()) freq[c - 'a']++;
for (int i = 0; i < s.length(); i++)
    if (freq[s.charAt(i) - 'a'] == 1) return i;
return -1;


Time O(n) | Space O(1) — only 26 slots.

✅ 2.  HashMap (O(n) space)

1. **Edge case** – empty string → -1.
2. **Count** – Map<Character,Integer> freq.
3. **Scan** – first index where freq.get(c) == 1 → return it.

Map<Character,Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) freq.merge(c,1,Integer::sum);
for (int i = 0; i < s.length(); i++)
    if (freq.get(s.charAt(i)) == 1) return i;
return -1;

Handles Unicode / mixed case. Time O(n) | Space O(n).

Which to choose?
Array* is ultra-fast and constant space if input is only 'a'…'z'.
HashMap* trades space for flexibility when character set is larger.

⛅✅ Question: 350. Intersection of Two Arrays II (Easy)
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays, and you may return the result in any order.
sss

🔊 Interview-style Explanation:
We are given two arrays, nums1 and nums2, and we need to find the intersection, meaning elements that appear in both arrays, including duplicates — only as many times as they appear in both.

To optimize, I first determine which array is shorter — since that will reduce our space usage. I then use a HashMap to count the frequency of each element in the shorter array.

Next, I iterate over the second array and for each element, I check the frequency in the map. If it's greater than 0, that means it's a valid intersection — so I add it to the result and decrement the frequency in the map.

Finally, I convert the result list into an array and return it.

📊 Time & Space Complexity:
Time Complexity: O(m + n)
We traverse both arrays once — first to build the map and second to check for intersections.

Space Complexity: O(min(m, n))
Since we store frequencies only for the shorter array.

🧠 Pro-Level Insight (Optional If Asked):
We pick the shorter array for frequency mapping to minimize space and slightly improve performance in large datasets. Also, using getOrDefault() and List helps keep the code clean and readable.
This method ensures a clean, efficient intersection computation with minimal space usage while maintaining duplicates correctly. HashMap allows constant-time lookups, making it ideal for handling large arrays where direct comparison would be inefficient.


## 347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


Step 1: Count Frequencies
First, I use a HashMap<Integer, Integer> to count how many times each number appears in the array.

Step 2: Bucket the Numbers by Frequency
I create a bucket array List<Integer>[], where the index represents the frequency.
So for example, if the number 3 appears 2 times, I’ll put it in bucket[2].

Step 3: Collect Top K Elements
I start from the end of the bucket (which holds the numbers with the highest frequency) and gather numbers until I have exactly k of them.

⏱️ Time Complexity:

Building frequency map: O(n)

Filling buckets: O(n)

Collecting top k: O(n)

Total = O(n)

📦 Space Complexity:

HashMap → O(n)

Bucket array → O(n)

🎯 Why this approach?
This approach avoids using a PriorityQueue (heap), so it’s more efficient when there are lots of duplicate elements. It’s also cleaner and avoids extra sorting.

