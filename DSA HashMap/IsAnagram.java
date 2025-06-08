//Using array : 242. Valid Anagram


public class IsAnagram {
    public boolean isAnagram(String s, String t) {
    
        if (s.length() != t.length()) return false;  

        int[] arr = new int[26];

        for (int i = 0; i < s.length; i++) {
            arr[s.charAt(i) - 'a']++;

        }
        for (int i =0; i < s.length(); i++) {
            arr[t.charAt(i) - 'a']--;

            if(arr[t.charAt(i) - 'a'] < 0) return false;
        }
           
        return true;
    }
}