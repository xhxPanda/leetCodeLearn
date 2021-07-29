package julychallange;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Comparator<Integer> maxHeap = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(n * n, maxHeap);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                pq.add(matrix[i][j]);
            }
        }
        while (pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
