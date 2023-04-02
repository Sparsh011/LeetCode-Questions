package Graphs;

public class NumberOfEnclaves {
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            boolean[][] vis = new boolean[m][n];

            for(int i = 0; i < m; i++){
                if(grid[i][0] == 1) {
                    handleBorder1(i, 0, grid, m, n, vis);
                }

                if(grid[i][n-1] == 1) {
                    handleBorder1(i, n-1, grid, m, n, vis);
                }
            }

            for(int j = 0; j < n; j++){
                if(grid[0][j] == 1) {
                    handleBorder1(0, j, grid, m, n, vis);
                }

                if(grid[m-1][j] == 1) {
                    handleBorder1(m-1, j, grid, m, n, vis);
                }
            }

            int res = 0;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!vis[i][j] && grid[i][j] == 1) {
                        res++;
                    }
                }
            }

            return res;

        }

        private void handleBorder1(int i, int j, int[][] board, int m, int n, boolean[][] vis){
            if(i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || board[i][j] == 0) return;

            vis[i][j] = true;

            handleBorder1(i + 1, j, board, m, n, vis);
            handleBorder1(i - 1, j, board, m, n, vis);
            handleBorder1(i, j + 1, board, m, n, vis);
            handleBorder1(i, j - 1, board, m, n, vis);
        }
    }
}
