package Sorting;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int p1 = 0, p2 = n - 1;
        int i = 0;

        while(p1 <= p2){
            if(Math.abs(nums[p2]) > Math.abs(nums[p1])){
                res[n - i - 1] = nums[p2] * nums[p2];
                p2--;
            }
            else{
                res[n - i - 1] = nums[p1] * nums[p1];
                p1++;
            }
            i++;
        }

        return res;
    }
}
