package janchallange;

import java.util.Arrays;

public class CountSortedVowelStrings {
    private int solution(int n) {
        int[] dp = new int[5];
        int result = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j-1];
            }
        }
        for (int c : dp) {
            result += c;
        }
        return result;
    }
}
