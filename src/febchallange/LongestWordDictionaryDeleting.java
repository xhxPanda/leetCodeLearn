package febchallange;

import java.util.List;

public class LongestWordDictionaryDeleting {
    public String findLongestWord(String s, List<String> d) {
        String ret = "";
        for (String str : d) {
            for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                if (j == str.length()) {
                    if (str.length() > ret.length() || (str.length() == ret.length() && ret.compareTo(str) > 0)) {
                        ret = str;
                    }
                }
            }
        }
        return ret;
    }
}
