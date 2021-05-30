package maychallange;

public class JumpGameTwo {

    public int jump (int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int max = 0, count = 1, begin = 0, end = nums[0];
        while (end < nums.length - 1) {
            count++;
            int index = begin;
            for (; index <= end; index++) {
                max = Math.max(max, index + nums[index]);
            }
            begin = index;
            end = max;
        }
        return count;
    }
}
