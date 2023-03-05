package Sorting;

import java.util.*;

public class ReduceArraySizeToHalf {
//    You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array. Return the minimum size of the set so that at least half of the integers of the array are removed.

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry.getValue());
        }

        int count = 0;
        int n = arr.length;

        while(n > arr.length/2){
            n -= pq.poll();
            count++;
        }

        return count;
    }
}
