package com.gagan;

import java.util.Arrays;
import java.util.HashMap;

public class DayTwo {
    public static void main(String[] args) {
//        int arr[] = new int[]{2,7,11,15};
//        twoSum(arr, 9);

        int nums1[] = new int[]{0};
        int m = 0, n=1;
        int nums2[] = new int[]{1};
        merge(nums1,m, nums2, n);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = null;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr = new int[2];
                arr[0] = Integer.valueOf(map.get(target - nums[i]));
                arr[1] = i;
            } else {
                map.put(nums[i], String.valueOf(i));
            }
        }
        return arr;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j =  n - 1;
        int k = nums1.length - 1;

        while(j >= 0) {

            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }

        }
        System.out.println(Arrays.toString(nums1));
    }
}
