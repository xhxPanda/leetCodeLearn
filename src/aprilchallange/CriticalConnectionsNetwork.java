package aprilchallange;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnectionsNetwork {
    private int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (List<Integer> connection: connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] visitedTimes = new int[n];
        int[] lowTimes = new int[n];
        boolean[] visuted = new boolean[n];

        return lists;
    }

    private void dfs(int currNode, int parentNode, List<Integer>[] graph,
                     int[] visitedTimes, int[] lowTimes,
                     List<List<Integer>> lists, boolean[] visited) {
        visited[currNode] = true;
        visitedTimes[currNode] = lowTimes[currNode] = time++;

        for(Integer neighbor: graph[currNode]) {
            if(neighbor == parentNode) {
                continue;
            }

            if (!visited[neighbor]) {
                dfs(neighbor, currNode, graph, visitedTimes, lowTimes, lists, visited);
                // 用跟我connect neighbor能够看到的最小，来更新我能够看到的最小的值；
                lowTimes[currNode] = Math.min(lowTimes[currNode], lowTimes[neighbor]);

                if (lowTimes[neighbor] > visitedTimes[currNode]) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(currNode);
                    list.add(neighbor);
                    lists.add(list);
                }
            } else {
                lowTimes[currNode] = Math.min(lowTimes[currNode], visitedTimes[neighbor]);
            }
        }
    }
}
