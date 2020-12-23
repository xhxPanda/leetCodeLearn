package decemberchallange;

import java.util.Arrays;

public class SquaresSortedArray {
    private int[] handle(int[] nums) {
        for (int i = 0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
