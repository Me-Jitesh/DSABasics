package Leetcode;

import java.util.Arrays;

// 300. Longest Increasing Subsequence
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

//        return solveRecursion(nums, 0, -1);

//        int[][] dp = new int[nums.length + 1][nums.length + 1];
//        for (int[] x : dp)
//            Arrays.fill(x, -1);
//
//        return solveRecursionMemoi(nums, 0, -1, dp);

        return solveBottomUp(nums);
    }

    private int solveRecursion(int[] nums, int i, int prev) {

        if (i >= nums.length) {
            return 0;
        }

        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) { // solve for -1 as well so, OR
            take = 1 + solveRecursion(nums, i + 1, i);
        }

        int skip = solveRecursion(nums, i + 1, prev);

        return Math.max(take, skip);
    }

    private int solveRecursionMemoi(int[] nums, int i, int prev, int[][] dp) {

        if (i >= nums.length) {
            return 0;
        }

        if (prev != -1 && dp[i][prev] != -1) {
            return dp[i][prev];
        }

        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) { // solve for -1 as well  but not check for inc so, ||
            take = 1 + solveRecursionMemoi(nums, i + 1, i, dp);
        }

        int skip = solveRecursionMemoi(nums, i + 1, prev, dp);

        if (prev != -1)
            return dp[i][prev] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    private int solveBottomUp(int[] nums) {

        int maxLIS = 1; // 1 for case like {7,7,7,7,7}

        int t[] = new int[nums.length + 1];
        Arrays.fill(t, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //    t[i] = t[j]+1; // gives problem if subsequence reset anywhere
                    t[i] = Math.max(t[j] + 1, t[i]);
                    maxLIS = Math.max(maxLIS, t[i]);
                }
            }
        }
        return maxLIS;
    }
}
