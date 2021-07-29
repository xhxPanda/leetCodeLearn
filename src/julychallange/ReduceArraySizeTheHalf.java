package julychallange;

import java.util.*;

public class ReduceArraySizeTheHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] help = new int[map.values().size()];
        int size = 0;
        List<Integer> list = new ArrayList<>(map.values());
        for (int i = 0; i < help.length; i++) {
            help[i] = list.get(i);
        }
        Arrays.sort(help);
        int res = 0, ind = help.length - 1;
        int le = size / 2;
        while(size > le && ind >= 0) {
            res++;
            size -= help[ind];
            ind--;
        }
        return res;
    }
}
