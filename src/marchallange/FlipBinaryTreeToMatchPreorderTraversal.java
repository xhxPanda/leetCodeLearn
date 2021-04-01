package marchallange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    private List<Integer> res = new ArrayList<>();
    private int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }

        if (root.val != voyage[i]) {
            return false;
        }

        i++;
        if (root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
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
