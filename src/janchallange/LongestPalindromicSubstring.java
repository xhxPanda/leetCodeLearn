package janchallange;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        List<Character> strList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            strList.add('#');
            strList.add(s.charAt(i));
        }
        strList.add('#');

        List<Integer> lenList = new ArrayList<>();
        String result = "";

        int resultMid = 0;
        int resultIndex = 0;

        lenList.add(1);

        for (int i = 1; i<strList.size();i++) {
            if (i < resultIndex) {
                int j = 2 * resultMid - i;
                if (j >= 2 * resultMid - resultIndex && lenList.get(j) <= resultIndex - i) {
                    lenList.add(lenList.get(j));
                } else {
                    lenList.add(resultIndex - i + 1);
                }
            } else {
                // i >= resultIndex 时，从头开始匹配
                lenList.add(1);
            }
            while ((i - lenList.get(i) >= 0 && i + lenList.get(i) < strList.size()) &&
                    (strList.get(i - lenList.get(i)) == strList.get(i + lenList.get(i)))) {
                lenList.set(i, lenList.get(i) + 1);
            }
            if(lenList.get(i) >= lenList.get(resultMid)) {
                resultIndex = lenList.get(i) + i - 1;
                resultMid = i;
            }
        }
        result = s.substring((2 * resultMid - resultIndex) / 2, resultIndex / 2);
        return result;
    }
}
