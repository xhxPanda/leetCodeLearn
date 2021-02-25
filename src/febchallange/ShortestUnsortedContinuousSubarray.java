package febchallange;

public class ShortestUnsortedContinuousSubarray {
    public int find(int[] nums) {
        if(nums.length == 0)
            return 0;

        int begin = -1;
        int end = -2;

        int n = nums.length;
        int maxVal = nums[0], minVal = nums[n-1];

        for (int i = 1; i< n; i++) {
            maxVal = Math.max(nums[i], maxVal);
            minVal = Math.min(nums[n-1-i], minVal);

            if(nums[i] != maxVal) {
                end = i;
            }

            if (nums[n - 1 - i] != minVal) {
                begin = n - 1 -i;
            }
        }
        return end - begin + 1;
    }
}
