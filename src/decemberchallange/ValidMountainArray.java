package decemberchallange;

public class ValidMountainArray {
    public boolean handle(int[] arr) {
        if(arr.length < 3)
            return false;

        int left = 0;
        int right = arr.length - 1;
        while(left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while(right - 1 > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if(left == arr.length - 1){
            return false;
        } else if(right == 0) {
            return false;
        }
        if(left == right) {
            return true;
        }

        return false;
    }
}
