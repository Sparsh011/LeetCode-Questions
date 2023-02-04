package Arrays;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SortStudentsByKthScore {
    public static void main(String[] args) {
        int[][] score = {{10, 6, 9, 1}, {5, 2, 7, 3}, {15, 20, 11, 4}};
        sortTheStudents(score, 2);
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
//        Most optimised -
        // Arrays.sort(score, (s1, s2) -> Integer.compare(s2[k], s1[k]));
        // return score;

//        Time - O(N*M) and space - O(N)

        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int m = score.length;
        int n = score[0].length;

        if(k >= n) return score;

        for(int i = 0; i < m; i++){
            map.put(score[i][k], i);
        }

        int[][] res = new int[m][n];
        int newRow = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            res[newRow++] = score[entry.getValue()];

//            Another way :
//            fillArr(res, newRow, score, entry.getValue(), n);
//            newRow++;

        }

        return res;
    }

    private static void fillArr(int[][] res, int resRow, int[][] score, int scoreRow, int n){
        if (n >= 0) System.arraycopy(score[scoreRow], 0, res[resRow], 0, n);
    }
}
