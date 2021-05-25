package janchallange;

public class MinimumOperationsReduceXZero {

    private int minOperation(int[] nums, int x) {
        if (nums[0] == x) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum == x) {
            return nums.length;
        } else if (sum < x) {
            return -1;
        }

        int target = sum - x;
        int result = -1;
        int left = 0, right = left + 1;
        int cur = nums[left];

        while (left <= right && right <= nums.length - 1) {
            if (cur == target) {
                result = Math.max(result, right - left);
            }

            if (cur <= target) {
                cur += nums[right++];
            } else {
                cur -= nums[left++];
            }
        }
        return result == -1 ? result : (nums.length - result);
    }
}
