import java.util.Stack;

public class ValidParenthesesOptimized {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                   }
            }
        }
        return stack.isEmpty();  // must be empty at the end
    }

    public static void main(String[] args) {
        
        String test = "{([{}])}" ;
        System.out.println( "Is Valid ? " + isValid(test));
    }
}