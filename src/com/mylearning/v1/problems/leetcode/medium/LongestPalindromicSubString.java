package com.mylearning.v1.problems.leetcode.medium;

public class LongestPalindromicSubString {
  
  public static void main(String[] args) {
    String s = "aacabdkacaa";
    int[][] dp = new int[s.length()][s.length()];
    int[] sub = new int[s.length()];
    System.out.println(lps(s, 0, s.length() - 1, dp, sub));
    String r = "";
    for (int i = sub[0]; i <= sub[1]; i++) {
        r += s.charAt(i);
    }
    System.out.println(r);
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  private static String palindromeSubString(String s, int i, int j, String subString) {
    return null;
  }
  
  private static int lps(String s, int i, int j, int[][] dp, int[] subString) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      return 1;
    }
    if (dp[i][j] == 0) {
      int case1 = 0;
      if (s.charAt(i) == s.charAt(j)) {
        int remaining = j - i - 1;
        if (remaining == lps(s, i + 1, j - 1, dp, subString)) {
          subString[0] = i;
          subString[1] = j;
          case1 = remaining + 2;
        }
      }
      int case2 = lps(s, i + 1, j, dp, subString);
      int case3 = lps(s, i, j - 1, dp, subString);
      dp[i][j] = Math.max(case1, Math.max(case2, case3));
    }
    return dp[i][j];
  }
}