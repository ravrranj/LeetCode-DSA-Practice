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

