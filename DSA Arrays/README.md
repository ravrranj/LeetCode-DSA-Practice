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


Note
These solutions use basic/brute force methods. Tomorrow, we will explore optimized approaches for these problems to improve performance.
