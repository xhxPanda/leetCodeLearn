package decemberchallange;

import java.util.Map;

public class ReachANum {

    public int reachNum(int target) {
        int n = 0;
        int sum = 0;
        target = Math.abs(target);
        while (sum < target) {
            n++;
            sum += n;
        }

        if ((sum - target) % 2 == 0) {
            return n;
        } else {
            if (n % 2 == 0) {
                return n + 1;
            } else {
                return n + 2;
            }
        }
    }
}
