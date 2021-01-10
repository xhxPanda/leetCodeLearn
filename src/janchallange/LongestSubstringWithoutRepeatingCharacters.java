package janchallange;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int handle(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();

        int max = 0;
        int walker = 0;
        int runner = 0;

        while (runner < s.length()) {
            if (set.contains(s.charAt(runner))) {
                if (max < runner - walker) {
                    max = runner - walker;
                }
                while (s.charAt(walker) != s.charAt(runner)) {
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
            } else {
                set.add(s.charAt(runner));
            }
            runner++;
        }

        max = Math.max(max, runner - walker);
        return max;
    }
}
