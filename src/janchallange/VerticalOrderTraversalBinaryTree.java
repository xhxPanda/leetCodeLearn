package janchallange;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;

    public List<List<Integer>> verticalTraversal (TreeNode root) {
        map = new TreeMap<>();
        helper(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();

        for (int col : map.keySet()) {
            TreeMap<Integer, List<Integer>> it = map.get(col);
            List<Integer> list = new ArrayList<>();
            for (int row : it.keySet()) {
                List<Integer> cur = it.get(row);
                Collections.sort(cur);
                list.addAll(cur);
            }
            result.add(list);
        }
        return result;
    }

    private void helper (TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        if(!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }
        TreeMap<Integer, List<Integer>> it = map.get(col);
        if (!it.containsKey(row)) {
            it.put(row, new ArrayList<>());
        }
        it.get(row).add(root.val);
        helper(root.left, row + 1, col - 1);
        helper(root.right, row + 1, col + 1);
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
