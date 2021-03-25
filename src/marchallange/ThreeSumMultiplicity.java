package marchallange;

public class ThreeSumMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        int[] n = new int[target + 1];
        int result = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                result = (result + n[target - arr[i]]) % mod;
                for (int j = 0; j < i; j++) {
                    if (arr[i] + arr[j] <= target) {
                        n[arr[i] + arr[j]]++;
                    }
                }
            }
        }
        return result;
    }
}
