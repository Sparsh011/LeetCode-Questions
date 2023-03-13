package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int next = i + 1;
            int end = nums.length - 1;

            while(next < end){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[next]);
                list.add(nums[end]);

                if(nums[i] + nums[next] + nums[end] > 0){
                    end--;
                }
                else if(nums[i] + nums[next] + nums[end] < 0){
                    next++;
                }
                else{
                    res.add(new ArrayList(list));
                    // next++ and end-- so that we can try all possible combinations
                    next++;
                    end--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
