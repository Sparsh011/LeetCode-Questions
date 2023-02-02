package Arrays;

import java.util.ArrayList;
import java.util.List;

// Not a great solution, come back later
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null) return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int col = 0;

        for(int i = 0; i < m && col < n; i++){
            int currentCol = col;
            right(i, matrix, list, currentCol);
            down(i, matrix, list, n - currentCol - 1);
            left(m - i - 1, matrix, list, n - currentCol - 1);
            up(m - i - 1, matrix, list, currentCol);
            col++;
        }

        return list;
    }

    private static void right(int row, int[][] matrix, List<Integer> list, int column){
        for(; column < matrix[0].length; column++){
            if(matrix[row][column] > -1000){
                list.add(matrix[row][column]);
                matrix[row][column] = -1001;
            }
        }
    }

    private static void down(int row, int[][] matrix, List<Integer> list, int column){
        for(; row < matrix.length; row++){
            if(matrix[row][column] > -1000){
                list.add(matrix[row][column]);
                matrix[row][column] = -1001;
            }
        }
    }

    private static void left(int row, int[][] matrix, List<Integer> list, int column){
        for(; column >= 0; column--){
            if(matrix[row][column] > -1000){
                list.add(matrix[row][column]);
                matrix[row][column] = -1001;
            }
        }
    }

    private static void up(int row, int[][] matrix, List<Integer> list, int column){
        for(; row >= 0; row--){
            if(matrix[row][column] > -1000){
                list.add(matrix[row][column]);
                matrix[row][column] = -1001;
            }
        }
    }
}
