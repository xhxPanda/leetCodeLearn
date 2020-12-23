package decemberchallange;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {
    private boolean isValidBST(TreeNode root) {
         if(root == null) return true;

        List<Integer> list = new ArrayList<>(0);
        inorder(root, list);

        for(int i = 0; i< list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     * @param node
     * @param list
     */
    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
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
