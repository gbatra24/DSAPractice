package com.gagan.leetcode.lc150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayStrings {
    public static void main(String[] args) {
        int[] nums1 = {0,1,2,2,3,0,4,2};
        int[] nums2 = {6,5,5};
//        mergeSortedArrays(nums1, 3, nums2, 3);
//        sortedSquares(nums1);
//        removeElement(nums1, 2);
//        removeDuplicatesTwo(nums2);
//        majorityElement2(nums2);
//        romanToInt("");
//        lengthOfLastWord("   fly me   to   the moon  ");
        String[] strings = {"dog","racecar","car"};
//        longestCommonPrefix(strings);
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        // https://leetcode.com/problems/merge-sorted-array/
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while(j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length -1;
        while(j >= 0 && i<=j) {
            int pow1 = (int) Math.pow(nums[i], 2);
            int pow2 = (int) Math.pow(nums[j], 2);
            if (pow1 > pow2) {
                result[k--] = pow1;
                i++;
            } else {
                result[k--] = pow2;
                j--;
            }
        }
        return result;
    }

    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter++] = nums[i];
            }
        }
        return counter;
    }

    public static int removeDuplicates(int[] nums) {
//        int counter = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                nums[counter++] = nums[i];
//            } else {
//                if (nums[counter - 1] != nums[i]) {
//                    nums[counter++] = nums[i];
//                }
//            }
//        }
//        return counter;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int num:
             nums) {
            System.out.print(num);
        }
        return j;
    }

    public static int removeDuplicatesTwo(int[] nums) {
        int j = 1;
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                counter = 0;
            } else {
                counter++;
            }
            if (counter < 2) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(j);
        for (int num: nums) {
            System.out.print(num);
        }
        return j;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num: nums) {
            if (numMap.containsKey(num)) {
                int numCount = numMap.get(num);
                numMap.put(num, numCount + 1);
            } else {
                numMap.put(num, 1);
            }
        }
        int element = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry: numMap.entrySet()) {
            if (entry.getValue() >= Math.ceil(nums.length)/2) {
                element = entry.getKey();
            }
        }
//        System.out.println(element);
        return element;
    }

    public static int majorityElement2(int[] nums) {
        Integer element = null;
        int count = 0;
        for (int num:nums) {
            if (count == 0) {
                element = num;
                count++;
                continue;
            }

            if (element == num) {
                count++;
            } else {
                count--;
            }
        }
        int count2=0;
        for (int num: nums) {
            if (element == num) {
                count2++;
            }
        }
        if (count2 > nums.length/2) {
            System.out.println(element + " , "+count2);
            return element;
        }
        System.out.println(-1+" , "+count2+ " , "+element+" , "+count);
        return -1;
    }

    public static int romanToInt(String s) {
        //MCMXCIV
        int num = 0;
        HashMap<Character,Integer> charMap = new HashMap<>();
        charMap.put('I',1);
        charMap.put('V',5);
        charMap.put('X',10);
        charMap.put('L',50);
        charMap.put('C',100);
        charMap.put('D',500);
        charMap.put('M',1000);
        for (int i = s.length()-1; i >= 0; i--) {
            if (i == s.length() - 1) {
                num = num + charMap.get(s.charAt(i));
                continue;
            }
            if (charMap.get(s.charAt(i)) < charMap.get(s.charAt(i + 1))) {
                num = num - charMap.get(s.charAt(i));
            } else {
                num = num + charMap.get(s.charAt(i));
            }
        }
        System.out.println(num);
        return num;
    }

    public static int lengthOfLastWord(String s) {
        String[] strArray = s.split(" ");
        String lastWord = strArray[strArray.length - 1];
        System.out.println(lastWord.length());
        return lastWord.length();
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) == last.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        System.out.println(first.substring(0, index));
        return first.substring(0, index);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        String processedStr = s.toLowerCase();
        int i = 0;
        int j = processedStr.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (processedStr.charAt(i) != processedStr.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

}
