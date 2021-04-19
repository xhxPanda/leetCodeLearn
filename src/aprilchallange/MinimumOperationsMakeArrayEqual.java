package aprilchallange;

public class MinimumOperationsMakeArrayEqual {
    public int minOperations(int n) {
        int res = 0;
        for(int cur = 1; cur < n; cur+=2) {
            res += n - cur;
        }
        return res;
    }
}
