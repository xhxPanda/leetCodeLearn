package janchallange;

public class ConvertBSTGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);

        return root;
    }
    private int convert(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }

        sum = convert(node.right, sum);
        node.val += sum;

        return convert(node.left, node.val);
    }

    private class TreeNode {
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
