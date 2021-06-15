package junechallange;

import java.util.Arrays;

public class MatchsticksSquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) return false;

        int side = sum / 4;
        int[] sides = {0, 0, 0, 0};

        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(sides, matchsticks, 0, side);
    }

    private boolean dfs(int[] sides, int[] matchsticks, int index, int side) {
        if (index == matchsticks.length) {
            if (sides[0] == side && sides[1] == side && sides[2] == side)
                return true;
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > side) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (dfs(sides, matchsticks, index + 1, side)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }
        return false;
    }

    public void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
