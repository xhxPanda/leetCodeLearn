package julychallange;

import java.util.Arrays;

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        // 计算1的数量
        int count = Arrays.stream(arr).sum();
        if (count == 0) return new int[]{0, arr.length - 1};
        if (count % 3 != 0) return new int[]{-1, -1};
        // 计算每个part1的数量
        count /= 3;
        int i = 0;
        // 找初始1
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == 1) break;
        }
        int start = i, count1 = 0;
        i = 0;
        // 找第 count + 1 个1
        for (count1 = 0, i = 0; i < arr.length; i++) {
            if (arr[i] == 1) count1++;
            if (count1 == count + 1) break;
        }
        int mid = i;
        //找第 2 * count + 1 个1
        for (count1 = 0, i = 0; i < arr.length; i++) {
            if (arr[i] == 1) count1++;
            if (count1 == 2 * count + 1) break;
        }
        int end = i;
        // 匹配
        while (end < arr.length && arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start++;mid++;end++;
        }
        if (end == arr.length) return new int[]{start - 1, mid};
        return new int[]{-1, -1};
    }
}
