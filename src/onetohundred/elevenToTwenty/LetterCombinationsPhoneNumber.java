package onetohundred.elevenToTwenty;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.equals("")) {
            return result;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] middleTemp = new char[digits.length()];
        difGetStr(digits, 0, middleTemp, mapping, result);
        return result;
    }

    public void difGetStr(String digits, int index, char[] middleStr, String[] map, List<String> result) {
        if(index == digits.length()) {
            result.add(new String(middleStr));
            return;
        }

        char strChar = digits.charAt(index);
        for (int i = 0; i<map[strChar - '0'].length(); i++) {
            middleStr[index] = map[strChar-'0'].charAt(i);
            difGetStr(digits, index+1, middleStr, map, result);
        }
    }
}
