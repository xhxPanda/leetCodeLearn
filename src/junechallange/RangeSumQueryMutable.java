package junechallange;

public class RangeSumQueryMutable {
    int[] nums;
    int[] tree;
    int size;

    //time: O(nlogn)
    public RangeSumQueryMutable(int[] nums) {
        this.size = nums.length;
        this.tree = new int[size + 1];
        this.nums = new int[size];

//        for(int i = 0; i < n; i++) {
//            updateTree(i, nums[i]);
//        }
    }

    public void updateTree(int i, int val) {
        i = i + 1;
        while(i < size) {
            tree[i] += val;
            i += i & (-i); //the last set bits, 2s compliment
        }
    }

    public void update(int i, int val) {
        if(size == 0) return;
        update(i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        if(i == 0) return j;
        return getSum(j) - getSum(i - 1);
    }

    private int getSum(int i) {
        int sum = 0;
        i = i + 1;
        while(i > 0) {
            sum += tree[i];
            i -= i & (-i);//go to ancestor
        }
        return sum;
    }

}
