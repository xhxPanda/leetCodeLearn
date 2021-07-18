package julychallange;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphicStrings(String s, String t) {
        return isIsomorphicStrings0(s, t) && isIsomorphicStrings0(t, s);
    }

    private boolean isIsomorphicStrings0(String t, String s) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null)
            return false;

        Map<Character, Integer> dist = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!dist.containsKey(s.charAt(i))) {
                dist.put(s.charAt(i), t.charAt(i) - s.charAt(i));
            } else {
                if (dist.get(s.charAt(i)) != t.charAt(i) - s.charAt(i)) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

}
