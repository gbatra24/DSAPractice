package com.gagan.leetcode.dsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DayThree {
    public static void main(String[] args) {
        int nums1[] = new int[]{7,1,5,3,6,4};
        int nums2[] = new int[]{1,2};
//        intersect(nums1, nums2);
        maxProfit(nums1);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int i = 0,j = 0,k = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static int maxProfit(int[] prices) {
        int currentPrice = Integer.MAX_VALUE;
        int maxProfit = 0, profitToday = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < currentPrice){
                currentPrice = prices[i];
            }
            profitToday = prices[i] - currentPrice;
            maxProfit = Math.max(maxProfit, profitToday);
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
}
