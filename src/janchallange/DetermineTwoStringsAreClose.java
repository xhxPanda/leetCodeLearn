package janchallange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        Set<Character> wd1 = new HashSet<>();
        Set<Character> wd2 = new HashSet<>();

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            wd1.add(c);
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            wd2.add(c);
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return wd1.equals(wd2);
    }
}
