package janchallange;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> reached = new ArrayList<>();
        reached.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        wordSet.add(endWord);

        int distance = 1;
        while (!reached.contains(endWord)) {
            List<String> toAdd = new ArrayList<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String wd = new String(chars);
                        if (wordSet.contains(wd)) {
                            toAdd.add(wd);
                            wordSet.remove(wd);
                        }
                    }
                }
            }
            distance++;
            if(toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }
}
