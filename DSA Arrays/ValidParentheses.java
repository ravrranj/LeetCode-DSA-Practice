// 20. Valid Parentheses : Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
//2. Open brackets must be closed in the correct order.
//3. Every close bracket has a corresponding open bracket of the same type.

import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {  // opening
                st.push(ch);
            } else { // closing
                if (st.isEmpty()) {
                    return false; // no corresponding closing bracket
                }
                char top = st.peek();  // check top element without popping
                if ((top == '(' && ch == ')') ||
                        (top == '{' && ch == '}') ||
                        (top == '[' && ch == ']')) {
                    st.pop();
                } else { // no match
                    return false;
                }
            }
        }
        return st.isEmpty(); // ensure all brackets are matched
    }

    public static void main(String[] args) {
        String test = "()[]{}";

        System.out.println("Is Valid ? " + isValid(test));  // check the output
    }
}
