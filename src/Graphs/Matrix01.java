package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

//        Storing all 0s in queue because 0 to 0 distance is minimum. Then update the values of adjacent cells of those 0s stored in queue.

        Queue<Pair> queue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.offer(new Pair(i, j));
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!queue.isEmpty()) {
            Pair currentCoordinates = queue.poll();

            for (int[] dir : dirs) {
                int neighborRow = dir[0] + currentCoordinates.x;
                int neighborColumn = dir[1] + currentCoordinates.y;

//                Agar neighbor ki value already kam hai currentCoordinates se, no need to change its value

                if (neighborRow < 0 || neighborRow >= m || neighborColumn < 0 || neighborColumn >= n || mat[neighborRow][neighborColumn] <= mat[currentCoordinates.x][currentCoordinates.y] + 1)
                    continue;

                mat[neighborRow][neighborColumn] = mat[currentCoordinates.x][currentCoordinates.y] + 1;
                queue.offer(new Pair(neighborRow, neighborColumn));
            }
        }

        return mat;

    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
