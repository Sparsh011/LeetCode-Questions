package Sorting;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++){
            int next = i + 1;
            int end = nums.length - 1;

            while(next < end){
                int currentSum = nums[i] + nums[next] + nums[end];

                if(currentSum < target){
                    next++;
                }
                else{
                    end--;
                }

                if(Math.abs(target - currentSum) < Math.abs(target - sum)){
                    sum = currentSum;
                }
            }
        }

        return sum;
    }
}
