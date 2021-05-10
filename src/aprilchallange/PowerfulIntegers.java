package aprilchallange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int m = 0;
        int n = 0;
        int num1 = bound;
        int num2 = bound;

        if (x == 1) {
            m = 1;
        } else {
            while (num1 / x > 0) {
                num1 /= x;
                m++;
            }
        }

        if (y == 1) {
            n = 1;
        } else {
            while (num2 / y > 0) {
                num2 /= y;
                n++;
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int intNum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (intNum <= bound) set.add(intNum);
            }
        }
        result.addAll(set);
        return result;
    }
}
