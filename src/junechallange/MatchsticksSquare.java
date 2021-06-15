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
        return true;
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
