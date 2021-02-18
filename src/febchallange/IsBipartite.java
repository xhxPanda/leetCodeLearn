package febchallange;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public boolean solution (int[][] graph) {
            Queue<Integer> queue = new LinkedList<>();
            int[] colors = new int[graph.length];   // 三色标记法，0表示该节点未划分，-1表示该节点在partA，1表示该节点在partB
            for (int i = 0; i < graph.length; i++) {
                // 遍历所有节点，对未划分的节点分入partB（因为该节点和之前划分的节点没有边相连，即无所谓partA和partB，这里选partB）
                if (colors[i] == 0 && !validColor(graph, colors, 1, i)) return false;
            }
            return true;
        }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            // 剪支，如果当前节点已经归类，则判断他是不是需要在两部分同时出现
            return colors[node] == color;
        }
        colors[node] = color;
        for (int j : graph[node]) {
            // 找到反例立刻返回
            if (!validColor(graph, colors, -color, j)) return false;
        }
        return true;
    }
}