package com.carl.usercenter.leetcode;

import java.util.*;

class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        List<Integer> list = new ArrayList<>();
        int sum = row * column;
        int rowIndex = 0;
        int columnIndex = 0;
        int[][] visited = new int[row][column];
        while(sum > 0){
            //记录这个点
            list.add(matrix[rowIndex][columnIndex]);
            visited[rowIndex][columnIndex] = 1;
            //如果碰到边界需要变direction
            int tempRow = rowIndex + direction[directionIndex][0];
            int tempColumn = columnIndex + direction[directionIndex][1];
            if(tempRow < 0 || tempRow >= row || tempColumn < 0 || tempColumn >= column || visited[tempRow][tempColumn] == 1){
                directionIndex++;
                directionIndex = directionIndex % 4;
            }

            //下一个坐标点
            rowIndex += direction[directionIndex][0];
            columnIndex += direction[directionIndex][1];

            sum--;
        }
        return list;
    }
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

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int[] window = new int[26];
        int max = 0;
        int left = 0;
        for(int i =0; i<len; i++){
            int index = s.charAt(i) - 'a';
            if(window[index] != 0){
                left = Math.max(left, window[index] + 1);
            }
            window[index] = i;
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int index = 0;
        while(index < n-1){
            int curLeft = intervals[index][0];
            int curRight = intervals[index][1];
            int nextLeft = intervals[index+1][0];
            int nextRight = intervals[index+1][1];
            if(nextLeft >= curLeft && nextLeft <= curRight){
                intervals[index+1][0] = curLeft;
                if(nextRight <= curRight){
                    intervals[index+1][1] = curRight;
                }else{
                    intervals[index+1][1] = nextRight;
                }
            }else{
                result.add(intervals[index]);
            }
            index++;
        }
        result.add(intervals[n-1]);
        int[][] res = result.toArray(new int[result.size()][]);
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        String s = "abcabcbb";
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(spiralOrder(intervals));
    }
}