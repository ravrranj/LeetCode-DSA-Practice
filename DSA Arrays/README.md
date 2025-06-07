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


🧠 Problem: 88. Merge Sorted Array
We are given two sorted arrays:

nums1 of size m + n, where the first m elements are meaningful and the rest are zero placeholders.

nums2 of size n.

We need to merge nums2 into nums1 in-place so that the final nums1 becomes a sorted array of length m + n.

🚀 Approach: Three-Pointer Technique (Start from the End)

Since we can’t use extra space, we start filling nums1 from the end (index m + n - 1) using a three-pointer approach:

i → Points to the last meaningful element in nums1 (i = m - 1)

j → Points to the last element in nums2 (j = n - 1)

k → Points to the end of nums1 (k = m + n - 1)

🔁 Steps:
While j >= 0:

If nums1[i] > nums2[j], place nums1[i] at nums1[k] and decrement i

Else, place nums2[j] at nums1[k] and decrement j

Decrement k in each iteration

If any elements remain in nums2, they’ll be placed at the front of nums1 (already handled in the loop)

✅ Example:

nums1 = [1,2,3,0,0,0], m = 3  
nums2 = [2,5,6], n = 3

// Output: [1,2,2,3,5,6]

💡 Key Insight:

By filling from the back, we prevent overwriting useful data in nums1, making this approach efficient and in-place.

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

🧠 Time & Space Complexity:
Time Complexity: O(n)

Space Complexity: O(k), where k is the character set size (e.g. 128 for ASCII)



