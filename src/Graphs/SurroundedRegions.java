package Graphs;

public class SurroundedRegions {
    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;

            for(int i = 0; i < m; i++){
                if(board[i][0] == 'O') {
                    handleBorderZeroes(i, 0, board, m, n);
                }

                if(board[i][n-1] == 'O') {
                    handleBorderZeroes(i, n-1, board, m, n);
                }
            }

            for(int j = 0; j < n; j++){
                if(board[0][j] == 'O') {
                    handleBorderZeroes(0, j, board, m, n);
                }

                if(board[m-1][j] == 'O') {
                    handleBorderZeroes(m-1, j, board, m, n);
                }
            }


            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 'O') board[i][j] = 'X';
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == '+') board[i][j] = 'O';
                }
            }

        }

        private void handleBorderZeroes(int i, int j, char[][] board, int m, int n){
            if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;

            board[i][j] = '+';

            handleBorderZeroes(i + 1, j, board, m, n);
            handleBorderZeroes(i - 1, j, board, m, n);
            handleBorderZeroes(i, j + 1, board, m, n);
            handleBorderZeroes(i, j - 1, board, m, n);
        }
    }
}
