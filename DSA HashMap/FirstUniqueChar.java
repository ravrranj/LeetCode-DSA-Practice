
// 387. First Unique Character in a String - Using hasmap

import java.util.HashMap;

public class FirstUniqueChar {
    public int firstUniqueChar(String s) {

        if (s.length() == 0) return -1;

        HashMap<Character, Integer> map = new HashMap<>();

        // First pass : build feq map

        for (char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch, 0) + 1);
        }

        // to find the first unique number - second pass
        for ( int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)  return i;
        }

        return -1;
    }
}