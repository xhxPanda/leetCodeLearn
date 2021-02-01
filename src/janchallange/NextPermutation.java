package janchallange;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int right = nums.length - 1;
        int j = right;
        for (; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {
                return;
            }
        }

        for (int k = right; k >= 0 ; k--) {
            if (j > 0 && nums[k] > nums[j - 1]) {
                swapArray(nums, j - 1, k);
                break;
            }
        }
    }

    private void swapArray(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
