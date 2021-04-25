package aprilchallange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberSubmatricesThatSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] array = new int[n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(array, 0);
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) { // j每次增加一格，k从上到下，都要加入对应的array[k];
                    array[k] += matrix[k][j]; // 把每一行k, [i,j] sum起来；
                }
            }
        }

        return res;
    }

    private int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
