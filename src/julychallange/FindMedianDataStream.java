package julychallange;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianDataStream {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public FindMedianDataStream() {
        maxheap = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        minheap = new PriorityQueue<>();
    }

    public void addNu(int num) {
        // 如果最大堆为空，或者该数小于最大堆堆顶，则加入最大堆
        if(maxheap.size() == 0 || num <= maxheap.peek()) {
            // 如果最大堆大小超过最小堆，则要平衡一下
            if (maxheap.size() > minheap.size()) {
                minheap.offer(maxheap.poll());
            }
            maxheap.offer(num);
        } else if (minheap.size() == 0 || num > minheap.peek()) {
            if (minheap.size() > maxheap.size()) {
                maxheap.offer(minheap.poll());
            }
            minheap.offer(num);
        } else {
            if (maxheap.size() <= minheap.size()) {
                maxheap.offer(num);
            } else {
                minheap.offer(num);
            }
        }
    }

    public double findMedian() {
        // 返回大小较大的那个堆的堆顶，如果大小一眼说明是偶数个， 则返回堆顶均值
        if (maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else if (maxheap.size() < minheap.size()) {
            return minheap.peek();
        } else if (maxheap.isEmpty() && minheap.isEmpty()) {
            return 0;
        } else {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
    }
}
