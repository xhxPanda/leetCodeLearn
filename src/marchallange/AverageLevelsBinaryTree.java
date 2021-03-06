package marchallange;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0d;
            for (int i = 0; i < n; i++) {
                TreeNode x = queue.poll();
                sum += x.val;
                if (x.left != null) queue.add(x.left);
                if(x.right != null) queue.add(x.right);
            }
            result.add(sum / n);
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
}
