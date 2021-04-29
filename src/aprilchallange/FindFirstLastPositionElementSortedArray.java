package aprilchallange;

public class FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch(nums, false, target);
        result[1] = binarySearch(nums, true, target);
        return result;
    }

    private int binarySearch(int[] nums, boolean direction, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (direction && mid < nums.length - 1 && nums[mid + 1] == target) {
                    left = mid + 1;
                } else if (!direction && mid > 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
