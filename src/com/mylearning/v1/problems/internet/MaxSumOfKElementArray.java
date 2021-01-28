package com.mylearning.v1.problems.internet;

public class MaxSumOfKElementArray {
  
  public static void main(String[] args) {
    int[] arr = {100, 200, 300, 400};
    int k = 2;
    Integer[][] dp = new Integer[arr.length + 1][k + 1];
    System.out.println(maxSum(arr, 0, 2, dp));
  
    System.out.println();
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  private static int maxSum(int[] arr, int i, int k, Integer[][] dp) {
    if (i == arr.length) {
      return 0;
    }
    if (dp[i][k] == null) {
      int case1 = 0;
      if (k != 0) {
        case1 = arr[i] + maxSum(arr, i + 1, k - 1, dp);
      }
      int case2 = maxSum(arr, i + 1, k, dp);
      dp[i][k] = Math.max(case1, case2);
    }
    System.out.println(i + " , " + k + " - " + dp[i][k]);
    return dp[i][k];
  }
}
