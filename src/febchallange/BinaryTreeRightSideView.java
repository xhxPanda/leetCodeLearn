package febchallange;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 1;
        int helper = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count--;
            if (node.left != null) {
                queue.offer(node.left);
                helper++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                helper++;
            }
            if (count == 0) {
                result.add(node.val);
                count = helper;
                helper = 0;
            }
        }

        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
