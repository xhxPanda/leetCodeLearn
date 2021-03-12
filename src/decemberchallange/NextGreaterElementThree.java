package decemberchallange;

public class NextGreaterElementThree {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        char[] charList = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            nums[i] = Integer.valueOf(String.valueOf(charList[i]));
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
        for (int j = 0; j < nums.length; j++) {
            stringBuilder.append(nums[j]);
        }

        Integer i = Integer.valueOf(stringBuilder.toString());
        return i;
    }

    public static void main(String[] args) {
        NextGreaterElementThree elementThree = new NextGreaterElementThree();
        elementThree.nextGreaterElement(12);
    }
}