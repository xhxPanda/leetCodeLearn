package decemberchallange;

import java.util.HashMap;

public class FourSumTwo {

    private int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;

        HashMap<Integer, Integer> ab = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                ab.put(a + b, ab.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int part2 = c + d;
                int part1 = -part2;
                res += ab.getOrDefault(part1, 0);
            }
        }
        return res;
    }
}
