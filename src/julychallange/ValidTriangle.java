package julychallange;

import java.util.Arrays;

public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int out = 0;

        for (int i = n - 1; i >= 0; i--) {
            int a = nums[i];

            int j = 0, k = i - 1;

            while (j < k) {
                int b = nums[j];
                int c = nums[k];

                if (a < b + c) {
                    out += (k - j);
                    k--;
                } else {
                    j++;
                }
            }
        }
        return out;
    }
}
