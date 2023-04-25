package PriorityQueue;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int current;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        current = 1;
    }

    public int popSmallest() {
        int result = current;

        if (!pq.isEmpty() && pq.peek() < current) result = pq.poll();
        else current++;

        while (!pq.isEmpty() && pq.peek() == result) {
            pq.poll();
        }

        return result;
    }

    public void addBack(int num) {
        pq.offer(num);
    }
}
