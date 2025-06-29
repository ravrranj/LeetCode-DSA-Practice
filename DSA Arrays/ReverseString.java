
//344. Reverse String

public class ReverseString {

    public void reverseString(char[] s) {

        //using two pointer approach
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}