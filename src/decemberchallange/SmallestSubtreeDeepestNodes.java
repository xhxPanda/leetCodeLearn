package decemberchallange;

public class SmallestSubtreeDeepestNodes {
    private TreeNode result = null;

    public TreeNode helper(TreeNode node) {
        maxDepth(node, 0);
        return result;
    }

    public int maxDepth(TreeNode root, int depth) {
        int resultMaxDepth = 0;
        int resultDepth = 0;

        if (root == null) {
            return depth;
        }

        int maxLeftDepth = maxDepth(root.left, depth + 1);
        int maxRightDepth = maxDepth(root.right, depth + 1);

        if (maxLeftDepth == maxRightDepth) {
            if(maxLeftDepth > resultMaxDepth) {
                resultMaxDepth = maxLeftDepth;
                resultDepth = depth;
                result = root;
            } else if(maxLeftDepth == resultMaxDepth) {
                if (depth < resultDepth) {
                    resultMaxDepth = maxLeftDepth;
                    resultDepth = depth;
                    result = root;
                }
            }
        }
        return Math.max(maxLeftDepth, maxRightDepth);
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
