// 389. Find the Difference

public class FindTheDifference {
    public char findTheDifference(String s, String t) {

        int total = 0;

        for ( int i = 0; i < t.length(); i++) {
            total = total + t.charAt(i);   // Add all ASCII values of t
        }

        for ( int i = 0; i < s.length(); i++) {
            total = total - s.charAt(i);  // Subtract all ASCII values of s
        }

        return (char) total;  // What's left is the extra char
    }
}