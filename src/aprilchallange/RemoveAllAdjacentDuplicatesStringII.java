package aprilchallange;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesStringII {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 直接用一个StringBuilder当做栈使用
        StringBuilder sb = new StringBuilder();
        // 新开一个栈存储sb连续出现的字符的个数
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() == 0 || s.charAt(i) != sb.charAt(sb.length() - 1)) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
            }
            // 接着把新来的字符加入sb
            sb.append(s.charAt(i));
            // 如果栈2顶等于k，说明要开始删字符了，将最后k个字符删掉，然后pop掉栈2的栈顶
            if (stack.peek() == k) {
                sb.setLength(sb.length() - k);
                stack.pop();
            }
        }
        return sb.toString();
    }
}
