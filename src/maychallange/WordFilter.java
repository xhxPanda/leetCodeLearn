package maychallange;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {
    private String s[];
    private Map<String, Integer> m1 = new HashMap<>();

    public WordFilter (String[] words) {
        s = words;
    }

    public int f(String prefix, String suffix) {
        if (m1.containsKey(prefix + "!" + suffix)) {
            return m1.get(prefix + "!" + suffix);
        }
        int pn = prefix.length();
        int sn = suffix.length();
        int count = 1;

        for (int i = s.length - 1; i >= 0; i--) {
            int n = s[i].length();
            String pp = s[i].substring(0, pn);
            String ss = s[i].substring(n - sn, n);

            if (pp.equals(prefix) && ss.equals(suffix)) {
                count = i;
                break;
            }
        }
        m1.put(prefix + "!" + suffix, count);
        return count;
    }
}
