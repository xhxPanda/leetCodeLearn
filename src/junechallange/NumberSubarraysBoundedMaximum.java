package junechallange;

public class NumberSubarraysBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > right) continue;

            int curMax = Integer.MIN_VALUE;
            for (int j = i; j < n; ++j) {
                curMax = Math.max(curMax, nums[j]);
                if (curMax > right) break;
                if (curMax >= left) res++;
            }
        }
        return res;
    }
}
