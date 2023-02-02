package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array : ");

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter target : ");
        int target = sc.nextInt();
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        if(nums.length == 2){
            return new int[]{0, 1};
        }

        int[] res = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < n; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
        }

        return new int[]{-1, -1};
    }
}
