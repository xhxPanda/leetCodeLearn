package aprilchallange;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int sum = 0;
        while (!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                sum = sum + temp.val;

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return sum;
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
