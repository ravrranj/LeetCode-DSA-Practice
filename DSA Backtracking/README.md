
📘 Backtracking: Subsets (LeetCode #78)
🔖 Problem Statement:
Given an integer array nums of distinct integers, return all possible subsets (the power set).

Example:
Input: [1, 2, 3]
Output:
[
  [], [1], [2], [3],
  [1, 2], [1, 3], [2, 3],
  [1, 2, 3]
]

🧠 Core Concept: Backtracking
Backtracking is a technique used to explore all possible solutions to a problem by making a choice, exploring further, and then undoing that choice (backtrack).

This is perfect for problems involving:

1. Subsets

2. Combinations

3. Permutations

4. Maze solving

5. Constraint satisfaction (e.g. Sudoku)

🪜 Step-by-Step Intuition:
At each index in the input array:

1. ✅ Choose the current element (include it in the subset)

2. ❌ Or skip it

3. Recursively repeat the process

4. Backtrack to try other possibilities

🧩 Dry-Run for [1, 2, 3]:
Recursion tree (subset being built at each step):

start with []

→ add 1 → [1]
  → add 2 → [1,2]
    → add 3 → [1,2,3]
    ← backtrack → [1,2]
  ← backtrack → [1]
  → add 3 → [1,3]
← backtrack → []

→ add 2 → [2]
  → add 3 → [2,3]
← backtrack → []

→ add 3 → [3]

🧪 Java Code
public class SubsetsGenerator {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Save current subset
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                      // Choose
            backtrack(i + 1, nums, current, result);   // Explore
            current.remove(current.size() - 1);        // Backtrack
        }
    }
}

⏱️ Time & Space Complexity
| Metric           | Value        | Explanation                                     |
| ---------------- | ------------ | ----------------------------------------------- |
| Time Complexity  | `O(n * 2^n)` | `2^n` subsets, each may take up to `n` to build |
| Space Complexity | `O(n * 2^n)` | storing all subsets                             |
| Recursion Depth  | `O(n)`       | max depth of recursion tree                     |

🧵 Backtracking Template (General):
void backtrack(State current) {
    if (base_case) {
        save_result(current);
        return;
    }

    for (option in possible_choices) {
        make_move(option);
        backtrack(next_state);
        undo_move(option); // ← backtrack step
    }
}

💬 Interview Notes
- Explain how you're generating all combinations using recursive branching.

- Emphasize the "Choose → Explore → Un-choose" pattern.

- Talk about pruning and avoiding unnecessary paths (not relevant here but in others).

- Use subset trees or binary inclusion-exclusion trees to explain your thought process visually.

📘  Backtracking: Unique Paths in a Grid

🔖 Problem Statement:
You are given an n x m grid. Starting from the top-left cell (0, 0), you can only move:

👉 Right (i, j + 1)

👇 Down (i + 1, j)

Your goal is to count how many unique paths exist to reach the bottom-right cell (n-1, m-1).

📥 Example Input:

n = 3, m = 3

📤 Example Output:

6

There are 6 valid paths from (0,0) to (2,2).

🧠 Intuition:
At every cell, you can:

Go right

Or go down

Use backtracking (recursion) to explore both options from every cell until you reach the destination.

When you reach (n-1, m-1) → count it as 1 valid path

🧵 Recursive Flow:
Start at (0,0)
↘ Try right → (0,1)
↘ Try down  → (1,0)

From each step, again try:
→ right
↓ down

Count total ways reaching (2,2)

This forms a recursion tree that explores all paths.

✍️ Java Code:
public class MatrixPaths {

    static int countPaths(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) return 1;
        if (i >= n || j >= m) return 0;

        int right = countPaths(i, j + 1, n, m);
        int down = countPaths(i + 1, j, n, m);

        return right + down;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int totalPaths = countPaths(0, 0, n, m);
        System.out.println("Total unique paths: " + totalPaths);
    }
}

⏱️ Time & Space Complexity

if (base case) return 1;
if (out of bounds) return 0;

int right = go right;
int down = go down;

return right + down;

🧠 Bonus Notes (for Interviews)
This is a classic backtracking to DP upgrade problem.

If they ask for optimization, mention memoization or DP grid.

You can also print actual paths like RRDD, RDRD, etc.

✅  Leetcode 79 – Word Search

# Word Search – Leetcode 79

## 🧩 Problem Statement

Given a 2D board of characters and a word, return `true` if the word exists in the grid.

- The word can be constructed from letters of **sequentially adjacent cells**.
- Adjacent cells are **horizontally or vertically neighboring**.
- The **same letter cell may not be used more than once**.

---

## 🧠 Approach – DFS + Backtracking

1. Traverse every cell in the grid.
2. If a cell matches the first character of the word, call a recursive DFS.
3. In the DFS:
   - Base case: if `index == word.length()`, return true.
   - Boundary checks:
     - Out of grid bounds.
     - Already visited.
     - Current character mismatch.
   - Mark the cell as visited.
   - Explore all 4 directions: up, down, left, right.
   - Backtrack by unmarking the cell.
4. If any DFS call returns true, the word exists.

This is a classic backtracking problem: **Try → Explore → Undo**

---

## 📦 Code

```java
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (index == word.length()) return true;

        if (row < 0 || row >= board.length || 
            col < 0 || col >= board[0].length || 
            visited[row][col] || 
            board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        boolean found = dfs(board, word, visited, row + 1, col, index + 1) ||  // down
                        dfs(board, word, visited, row - 1, col, index + 1) ||  // up
                        dfs(board, word, visited, row, col + 1, index + 1) ||  // right
                        dfs(board, word, visited, row, col - 1, index + 1);    // left

        visited[row][col] = false; // backtrack

        return found;
    }
}

🔍 Dry Run Example
Input:
char[][] board = {
  {'A','B','C','E'},
  {'S','F','C','S'},
  {'A','D','E','E'}
};
String word = "ABCCED";

Path:

Start at (0,0) = 'A'

→ (0,1) = 'B'

→ (0,2) = 'C'

→ (1,2) = 'C'

→ (2,2) = 'E'

→ (2,1) = 'D'
✅ Word matched

⏱️ Time & Space Complexity
1. Time Complexity: O(m * n * 4^L)

m * n = total cells, L = length of the word

Each cell tries 4 directions recursively for up to L steps.

2. Space Complexity: O(L) for recursion stack + O(m * n) for visited

🧠 What I Learned
- How to implement DFS in a 2D grid.

- How to backtrack properly using a visited[][] matrix.

- Importance of base cases and clean backtracking.

- Thought process for approaching recursive search problems.

🧪 Test Cases
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

🪜 Next Step
Try Word Search II or Combination Sum to strengthen backtracking further.


# 🔄 Permutations (LeetCode 46)

## 🧩 Problem Statement

Given an array `nums` of distinct integers, return *all possible permutations* of the elements.

> You must return the permutations in any order.

---

## ⚙️ Approaches Compared

### 🧪 Method 1: Using `tempList.contains()`  
```java
if (tempList.contains(number)) continue;

✅ Pros:
- Simple and intuitive for beginners.
- Doesn't require additional memory structures.
⚠️ Cons:
- tempList.contains(number) is an O(n) operation per call.
- This leads to O(n²) time per recursive level in the worst case.
- Not ideal when performance matters or input size increases.

🚀 Method 2: Using a boolean[] visited array
if (visited[i]) continue;


✅ Pros:
- Constant time check O(1) to see if a number is already used.
- Overall recursive call runtime becomes significantly faster.
- More memory-efficient than a HashSet, and clearer than .contains() checks.
💡 Note: The visited[] array ensures each index is only used once in a permutation.

📊 Time and Space Complexity
| Approach | Time Complexity | Space Complexity | 
| Using .contains() | O(n × n!) | O(n) + Recursion Stack | 
| Using visited[] | O(n!) | O(n) + Recursion Stack | 



🌳 Recursion Tree (Example: nums = [1, 2, 3])
                []
      _________/ | \_________
     /           |           \
   [1]          [2]          [3]
  /   \         / \          / \
[1,2][1,3]   [2,1][2,3]   [3,1][3,2]
   |     |     |     |     |     |
[1,2,3]...[1,3,2]...[2,1,3]...[3,2,1]



✅ Conclusion
- Use .contains() for readability when input size is very small.
- Use visited[] for optimal performance in interviews or when scaling matters.

✍️ Final Thoughts
Both solutions use backtracking, but the visited[] version is faster per call and preferred in production scenarios or when performance is tested under time constraints.


📁 # 💡 Combination Sum (LeetCode 39)

## 📘 Problem Description
Given a set of **distinct positive integers** `candidates[]` and a **target** value, find all unique combinations where the candidate numbers sum to the target.  
Each number in `candidates` may be used an **unlimited number of times**.

> The solution set must not contain duplicate combinations.

---

## 🧠 Intuition
This problem is a classic case for **backtracking**, where we explore all possible combinations recursively, pruning paths that exceed the target.

- We iterate through the array starting from a `startIndex` to avoid duplicates.
- Elements can be reused, so we don’t increment the index during recursive calls.
- Once the running sum equals the `target`, we add a copy of the path to the result.

---

## 🔁 Algorithm Steps

1. Initialize an empty result list.
2. Call the `backtrack` helper with:
   - Current path
   - Remaining target
   - Start index to prevent revisiting earlier candidates
3. In `backtrack`:
   - If `target == 0`, add the current path to result.
   - If `target < 0`, return (invalid path).
   - Else, iterate through candidates from `startIndex`, and:
     - Include the candidate
     - Recurse with updated target
     - Backtrack after the call

---

## ⏱ Time and Space Complexity

| Metric             | Complexity                              |
|--------------------|------------------------------------------|
| Time Complexity     | O(2^T) — where T = `target`             |
| Space Complexity    | O(T) — recursion depth and path length  |

---

## ✅ Example

**Input**:
```java
candidates = [2, 3, 6, 7], target = 7
Output:
[
  [2, 2, 3],
  [7]
]
🌳 Recursion Tree (for candidates = [2, 3], target = 7)
                    []
               /           \
            [2]             [3]
           /   \             |
        [2,2]  [2,3]       [3,3]
         /        |           |
     [2,2,2]   [2,3,3]      [3,3,3]
        |         |            |
   [2,2,2,1](x) [2,3,3,1](x) [3,3,3,1](x)
        |         |            |
   [2,2,3]✓       ...          ...


🟢 ✓ = valid result
❌ (x) = overshoots target

🎯 Key Takeaways
- Use backtracking with a startIndex to avoid permutations.
- Candidates can be reused; hence we recurse with i, not i + 1.
- Mind the difference between this and Combination Sum II, where reuse isn't allowed.

