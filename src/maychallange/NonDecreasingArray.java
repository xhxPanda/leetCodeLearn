package maychallange;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int minValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                minValue = nums[i];
            } else {
                if (nums[i + 1] < minValue) {
                    nums[i + 1] = nums[i];
                }
                count += 1;
                if (count > 1) return false;
            }
        }
        return true;
    }
}
