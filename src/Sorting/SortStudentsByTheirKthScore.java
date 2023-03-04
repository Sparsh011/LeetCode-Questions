package Sorting;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

public class SortStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
//         Arrays.sort(score, (s1, s2) -> Integer.compare(s2[k], s1[k]));
        // return score;

        Map<Integer, int[]> map = new TreeMap<>(Collections.reverseOrder());
        int start = 0;

        for (int[] ints : score) {
            map.put(ints[k], ints);
        }

        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            score[start++] = entry.getValue();
        }

        return score;
    }
}
