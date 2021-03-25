package marchallange;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }

        int result = 1;
        int flag = 0;
        for (int i = 1; i < n; i++) {
            int a = nums[i] - nums[i - 1];
            if (a != 0) {
                a = a / Math.abs(a);
            } else {
                continue;
            }

            if (a != flag) {
                result++;
            }

            flag = a;
        }

        return result;
    }
}
