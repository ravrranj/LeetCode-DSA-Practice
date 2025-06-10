
# Java Loops Series (HackerRank-Style Problem)

## 🧠 Problem Overview:

We are given `q` queries. Each query contains:
- `a` (starting value)
- `b` (value multiplied with powers of 2)
- `n` (number of terms in the series)

We must generate a series:

S_k = a + (2^0 · b + 2^1 · b + ... + 2^k · b)
for 0 ≤ k < n


Each query produces `n` space-separated integers.

---

## 📥 Input Format:

q
a1 b1 n1
a2 b2 n2
...
aq bq nq


---

## 📤 Output Format:

One line per query, each with `n` space-separated terms of the series.

---

## 📊 Example

### Input:

1
1 2 4

### Output:

3 7 15 31


---

## 🔍 Dry Run:

For `a = 1`, `b = 2`, `n = 4`:

| i | 2^i · b | Current Value |
|---|---------|----------------|
| 0 | 2       | 1 + 2 = 3      |
| 1 | 4       | 3 + 4 = 7      |
| 2 | 8       | 7 + 8 = 15     |
| 3 | 16      | 15 + 16 = 31   |

---

## 🧠 Time Complexity:

- **O(n)** per query  
- **O(q × n)** overall

---

## ✅ Learning Points:

- Bit manipulation with `1 << i`
- Loop-based simulation
- Efficient input and formatted output

## How to explain in an interview :

Let's break this down step by step. This Java program performs an arithmetic operation using a series expansion based on bitwise shifts.
Breakdown:
- Reading Input:
- The program starts by reading an integer queries, which represents the number of test cases.
- Then, for each test case, it reads three integers: a, b, and n.
- Calculating the Series:
- The initial value curr is set to a.
- The program then loops n times, updating curr using the formula:

curr += (1 << i) * b;

- 1 << i performs a left bitwise shift on 1, meaning it multiplies 1 by 2^i.
- Multiplying this shifted value by b adds a progressively increasing term to curr.
- Printing the Sequence:
- After each iteration, curr is printed, forming a sequence where each value grows exponentially based on powers of 2.
Example:
Input:
1
5 3 4

Execution:
- First iteration (i = 0): curr = 5 + (1 << 0) * 3 = 5 + 1 * 3 = 8
- Second iteration (i = 1): curr = 8 + (1 << 1) * 3 = 8 + 2 * 3 = 14
- Third iteration (i = 2): curr = 14 + (1 << 2) * 3 = 14 + 4 * 3 = 26
- Fourth iteration (i = 3): curr = 26 + (1 << 3) * 3 = 26 + 8 * 3 = 50
Output:

8 14 26 50

Core Concept:
This program implements a mathematical series expansion, where each term follows the pattern:
[ S(i) = S(i-1) + 2^{(i-1)} \times b ]
This resembles an arithmetic progression with an exponential factor.

