package decemberchallange;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTreeSolution {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) {
            return root;
        }

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        TreeNode dummy = new TreeNode();
        TreeNode p = dummy;
        for (TreeNode node : list) {
            p.right = node;
            p = node;
        }
        return dummy.right;
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root);
        root.left = null;
        inorder(root.right, list);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
