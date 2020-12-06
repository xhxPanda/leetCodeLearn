package decemberchallange;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersEachNodeTwo {
    public Node connect(Node root) {
        List<Node> nodes = new ArrayList<>();
        dfs(root, 0, nodes);
        return root;
    }
    private void dfs(Node root, int depth, List<Node> nodes) {
        if (null == root) return;
        if (depth >= nodes.size())
            nodes.add(root);
        else {
            nodes.get(depth).next = root;
            nodes.set(depth, root);
        }
        dfs(root.left,  depth + 1, nodes);
        dfs(root.right, depth + 1, nodes);
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
