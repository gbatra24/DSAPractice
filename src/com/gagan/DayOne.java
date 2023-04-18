package com.gagan;

import java.util.HashMap;

public class DayOne {

    public static void main(String[] args) {
        int arr[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        boolean result = containsDuplicate(arr);
//        int result = maxSubArray(arr);
        System.out.println(result);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> items = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (items.containsKey(nums[i])) {
                return true;
            } else {
                items.put(nums[i], 1);
            }
        }
        return false;
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0 , maxi = Integer.MIN_VALUE;
        int i = 0, j = 0, k = 0;
        while(i<nums.length){

            if(sum < 0 && nums[i] >= sum){
                sum = 0;
                j = k = i;
            }
            sum += nums[i];
            if (maxi < sum) {
                maxi = sum;
                k = i;
            }
            i++;
        }
        for (int index = j; index <= k; index++) {
            System.out.println(nums[index]);
        }
        System.out.println(j+ "," +k);
        return maxi;
    }
}
