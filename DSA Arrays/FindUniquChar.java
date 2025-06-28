//387. First Unique Character in a String

public class FindUniquChar {
    public int firstUniqueChar(String s) {
        int[] freq = new int[26]; // ASCII a-z 
        char[] chars = s.toCharArray(); //converting the string element into characters

        for (char c : chars) {
            freq[c - 'a']++; //Map character to index
        }

        for (int i = 0; i < chars.length; i++) {
            if(freq[chars[i] - 'a'] == 1) return i;
        }

        return -1; // no non-reperating character
    }
}