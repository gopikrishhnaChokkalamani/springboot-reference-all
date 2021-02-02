package com.mylearning.v1.problems.leetcode.medium;

public class MinimumPathSum {
  
  public static void main(String[] args) {
    int[][] grid = {
        {1, 2, 3},
        {4, 5, 6}
    };
    Integer[][] dp = new Integer[grid.length + 1][grid.length + 1];
    System.out.println(minimumPathSum(grid, grid.length - 1, grid[0].length - 1, dp));
  }
  
  private static int minimumPathSum(int[][] arr, int row, int col, Integer[][] dp) {
    if (row < 0 || col < 0) {
      return Integer.MAX_VALUE;
    }
    if (row == 0 && col == 0) {
      return arr[row][col];
    }
    if (dp[row][col] == null) {
      int right = minimumPathSum(arr, row, col - 1, dp);
      int down = minimumPathSum(arr, row - 1, col, dp);
      dp[row][col] = arr[row][col] + Math.min(right, down);
    }
    return dp[row][col];
  }
}
