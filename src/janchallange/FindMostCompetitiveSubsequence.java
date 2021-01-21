package janchallange;

import java.util.Stack;

public class FindMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        if(k == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[k];
        for(int i = 0; i<n; i++) {
            while (stack.size() != 0 && stack.peek() > nums[i] && (n - i) + stack.size() > k) {
                stack.pop();
            }
            stack.add(nums[i]);
        }
        int j = k-1;
        while (!stack.empty()) {
            if(stack.size() > k) {
                stack.pop();
                continue;
            }
            result[j] = stack.pop();
            j--;
        }
        return result;
    }
}