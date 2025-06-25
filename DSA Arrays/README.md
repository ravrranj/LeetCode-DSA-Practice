# LeetCode DSA Practice (Arrays)

---

## Two Sum

### Problem Statement  
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

### Conditions  
- Each input has exactly one solution.  
- You may not use the same element twice.  
- You can return the answer in any order.

### Approach (Brute Force)  
- Use two nested loops with indices `i` and `j`.  
- Check every pair `(nums[i], nums[j])` to see if their sum equals `target`.  
- Return the indices once the matching pair is found.  
- Edge case: Check if the array is empty.

### Code Snippet

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] { i, j };
            }
        }
    }
    return new int[] {};  // Return empty if no solution found
}

Complexity
-Time Complexity: O(n²) — due to the nested loops checking every pair.

-Space Complexity: O(1) — only variables for indices used, no extra data structures.


## Valid Parentheses

Problem Statement
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Conditions
Open brackets must be closed by the same type of brackets.

Open brackets must be closed in the correct order.

Every close bracket has a corresponding open bracket of the same type.

Approach (Using Stack)
Use a stack to store opening brackets.

Iterate over each character in the string:

If it's an opening bracket, push it to the stack.

If it's a closing bracket, check if the top of the stack is the matching opening bracket.

If not matching or stack is empty, return false.

If stack is empty at the end, the string is valid.

Code Snippet : 

public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(') stack.push(')');
        else if (c == '{') stack.push('}');
        else if (c == '[') stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c) return false;
    }
    return stack.isEmpty();
}

Complexity
Time Complexity: O(n) — single pass through the string.

Space Complexity: O(n) — stack may store all opening brackets in the worst case.

🧠 Two Sum - Optimized using HashMap
✅ Problem Statement:
Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

🛠️ Optimized Approach (Single-Pass HashMap)
We traverse the array only once, storing elements in a HashMap as we go.
For each element nums[i], we calculate the complement as target - nums[i] and check if it's already present in the map.

If found, we return the indices of the complement and the current number.

✅ Java Code:

import java.util.HashMap;

public class TwoSumOptimized {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

⏱️ Time & Space Complexity:

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(n)  |

💡 Why is this optimal?

We use a single loop (single-pass) to do both the lookup and the storage.

For every element, we immediately check if its complement is already stored in the map.

If it is, we’ve found our solution instantly without needing a second loop.

This avoids unnecessary comparisons and improves performance significantly over the brute-force O(n^2) solution.

🔍 Comparison with Brute-Force:

| Approach         | Time  | Space | Description                                      |
| ---------------- | ----- | ----- | ------------------------------------------------ |
| Brute-Force      | O(n²) | O(1)  | Check all pairs using nested loops               |
| HashMap (1-pass) | O(n)  | O(n)  | Store and check complement in a single traversal |

🔄 Key Insight:
We’re not just storing values—we’re preparing for future lookups while iterating forward. That’s what makes it fast and elegant.

🔁 Alternative: Two-Pass HashMap Approach
🧠 Idea:
We split the problem into two separate loops:

First, store all values and their indices into the map.

Second, check for the required complement.

This approach makes the logic very clear but slightly less efficient compared to single-pass.

✅ Code:

HashMap<Integer, Integer> map = new HashMap<>();

// First pass: store all values
for (int i = 0; i < nums.length; i++) {
    map.put(nums[i], i);
}

// Second pass: look for complement
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
    }
}

🧪 Complexity:
| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(n)  |

🧩 When to Use:
Great for learning the problem step-by-step.

Useful when readability and debugging clarity is more important than peak performance.

In interviews, showing both versions proves your understanding and flexibility.

🔍 Summary:

| Approach    | Loops | Time | When to Use                                 |
| ----------- | ----- | ---- | ------------------------------------------- |
| Two-pass    | 2     | O(n) | Clear separation of storing and checking    |
| Single-pass | 1     | O(n) | More efficient, real-world optimal solution |


🧠 Valid Parentheses – Optimized Using Stack
✅ Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[', and ']', determine if the input string is valid.

A string is valid if:

Open brackets must be closed by the same type of brackets.

Open brackets must be closed in the correct order.

🧠 Optimized Approach (Using Stack)
We use a Stack to keep track of opening brackets.
For every closing bracket, we check:

If the stack is empty → ❌ invalid

If the top of the stack doesn’t match the corresponding opening bracket → ❌ invalid

✅ Java Code:

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();  // Must be empty at the end
    }
}

⏱️ Time & Space Complexity:

| Metric | Value        |
| ------ | ------------ |
| Time   | O(n)         |
| Space  | O(n) (stack) |

💡 Why This Works:

Stack maintains the order of opening brackets.

When a closing bracket appears, the top of the stack must match it.

If the stack is empty or mismatched, it’s invalid.

If the stack is empty at the end, it’s valid.

🔍 Edge Cases:

| Case            | Example    | Valid? |
| --------------- | ---------- | ------ |
| Empty string    | `""`       | ✅ Yes  |
| Only open       | `"((("`    | ❌ No   |
| Only close      | `"))"`     | ❌ No   |
| Nested properly | `"{[()]}"` | ✅ Yes  |
| Wrong order     | `"(]"`     | ❌ No   |

💡 Why Stack?

We push every opening bracket into the stack.

When a closing bracket comes, we pop from the stack and check if it matches.

If the stack is empty too early or if the popped element doesn't match → ❌ Not valid.

🔍 Summary of Key Checks:

| Condition                    | Meaning              |
| ---------------------------- | -------------------- |
| `stack.isEmpty()` before pop | Closing without open |
| `stack.pop() != expected`    | Wrong closing order  |
| `stack.isEmpty()` after loop | All brackets matched |

🧪 Examples:

| Input      | Output | Explanation                 |
| ---------- | ------ | --------------------------- |
| `"()"`     | true   | Properly matched            |
| `"()[]{}"` | true   | All matched                 |
| `"(]"`     | false  | Wrong type of closing       |
| `"([)]"`   | false  | Correct types, wrong order  |
| `"{[]}"`   | true   | Nested and matched properly |


🧠 Key Insight:
Using a stack lets us track the most recent open bracket and ensures that it matches with the correct closing bracket. If anything is mismatched or out of order, the check fails immediately.

## Problem: Best Time to Buy and Sell Stock

Problem statement : You are given an array prices where prices[i] is the price of a given stock on the ith day.You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

### ✅ Approach:
- Use a greedy strategy.
- Track the minimum price seen so far (`minPrice`).
- At each price, calculate profit if sold today: `price - minPrice`.
- Update `maxProfit` accordingly.

### 🔍 Example:
Input: [7, 1, 5, 3, 8, 4]  
- minPrice goes from 7 → 1  
- maxProfit updates as: 0 → 4 → 7

Output: `7`

### ⏱️ Complexity:
- **Time:** O(n)
- **Space:** O(1)

### ✅ Java Code:
```java

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 8, 4};
        System.out.println("Max Profit: " + maxProfit(price));
    }
}

## Move Zeroes

🔍 Problem Statement:
Move all 0s to the end of the array while maintaining the relative order of non-zero elements. Do this in-place with O(1) extra space.

💡 Approach:
We avoid overthinking the phrase "move all 0's to the end." Instead, we focus on pulling all the non-zero elements to the front while tracking their position.

Here's how we do it:

Create a pointer count starting at index 0.

Iterate through the array:

If the current element is non-zero, we place it at index count and increment count.

Once all non-zero elements are in place, fill the remaining positions (from count to nums.length - 1) with 0s.

This way:

Non-zero elements are preserved in order.

Zeroes are pushed to the end.

The entire operation is in-place with a single traversal + zero-fill.

🧠 Intuition:
We're not actually "pushing zeroes" — we're pulling non-zeroes forward, and the leftover space automatically becomes the home for 0s.

✅ Example:
Input: [0, 1, 0, 4, 0, 11]
Output: [1, 4, 11, 0, 0, 0]

✨ Optional Interviewer Line:
"I used a greedy two-pass approach to move non-zero elements forward and fill the rest with 0s. It’s clean, in-place, and maintains relative order."

🧠 Problem: Intersection of Two Arrays
##  LeetCode 349 – Easy

🔍 Problem Statement
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique, and you may return the result in any order.

✅ Approach: Using HashSet
We use two HashSets:

One (set1) to store all elements of nums1.

Another (resultSet) to store the intersection (common elements) between nums1 and nums2.

💡 Logic:

1.  Traverse through nums1 and add each element to set1.

2.  Loop through nums2, and for each element:

3.  Check if it exists in set1.

If it does, add it to resultSet.
Since Set automatically removes duplicates, we don’t need to handle that manually.

Convert resultSet to an array using:

resultSet.stream().mapToInt(Integer::intValue).toArray();

This step converts the set of Integer objects to a primitive int[] array.


## LeetCode 26 – Easy

📌 Problem Statement:
Given a sorted array nums, remove the duplicates in-place such that each unique element appears only once.
Return the number of unique elements.
Do not use extra memory.

In this problem, we are asked to make sure that each unique element appears only once in the array.

What we’re doing:

We start from index = 0

For each element in the array, we check:

If it's the first element or

If the current number is not equal to the last unique number we added (nums[index - 1] != nums[i])

If the condition is true, we place the unique element at nums[index] and increment index to move ahead

We repeat this till the end of the array

Since the problem also asks for the value k (number of unique elements), we return the final value of index

🧠 Code:

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index == 0 || nums[index - 1] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

🧪 Example:
Input: [1, 1, 2, 3, 3]
Output: 3
Modified Array: [1, 2, 3, _, _]

🧠 problem statemnet : Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
## 268. Missing Number

Finding the Missing Number Using XOR
We are given an array of n numbers ranging from 0 to n, but one number is missing. Our goal is to identify it efficiently.
Approach: XOR Trick
- Compute XOR of all numbers in the array (xorNums).
- Compute XOR of numbers from 0 to n (xorFull).
- Due to XOR properties, duplicate values cancel out: a ^ a = 0.
- The final result xorFull ^ xorNums gives the missing number since it's the only one that wasn’t paired.
Time & Space Complexity
✅ Time Complexity: ( O(n) )
✅ Space Complexity: ( O(1) )
This method ensures constant space usage and runs in linear time, making it a smart choice for missing-number detection!

Step-by-Step Execution
Let's say nums = {0, 1, 3} (where 2 is missing):
- XOR all numbers in the array → 0 ^ 1 ^ 3
- XOR all numbers from 0 to n (including the missing number) → 0 ^ 1 ^ 2 ^ 3
- Everything cancels out except the missing number → 2 remains!

🧠 Problem: Palindrome Number (LeetCode 9)

### 🧾 Problem Statement:
Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

A palindrome is a number that reads the same backward as forward.

---

### ✅ Approach 1: Convert to String
- Convert the number to a string.
- Reverse it and compare with the original.

### ✅ Approach 2: Reverse Half of the Number
- Skip using extra space or string conversion.
- Reverse digits until reversed ≥ x, then compare the halves.

---

### 🧠 Key Checks:
- Negative numbers → ❌ Not palindromes
- Numbers ending with `0` but not `0` itself → ❌ Not palindromes

---

### ✅ Java Code (Optimized):

```java
public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;

    int reversed = 0;
    while (x > reversed) {
        reversed = reversed * 10 + x % 10;
        x /= 10;
    }

    return x == reversed || x == reversed / 10;
}

🕒 Complexity:

| Metric | Value     |
| ------ | --------- |
| Time   | O(log₁₀n) |
| Space  | O(1)      |

🧩 Examples:

| Input | Output | Reason                     |
| ----- | ------ | -------------------------- |
| 121   | true   | 121 reversed is 121        |
| -121  | false  | Negative numbers not valid |
| 10    | false  | 10 reversed is 01          |

🔢 LeetCode Problem: 169. Majority Element
🧾 Problem Statement
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

✅ Example

Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2

🚀 Approach: Boyer-Moore Voting Algorithm
This algorithm efficiently finds the majority element using constant space and linear time.

💡 Intuition:
The majority element appears more than all others combined.

So even if we "cancel out" different elements one by one, the majority will always survive in the end.

🧠 Logic:
Initialize a candidate (majority) and a vote counter.

Iterate through the array:

If vote == 0, assign the current element as the new candidate.

If current element equals majority, increment vote.

Else, decrement vote.

After the loop, the majority will hold the correct majority element.

🧑‍💻 Code:

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0], votes = 1;

        for (int i = 1; i < nums.length ; i++) {
            if (votes == 0) {
                votes++;
                majority = nums[i];
            } else if (majority == nums[i]) {
                votes++;
            } else {
                votes--;
            }
        }
        return majority;
    }
}

⏱️ Time Complexity:
O(n) – single pass through the array

🧮 Space Complexity:
O(1) – constant space used (no extra data structures)

🧪 Alternate Approach (for practice):
Use a HashMap<Integer, Integer> to count frequencies (but this uses O(n) space, not optimal).

📌 Notes:
This problem is commonly asked in interviews.

Boyer-Moore is a useful trick for majority element detection without extra space.

🔢 LeetCode Problem: 1752. Check if Array Is Sorted and Rotated

🧾 Problem Statement
Given an array nums, check whether it is a sorted array that has been rotated.
An array is considered sorted and rotated if it is sorted in non-decreasing order, then some prefix of the array is moved to the end.

🔁 Example:

Input: nums = [3, 4, 5, 1, 2]
Output: true

Input: nums = [2, 1, 3, 4]
Output: false

Input: nums = [1, 2, 3]
Output: true

🚀 Approach: Count Drops (Circular Check)

We traverse the array and count how many times the current element is greater than the next one.
We also wrap around using modulus % to compare the last and first element — simulating a circular array.

🔍 Key Insight:

If the array is sorted and rotated, this "drop" in order can happen at most once.

💡 Step-by-Step Logic:

1. Store the length of the array n = nums.length.

2. Use a loop from i = 0 to i < n.

3. For each index i, compare:

nums[i] > nums[(i + 1) % n]

This handles circular comparison, like comparing last and first element.

4. If this condition is true, increment a count of drops.

5. If count <= 1, the array is sorted and rotated — ✅ return true.

6. Else, more than one drop → ❌ return false.

🧑‍💻 Code:

public class CheckSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (nums[i] > nums[next]) {
                count++;
            }
        }

        return count <= 1;
    }
}

⏱️ Time Complexity:
O(n) – single loop through the array

🧮 Space Complexity:
O(1) – constant space, no extra data structures

🧪 Test Notes:
✅ [3, 4, 5, 1, 2] → drop at 5→1 → valid

✅ [1, 2, 3, 4, 5] → no drop → valid

❌ [2, 1, 3, 4] → drop at 2→1 AND 1→3 → invalid


✅ 217. Contains Duplicate

🔗 Problem Link
LeetCode 217 - Contains Duplicate

🧾 Problem Statement
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

🔍 Examples
Input: nums = [1,2,3,1]
Output: true

Input: nums = [1,2,3,4]
Output: false

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

🧠 Approach 1: HashSet (Optimal)
✅ Idea:
We use a HashSet to track all elements we’ve seen.
If any element is already present in the set, it means there is a duplicate.

✅ Why it works:
HashSet only stores unique elements.

.add() returns false if the element already exists.

✅ Java Code:

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}

🧠 Approach 2: Sort + Compare (Space-Optimized)
✅ Idea:
Sort the array so that duplicates are adjacent.

Check if any two adjacent elements are the same.

✅ When to use:
When you're asked to avoid extra space.

✅ Java Code:

import java.util.Arrays;

public class ContainsDuplicateSorted {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // Sorting the array

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}

⏱️ Time and Space Complexity

| Approach           | Time Complexity | Space Complexity |
| ------------------ | --------------- | ---------------- |
| **HashSet**        | `O(n)`          | `O(n)`           |
| **Sort + Compare** | `O(n log n)`    | `O(1)` (extra)   |

✨ Notes

In interviews, prefer the HashSet version unless space optimization is specifically required.

HashSet.add() is a clean way to check for duplicates in O(1) average time.

##  🚀 238. Product of Array Except Self

🔗 Problem Link
LeetCode 238 – Product of Array Except Self

🧾 Problem Statement
Given an integer array nums, return an array answer such that answer[i] is the product of all elements of nums except nums[i].

Constraints

No division is allowed.

The solution must run in O(n) time and use O(1) extra space (excluding the output array).

🧠 Intuition & Approach
To meet the O(1)-extra-space requirement we can’t store full prefix and suffix arrays.
Instead we do the work in two passes, re-using the output array:

1. Prefix Pass (Left ➜ Right)
Initialize answer[0] = 1.
For every index i (from 1 to n-1):
answer[i] = answer[i-1] * nums[i-1];

At this point answer[i] holds the product of all elements to the left of i.

2. Suffix Pass (Right ➜ Left)
Maintain a running variable suffix = 1.
Walk from the end of the array to the start:
answer[i] *= suffix;   // combine prefix and suffix
suffix    *= nums[i];  // update suffix for next iteration

By multiplying the existing prefix product with the running suffix,
answer[i] becomes the product of all elements except nums[i].

💻 Code (Java)

public class ProductExceptSelf {
    public int[] productExceptself(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1) Prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 2) Suffix products and combine
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}

⏱️ Complexity Analysis
| Metric          | Complexity                                                              |
| --------------- | ----------------------------------------------------------------------- |
| **Time**        | `O(n)` – two linear scans                                               |
| **Extra Space** | `O(1)` – only constant variables (`suffix`) aside from the output array |

✨ Key Takeaways
Using two passes lets us avoid both division and extra arrays.

The technique of prefix + running suffix is a powerful pattern for “array-except-self”–style problems.

Always double-check edge cases (single element, zeros) – the algorithm naturally handles them because answer starts with 1.

📄 Problem: 2461. Maximum Sum of Distinct Subarrays With Length K

✅ Goal:
Given an integer array nums and a number k, return the maximum sum of any subarray of length k such that all elements in that subarray are distinct.

Example : 
Input: nums = [4,3,5,1,6], k = 3
Output: 12
Explanation: The subarray [3,5,6] has distinct elements and the sum is maximum.

Approach & Explanation
1️⃣ Understanding the Problem
We need to: ✅ Maintain a window of size k.
✅ Ensure all elements in the window are unique.
✅ Keep track of the maximum sum of a valid subarray.
2️⃣ Strategy
We use a Sliding Window + Hash Set approach:
- HashSet (set) ensures that the window contains unique elements.
- Sliding Window adjusts dynamically—removing old values when duplicates appear or when the size exceeds k.
- Tracking Sum helps compute the max sum efficiently.


Code Breakdown
🚀 Step-by-Step Explanation
1️⃣ Initialize set, sum, max, and window pointer.
2️⃣ Loop through the array:
- If the current number already exists in set OR window reaches k, remove the oldest element.
- Add the new number to set and update sum.
- If the window contains exactly k elements, update max.
3️⃣ Return the maximum sum found.
Key Optimizations
🔹 Only one pass → Runs in O(n), making it efficient.
🔹 Set ensures uniqueness → Prevents unnecessary checks.
🔹 Sliding Window prevents recomputation → Keeps operations minimal.

Code Implementation
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long sum = 0, max = 0;
        int window = 0;

        for(int i = 0; i < nums.length; i++) {
            while(set.contains(nums[i]) || set.size() == k) {
                set.remove(nums[window]);
                sum -= nums[window++];
            }

            sum += nums[i];
            set.add(nums[i]);

            if(set.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

🔍 Approach:
We use a sliding window along with a HashSet to track distinct elements in the current window.

Steps:
1.  Initialize:

Set<Integer> set — tracks distinct elements.

sum — current window sum.

max — stores the maximum valid sum found.

window — left boundary of our sliding window.

2. Traverse nums using i as the right pointer:

While the window is invalid (duplicate element OR size == k):

Shrink the window from the left by removing nums[window] from the set and subtracting it from the sum.

Increment window.

Add nums[i] to the set and to the sum.

If the set size becomes exactly k, update max.

3. Return the value of max.

Interview-Ready Explanation (Non-Coder Friendly)
Imagine we’re looking through a window, trying to pick the best view.
- We can only see k elements at a time.
- If we see duplicates, we need to shift the window to remove old ones.
- At every step, we check if this new view (subarray) has the highest sum possible.
We use a tracking system (Set) to ensure our window always contains unique numbers, adjusting the view whenever needed.
By sliding through the array once, we efficiently find the largest valid subarray sum without doing unnecessary work. 🚀

Why This Solution Works Well
✔ Time Complexity: O(n) → Only one pass, making it fast.
✔ Space Complexity: O(k) → Only stores elements inside the window.
✔ Efficient Handling of Duplicates: Set removes old values dynamically.
✔ Scalable: Works for large datasets.

🧠 Problem: Container With Most Water (LeetCode #11)
📝 Problem Summary:
Given an array of integers representing heights, find two lines such that together with the x-axis, they form a container that holds the most water. The container's area is determined by the shorter of the two lines and the distance between them.

🚀 Approach: Two Pointer Technique (O(n))
We use a two-pointer approach to find the maximum water area efficiently in linear time.

Initialize two pointers, one at the beginning (left) and one at the end (right) of the array.

Calculate the width as the distance between the two pointers.

Determine the height by taking the minimum of the heights at the left and right pointers — since water is limited by the shorter line.

Compute the current area using width * height.

Update the maximum area if the current area is larger.

Move the pointer with the smaller height inward (since it’s the limiting factor for area) to explore potentially higher heights.

🧮 Key Insight:
The area is determined by the shorter height, not the taller one. So always move the pointer at the smaller height to maximize chances of finding a larger area.

✅ Time & Space Complexity:
Time: O(n) — Single pass from both ends.

Space: O(1) — No extra space used.

📘 Problem: Longest Substring Without Repeating Characters

🧩 LeetCode #3
🔗 Link to problem

📄 Problem Statement:
Given a string s, find the length of the longest substring without repeating characters.

Explanation of lengthOfLongestSubstring Method

This method finds the length of the longest substring without repeating characters in a given string s. It uses the Sliding Window technique with a HashMap to efficiently track character positions.

Approach
- Initialize Variables:
- max: Stores the maximum length of a substring found so far.
- left: Represents the left boundary of the sliding window.
- lastPos: A HashMap<Character, Integer> that keeps track of the last seen position of each character.
- Iterate Through the String:
- We use a right pointer to expand the window by iterating over each character in s.
- If the current character ch has been seen before within the current window, we move the left pointer to exclude the previous occurrence.
- Update the last seen position of ch in lastPos.
- Update Maximum Length:
- After processing each character, update max with the current window size: right - left + 1.

Key Observations
- The HashMap ensures O(1) lookups, making the approach efficient.
- The Sliding Window prevents unnecessary reprocessing, leading to an O(n) time complexity.
- The left pointer only moves forward, ensuring each character is processed at most once.

Time & Space Complexity
- Time Complexity: O(n) → Each character is processed once.
- Space Complexity: O(min(n, 26)) → At most 26 characters (for lowercase English letters) are stored in the HashMap.


Example Walkthrough
Input: "abcabcbb"
Step-by-Step Execution : 
| Step | right | ch | left | lastPos (Updated) | max | 
| 1 | 0 | 'a' | 0 | {'a': 0} | 1 | 
| 2 | 1 | 'b' | 0 | {'a': 0, 'b': 1} | 2 | 
| 3 | 2 | 'c' | 0 | {'a': 0, 'b': 1, 'c': 2} | 3 | 
| 4 | 3 | 'a' | 1 | {'a': 3, 'b': 1, 'c': 2} | 3 | 
| 5 | 4 | 'b' | 2 | {'a': 3, 'b': 4, 'c': 2} | 3 | 
| 6 | 5 | 'c' | 3 | {'a': 3, 'b': 4, 'c': 5} | 3 | 
| 7 | 6 | 'b' | 5 | {'a': 3, 'b': 6, 'c': 5} | 3 | 
| 8 | 7 | 'b' | 7 | {'a': 3, 'b': 7, 'c': 5} | 3 | 


Final Output: 3 (Longest substring: "abc")


💻 Code (Java - Optimized Using HashMap):

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> lastPos = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (lastPos.containsKey(ch) && lastPos.get(ch) >= left) {
                left = lastPos.get(ch) + 1;  // jump left pointer
            }

            lastPos.put(ch, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

##  Time & Space Complexity:
Time Complexity: O(n)

Space Complexity: O(k), where k is the character set size (e.g. 128 for ASCII)


🧠 Longest Substring with At Most K Distinct Characters
Problem:
Given a string S and an integer K, find the length of the longest substring that contains at most K distinct characters.

Approach:
We use the sliding window technique with two pointers and a HashMap to efficiently track characters and their counts within the current window.

Step-by-step solution:

1. Edge cases:

If K is 0, or the string is null or empty, return 0 immediately.

2. Initialize variables:

left pointer at 0 (start of the sliding window).

maxLength to keep track of the maximum length found so far.

A HashMap<Character, Integer> to count occurrences of characters in the current window.

3. Expand the window using the right pointer:

Iterate right from 0 to the end of the string.

Add the character at right to the HashMap or increment its count.

4. Shrink the window if needed:

While the size of the HashMap (number of distinct characters) exceeds K, shrink the window from the left:

Decrement the count of the character at left.

If the count drops to zero, remove that character from the map.

Increment left pointer to shrink the window.

5. Update the maximum length:

After adjusting the window to ensure it has at most K distinct characters, update maxLength to be the maximum of the current maxLength and the current window size (right - left + 1).

6. Return maxLength after processing the whole string.

Time Complexity: O(n) — each character is processed at most twice (once when expanding right pointer, once when shrinking left pointer).
Space Complexity: O(k) — HashMap holds at most k characters.

Example
For S = "eceba" and K = 2:

The longest substring with at most 2 distinct characters is "ece" with length 3.


🧠 Longest Substring with Exactly K Distinct Characters

Problem Statement
Given a string S and an integer K, find the length of the longest substring that contains exactly K distinct characters.

Approach
We use a sliding window technique combined with a HashMap to keep track of the characters and their frequencies within the current window.

Detailed Steps
1. Edge Cases:
Return 0 if K is 0, or the string is null or empty.

2. Initialize Pointers and Data Structures:

left pointer at the start of the string (index 0).

Variable maxLength to track the longest valid substring length found so far.

A HashMap<Character, Integer> to count the occurrences of characters in the current window.

3. Expand the Window with the Right Pointer:
Iterate right pointer over the string and update the frequency of the current character in the map.

4. Shrink the Window if Distinct Characters Exceed K:
While the size of the HashMap (number of distinct characters) is greater than K, shrink the window from the left by reducing the frequency of the leftmost character, and remove it from the map if its count reaches zero. Increment left pointer.

5. Update Max Length for Exactly K Distinct:
When the HashMap size is exactly K, update maxLength with the current window size (right - left + 1) if it is larger than the previous maxLength.

6. Return Result:
After processing the string, return the maxLength as the length of the longest substring with exactly K distinct characters.

Complexity Analysis
Time Complexity: O(n), where n is the length of the string — each character is visited at most twice (once by the right pointer and once by the left pointer).

Space Complexity: O(k), as the HashMap stores at most K distinct characters at any time.

Example
Input: S = "aabbcc", K = 2
Output: 4
Explanation: Longest substrings with exactly 2 distinct characters are "aabb" and "bbcc", both of length 4.

Key Points to Remember
The sliding window ensures we consider all substrings efficiently without repeated scanning.

Shrinking the window maintains the invariant that the substring contains at most K distinct characters — allowing us to check when it equals exactly K.

Using a HashMap to store character counts allows constant time updates and queries.

## Rotate Array - In-Place Reverse Approach

### Problem
Given an array `nums`, rotate it to the right by `k` steps.

### Approach:
We use the reverse method to rotate the array in-place with `O(n)` time and `O(1)` space.

#### Steps:
1. **Reverse the entire array** — this moves the last `k` elements to the front (in reverse order).
2. **Reverse the first `k` elements** — this restores the original order of the first rotated part.
3. **Reverse the rest (`k` to `n-1`)** — this restores the order of the remaining part.

### Example:
Input:  
`nums = [1, 2, 3, 4, 5, 6, 7], k = 3`  
Steps:
- Reverse whole array: `[7, 6, 5, 4, 3, 2, 1]`
- Reverse first 3: `[5, 6, 7, 4, 3, 2, 1]`
- Reverse last 4: `[5, 6, 7, 1, 2, 3, 4]` ✅

### Complexity:
- **Time:** O(n)
- **Space:** O(1)

✅ 167. Two Sum II - Input Array Is Sorted
🔗 LeetCode Link: Two Sum II

🧩 Problem Statement:
You are given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, and an integer target.

Return the indices of the two numbers such that they add up to target. The indices must be returned as an array of the two integers, and you may not use the same element twice.

You must solve it using only constant extra space.

🧠 Approach: Two Pointer Technique
Since the array is sorted, we can use a two-pointer approach to find the two numbers efficiently:

Initialize two pointers:

i = 0 (start of array)

j = numbers.length - 1 (end of array)

While i < j:

Calculate sum = numbers[i] + numbers[j]

If sum == target: return [i + 1, j + 1] (1-based indexing)

If sum < target: move the left pointer i++ (to get a larger number)

If sum > target: move the right pointer j-- (to get a smaller number)

🧮 Time & Space Complexity:
| Complexity | Value                                             |
| ---------- | ------------------------------------------------- |
| Time       | `O(n)` — we scan from both ends                   |
| Space      | `O(1)` — constant space, no extra data structures |

✅ Code:
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            }

            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {};  // fallback, though the problem guarantees a solution
    }
}

✍️ Notes:
Don’t forget it’s 1-based indexing in the return value.

This question is a great example of how recognizing a sorted input can help you optimize to O(n) using two pointers instead of using a HashMap.

✅ 389. Find the Difference
🔗 LeetCode Link: Find the Difference

🧩 Problem Statement:
You are given two strings:

s — original string

t — a shuffled version of s with one extra character added

Return the extra character that was added to t.

🧠 Approach: ASCII Sum Difference (Math Trick)
💡 Intuition:
Every character has an ASCII value.
If we add up all characters in t and subtract all characters in s,
we’ll be left with the ASCII value of the extra character.

🔨 Steps:
Initialize an integer total = 0

Traverse through string t, and add ASCII value of each character to total

Traverse through string s, and subtract ASCII value of each character from total

What remains is the ASCII value of the extra character → return (char) total

✅ Code:
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int total = 0;

        for (int i = 0; i < t.length(); i++) {
            total += t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            total -= s.charAt(i);
        }

        return (char) total;
    }
}

⏱️ Time and Space Complexity:
| Complexity | Value  | Notes                       |
| ---------- | ------ | --------------------------- |
| Time       | `O(n)` | Traverses both strings once |
| Space      | `O(1)` | Constant extra space used   |

Note: It’s O(n + n) technically, but we drop constants in Big-O.
🧪 Example:
Input: s = "abcd", t = "abcde"
Output: 'e'

✔️ ASCII of 'a' + 'b' + 'c' + 'd' is subtracted from 'a' + 'b' + 'c' + 'd' + 'e'
→ Result is 'e'

🗣️ Interview Tip:
This is a perfect example of “math-based optimization”.

You can also mention the XOR approach if they ask for alternatives:

char result = 0;
for (char c : s.toCharArray()) result ^= c;
for (char c : t.toCharArray()) result ^= c;
return result;

✅ 53. Maximum Subarray
🔍 Problem Statement:
Find the contiguous subarray (containing at least one number) which has the largest sum, and return its sum.

💡 Intuition:
We are looking for a maximum sum subarray.
If a subarray’s sum ever goes negative, we discard it — because adding negative sum to future elements only reduces the total.

📦 Final Polished Java Code:
public class MaxSubarray {
    public int maxSubarray(int[] nums) {
        int maxSum = nums[0];  // max sum found so far
        int sum = 0;           // current sum of subarray

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];                // accumulate sum
            if (sum > maxSum) maxSum = sum; // update max if needed
            if (sum < 0) sum = 0;           // reset if sum goes negative
        }

        return maxSum;
    }
}

🧠 Explanation:
Initialize sum = 0 and maxSum = nums[0]

Traverse array:

Add current number to sum

If sum becomes greater than maxSum, update maxSum

If sum becomes negative, reset it to 0

Return maxSum at the end.

🧪 Dry Run Example: [−2,1,−3,4,−1,2,1,−5,4]
Start with sum = 0, maxSum = -2

Traverse and update:

At i=3 → sum = 4 → maxSum = 4

At i=5 → sum = 5 → maxSum = 5

At i=6 → sum = 6 → maxSum = 6

Final Answer: 6

⏱️ Time & Space Complexity:
Time: O(n)

Space: O(1)

✅ How to Explain 53. Maximum Subarray in an Interview
🔹1. Start with the Problem Statement
"We are given an integer array, and we need to find the contiguous subarray with the maximum sum."

🔹2. Brute Force First (Optional, if asked)
"A brute force solution would be to check the sum of every possible subarray, which would take O(n²) time."

"But we can do better using Kadane’s Algorithm in O(n) time."

🔹3. Introduce Kadane’s Algorithm (Core Explanation)
"Kadane’s Algorithm works by maintaining two variables:"

sum → current running sum of the subarray

maxSum → maximum sum encountered so far

"We iterate through the array, and at every step:
– we add the current number to sum,
– if sum becomes negative, we reset it to zero because negative sum would reduce future totals.
– We keep updating maxSum with the maximum of current sum and previous maxSum."

🔹4. Explain with One Example
Say interviewer gives: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

You can say:

"We start with sum = 0 and maxSum = -2 (first element).
We go through the array:

Add -2 → sum = -2 → reset to 0

Add 1 → sum = 1 → maxSum becomes 1

Add -3 → sum = -2 → reset to 0

Add 4 → sum = 4 → maxSum = 4

Continue this way, maxSum ends up as 6."

🔹5. Conclude with Complexity
"Time complexity is O(n) — we scan the array once.
Space complexity is O(1) — we use constant extra space."

🧠 BONUS TIP: Add Why Reset on Negative
"If the sum so far is negative, continuing the subarray will not help us get a bigger total in the future. So we reset."

🔢 643. Maximum Average Subarray I
This Java solution solves LeetCode Problem 643: Maximum Average Subarray I using an efficient sliding window technique.

🧠 Problem Statement
Given an integer array nums and an integer k, find the contiguous subarray of length k that has the maximum average value, and return this average.

🚀 Approach
We use the sliding window technique to efficiently calculate the sum of subarrays of size k in O(n) time:

Compute the sum of the first window (first k elements).

Then, slide the window one element at a time:

Subtract the element going out of the window.

Add the element coming into the window.

Track the maximum sum seen during the process.

Finally, return the average by dividing the max sum by k.

📁 Code : 
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;  // sum of the starting window
        for (int i = 0; i < k; i++) sum += nums[i];

        int maxSum = sum;

        // Start sliding window
        int startIndex = 0;
        int endIndex = k;
        while (endIndex < nums.length) {
            sum -= nums[startIndex];    // remove previous element
            sum += nums[endIndex];      // add next element

            maxSum = Math.max(maxSum, sum);

            startIndex++;
            endIndex++;
        }

        return (double) maxSum / k;   // return the average value
    }
}

🧪 Example
Input:
nums = [1, 12, -5, -6, 50, 3], k = 4

Windows of size 4:

[1,12,-5,-6] → sum = 2

[12,-5,-6,50] → sum = 51 ✅

[-5,-6,50,3] → sum = 42

Output: 12.75

🧰 Concepts Practiced
Sliding Window

Subarray Sum Tracking

Space Optimization

Time Complexity Analysis

⏱️ Time & Space Complexity
Time: O(n) — each element is visited once

Space: O(1) — no extra data structures used


## Problem: Single Number

### 🔗 LeetCode Link
[Single Number](https://leetcode.com/problems/single-number/)

### ✅ Approach Used
**XOR Logic**  
- XOR of a number with itself is 0: `a ^ a = 0`  
- XOR of any number with 0 is the number: `a ^ 0 = a`  
- So, XOR-ing all elements will cancel duplicates and leave the unique one.

### 💡 Dry Run
Input: [4,1,2,1,2]  
XOR Steps:  
- 4 ^ 1 = 5  
- 5 ^ 2 = 7  
- 7 ^ 1 = 6  
- 6 ^ 2 = 4  

Final result: 4 ✅

### 🧠 Learnings
- Bit manipulation using XOR is powerful  
- Time: O(n) | Space: O(1) — Optimal solution


## Approach

We use the **bitwise XOR (^) operator**, which has the following properties:

- `a ^ a = 0` (a number XOR itself is 0)
- `a ^ 0 = a` (a number XOR 0 is the number itself)
- XOR is **commutative** and **associative**

By XORing all the elements in the array, the duplicate numbers cancel each other out, and the result is the unique element.

## Java Solution

```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

Time and Space Complexity
Time Complexity: O(n) — Single pass through the array

Space Complexity: O(1) — No extra space used (in-place XOR)

Tags
Bit Manipulation XOR Array Linear Time

# ✅ Check if Array Is Sorted and Rotated — Sliding Window with Circular Indexing

## 🔍 Problem Overview

Given an array of integers, determine whether it is **sorted in non-decreasing order and then rotated**. An array that is already sorted is also considered valid.

Example:
- `[3, 4, 5, 1, 2]` is valid (rotation of `[1, 2, 3, 4, 5]`)
- `[1, 3, 2]` is **not** valid

---

## 🚀 My Approach: Simulated Sliding Window on Circular Array

### 🎯 Key Insight

We simulate the rotation behavior by virtually **duplicating the array** (i.e., extending it to `2 * n` elements) using the **modulo operator** for index wrap-around.

### 🧠 How It Works

1. **Loop from index `1` to `2 * n`:**  
   This mimics scanning the array from every possible rotated starting point.

2. **Use `% n` to simulate circular indexing:**  
   This avoids `ArrayIndexOutOfBoundsException` while moving across the duplicated range.

3. **Track a `count` of consecutive sorted elements:**  
   - If current element ≤ next, we increment `count`
   - If order breaks, reset `count` to 1
   - If `count == n`, we've found a valid rotated sorted segment.

4. **Return true if a full segment was found, otherwise false.**

### 🔧 Code Snippet

```java
public boolean check(int[] nums) {
    int n = nums.length;
    if (n == 1) return true;
    int count = 1;

    for (int i = 1; i < 2 * n; i++) {
        if (nums[(i - 1) % n] <= nums[i % n]) {
            count++;
        } else {
            count = 1;
        }
        if (count == n) return true;
    }

    return false;
}

🧪 Why This Is Efficient
-Time Complexity: O(n)
-Space Complexity: O(1)

Avoids creating extra arrays by simulating the behavior with modular math.

🌟 Highlights
- Creative use of circular indexing using modulo (%)
- Sliding window logic applied in a rotated context
- Runs in 0 ms on LeetCode – highly efficient

> 💡 This approach blends logic clarity with mathematical intuition, and demonstrates how understanding array structure can lead to elegant solutions.

# 🚫 LeetCode 27: Remove Element

## 🧩 Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place and return the new length of the array. The order of elements can be changed, and you don't need to consider elements beyond the new length.

---

## ✅ Approach

We iterate through the array using a for loop and maintain a `count` to track where to place the next valid (non-`val`) element.

- If `nums[i] != val`, we assign `nums[count] = nums[i]` and increment `count`.
- This effectively overwrites elements equal to `val` while preserving other values.

We return `count` at the end, which represents the new length of the array after removal.

---

## ⏱️ Time & Space Complexity

- **Time Complexity:** `O(n)` — Traverse the array once.
- **Space Complexity:** `O(1)` — In-place modification with no extra memory usage.

---

## 💻 Java Code

```java
public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }
}

🧪 Example
Input:
nums = [3, 2, 2, 3], val = 3

Output:
New length = 2, Modified array = [2, 2, _, _]
💡 Insight
This approach ensures that you don’t need to preserve the order of elements, making the overwrite operation straightforward and efficient.

# 🔄 LeetCode 88: Merge Sorted Array

## 🧩 Problem Statement

You’re given two integer arrays:  
- `nums1` of size `m + n`, with the first `m` elements initialized  
- `nums2` of size `n`  

The goal is to **merge `nums2` into `nums1` in non-decreasing order**, modifying `nums1` in-place.

---

## ✅ Approach

We use three pointers:
- `i = m - 1`: points to the end of initialized elements in `nums1`
- `j = n - 1`: points to the end of `nums2`
- `k = m + n - 1`: points to the last position in `nums1`

We compare elements from the end of both arrays and place the larger one at position `k`. We repeat this until all of `nums2` is merged.

**Why from the end?**  
Because `nums1` has enough space, and overwriting from the back prevents accidental loss of data in `nums1`.

---

## ⏱ Time & Space Complexity

- **Time Complexity:** `O(m + n)` — We scan both arrays once.
- **Space Complexity:** `O(1)` — In-place merging, no extra space needed.

---

## 💻 Java Code

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}

🧪 Example
Input:
nums1 = [1,2,3,0,0,0], m = 3  
nums2 = [2,5,6], n = 3

Output:
nums1 = [1,2,2,3,5,6]

💡 Insight
This technique avoids extra memory usage and teaches how to smartly work with array ends. It’s a fantastic example of in-place algorithm design.

## 🔹 Problem: 724. Find Pivot Index

**Description:**  
Given an array of integers, the *pivot index* is the index where the sum of the numbers on the left is equal to the sum on the right. Return the left-most pivot index. If none exists, return -1.

---

### ✅ Approach

1. Calculate the **total sum** of the array.
2. Initialize a `leftSum` as 0.
3. Loop through the array:
   - For each index `i`, calculate `rightSum = total - nums[i] - leftSum`.
   - If `leftSum == rightSum`, return `i` as the pivot index.
   - Otherwise, update `leftSum` with the current value.
4. If no pivot is found after the loop, return -1.

---

### 💻 Code

```java
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - nums[i] - leftSum;
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}

📊 Complexity Analysis
Time Complexity: O(n)

Space Complexity: O(1)

🔍 Insights
This is a great example of reducing redundant computation using arithmetic insight. It avoids recalculating left and right sums from scratch for each index, achieving linear efficiency.