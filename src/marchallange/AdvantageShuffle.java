package marchallange;

import java.util.LinkedList;
import java.util.TreeMap;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int size = A.length;
        TreeMap<Integer, LinkedList<Integer>> mapB = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> idxList = mapB.getOrDefault(B[i], new LinkedList<>());
            idxList.add(i);
            mapB.putIfAbsent(B[i], idxList);
        }
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            Integer key = mapB.lowerKey(A[i]);
            if (key == null) {
                key = mapB.lastKey();
            }
            LinkedList<Integer> idxList = mapB.get(key);
            int index = idxList.removeLast();
            ans[index] = A[i];
            if (idxList.isEmpty()) {
                mapB.remove(key);
            }
        }
        return ans;
    }
}