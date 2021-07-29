package julychallange;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }
}
