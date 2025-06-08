// 387. First Unique Character in a String - Using array

public class FirstUniqChar {
    public int firstUniqChar(String s) {

        if (s.length() == 0) return -1;
    
        int[] arr = new int[26];
        int n = s.length();

        for ( int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (arr[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}