package decemberchallange;

public class NextGreaterElementThree {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        char[] charList = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            nums[i] = Integer.parseInt(String.valueOf(charList[i]));
        }

        int index = nums.length - 1;
        for (; index >= 1; index--) {
            if (nums[index] > nums[index - 1]) {
                int temp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = temp;
            } else {
                break;
            }
        }
        if (index == nums.length - 1) {
            return -1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}