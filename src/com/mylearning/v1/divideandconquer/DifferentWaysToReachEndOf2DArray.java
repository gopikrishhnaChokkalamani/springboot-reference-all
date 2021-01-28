package com.mylearning.v1.divideandconquer;

public class DifferentWaysToReachEndOf2DArray {
  
  public static void main(String[] args) {
//    int[][] arr = {
//        {2, 4, 4, 6, 8, 9},
//        {5, 7, 1, 4, 6, 9},
//        {2, 4, 4, 6, 8, 9},
//        {5, 7, 1, 4, 6, 9}
//    };
    int[][] arr = {
        {2, 4},
        {5, 7}
    };
//        int[][] arr = {
//        {2, 3}
//    };
    System.out.println("Different Ways to Reach End Of Array - Divide and Conquer : " + divideAndConquer(arr, arr.length - 1, arr[0].length - 1));
    Integer[][] dp = new Integer[arr.length][arr[0].length];
    System.out.println("Different Ways to Reach End Of Array - Dynamic Top DOwn : " + topDown(dp, arr, arr.length - 1, arr[0].length - 1));
    print(dp);
    System.out.println("Different Ways to Reach End Of Array - Dynamic Bottom Up : " + topDown(arr));
  }
  
  private static int topDown(int[][] arr) {
    int[][] dp = new int[arr.length][arr[0].length];
    
    for(int i = 0; i < arr.length;i++)
      dp[i][0] = 1;
    for(int i = 0; i < arr[0].length;i++)
      dp[0][i] = 1;
      
    for (int i = 1; i < arr.length;i++) {
      for (int j = 1; j < arr[i].length; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
//    for (int i = arr.length - 1; i >= 0; i--) {
//      for (int j = arr[i].length - 1; j >= 0; j--) {
//        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
//      }
//    }
    return dp[arr.length - 1][arr[0].length - 1];
  }
  
  private static void print(Integer[][] dp) {
    System.out.println("DP Array");
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
  
  private static int topDown(Integer[][] dp, int[][] arr, int row, int col) {
    if (row < 0 || col < 0) return 0;
    if (row == 0 && col == 0) return 1;
    if (dp[row][col] == null) {
      dp[row][col] = topDown(dp, arr, row - 1, col) + topDown(dp, arr, row, col - 1);
    }
    return dp[row][col];
  }
  
  private static int divideAndConquer(int[][] arr, int row, int col) {
    if (row < 0 || col < 0) return 0;
    if (row == 0 && col == 0) return 1;
    return divideAndConquer(arr, row - 1, col) + divideAndConquer(arr, row, col - 1);
  }
}