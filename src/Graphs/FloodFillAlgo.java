package Graphs;

public class FloodFillAlgo {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int m = image.length;
            int n = image[0].length;

            // Start from image[sr][sc]

            dfs(image, sr, sc, m, n, color, image[sr][sc]);

            return image;
        }

        private void dfs(int[][] image, int i, int j, int m, int n, int color, int originalPixel){
//            color can be same as image[sr][sc] that's why :
            if(i >= m || j >= n || i < 0 || j < 0 || image[i][j] != originalPixel || image[i][j] == color) return;

            image[i][j] = color;

            dfs(image, i + 1, j, m, n, color, originalPixel);
            dfs(image, i - 1, j, m, n, color, originalPixel);
            dfs(image, i, j + 1, m, n, color, originalPixel);
            dfs(image, i, j - 1, m, n, color, originalPixel);
        }
    }
}
