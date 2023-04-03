package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDISTINCTIslands {
    int countDistinctIslands(int[][] grid) {
        Set<List<String>> set = new HashSet<>();

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, list, n, m, grid, vis, i, j);
                    set.add(new ArrayList<>(list));
                }
            }
        }

        // System.out.println(set.toString());

        return set.size();
    }

    private void dfs(int i, int j, List<String> list, int n, int m, int[][] grid, boolean[][] vis, int baseI, int baseJ) {
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || grid[i][j] == 0) return;

        list.add(Math.abs(baseI - i) + " " + Math.abs(baseJ - j));
        vis[i][j] = true;

        dfs(i + 1, j, list, n, m, grid, vis, baseI, baseJ);
        dfs(i - 1, j, list, n, m, grid, vis, baseI, baseJ);
        dfs(i, j + 1, list, n, m, grid, vis, baseI, baseJ);
        dfs(i, j - 1, list, n, m, grid, vis, baseI, baseJ);

    }
}
