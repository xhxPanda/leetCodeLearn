package junechallange;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][]d = new boolean[s1.length() + 1][s2.length() + 1];
        d[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                d[i][0] = true;
            } else {
                break;
            }
        }

        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j-1) == s3.charAt(j-1)) {
                d[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                d[i][j] |= d[i - 1][j] && s1.charAt(i-1) == s3.charAt(i + j-1);
                d[i][j] |= d[i][j - 1] && s2.charAt(j-1) == s3.charAt(i + j-1);
            }
        }
        return d[s1.length()][s2.length()];
    }
}
