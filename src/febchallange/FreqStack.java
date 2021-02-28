package febchallange;

import java.util.*;

public class FreqStack {
    private Map<Integer, Integer> map;
    private List<Stack<Integer>> stacks;

    public FreqStack() {
        map = new HashMap<>(0);
        stacks = new ArrayList<>(0);
    }

    public void push(int x) {
        int freq= map.getOrDefault(x, 0);
        freq++;
        map.put(x, freq);
        if (freq > stacks.size()) {
            Stack<Integer> stack = new Stack<>()
            stack.push(x);
            stacks.add(stack);
        } else {
            Stack<Integer> stack = stacks.get(freq - 1);
            stack.push(x);
        }
    }

    public int pop() {
        Stack<Integer> stack = stacks.get(stacks.size() - 1);
        int result = stack.pop();

        if (stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        int freq = map.get(result);
        map.put(result, --freq);
        if (freq == 0) {
            map.remove(result);
        }
        return result;
    }
}
