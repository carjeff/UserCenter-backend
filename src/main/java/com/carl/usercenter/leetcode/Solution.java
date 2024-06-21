package com.carl.usercenter.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n ==0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int m = set.size();
        int[] newNums = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(newNums);
        int max = Integer.MIN_VALUE;
        int len = 1;
        for(int i =1; i<m; i++){
            int cur = nums[i];
            int old = nums[i-1];
            if( old +1 == cur){
                len++;
            }else{
                max = Math.max(max, len);
                len = 1;
            }
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}