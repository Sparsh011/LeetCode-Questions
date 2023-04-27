package Arrays;

import java.util.*;

class InsertDeleteGetRandomO1 {
    Set<Integer> set;

    public InsertDeleteGetRandomO1() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int n = set.size();
        Random random = new Random();
        int randomNumber = random.nextInt(n);
        List<Integer> list = new ArrayList<>(set);

        return list.get(randomNumber);
    }
}