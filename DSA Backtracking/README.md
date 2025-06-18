
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


