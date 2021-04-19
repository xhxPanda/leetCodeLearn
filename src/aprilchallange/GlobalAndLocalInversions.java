package aprilchallange;

public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, mn = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 2; --i) {
            mn = Math.min(mn, nums[i]);
            if (nums[i - 2] > mn) return false;
        }
        return true;
    }
}
