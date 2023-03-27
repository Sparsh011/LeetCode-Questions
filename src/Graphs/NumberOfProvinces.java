package Graphs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(vis, isConnected, n, i);
            }
        }

        return count;
    }

    private void dfs(boolean[] vis, int[][] graph, int n, int node) {
        vis[node] = true;

        for (int i = 0; i < graph[node].length; i++) {
            // Checking currentNode kis kis se connected hai
            if (!vis[i] && graph[node][i] == 1) {
                vis[i] = true;
                dfs(vis, graph, n, i);
            }
        }
    }

}
