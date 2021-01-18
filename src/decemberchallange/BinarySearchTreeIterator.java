package decemberchallange;

import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeIterator {
    private TreeNode root;
    private Stack<TreeNode> stack;
    private LinkedList<Integer> valList;

    public BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<TreeNode>();
        valList = new LinkedList<Integer>();

        //条件很重要
        while(stack.size() != 0 || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.size() > 0){
                    root = stack.pop();
                    valList.offer(root.val);
                    root = root.right;
                }
            }
        }
    }

    public boolean hasNext() {
        if(valList.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        return valList.poll();
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
