package aprilchallange;

public class CountBinarySubstrings {
    public int solution(String s) {
        int[] group = new int[s.length()];
        group[0] = 1;
        int t = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                group[++t] = 1;
            } else {
                group[t]++;
            }
        }

        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            result += Math.min(group[i - 1], group[i]);
        }
        return result;
    }
}
