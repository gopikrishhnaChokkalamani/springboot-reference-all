package com.mylearning.v1.divideandconquer;

public class LongestPalindromeSubString {
  
  public static void main(String[] args) {
    String s = "emadamwerw";
    System.out.println(lps(s, 0, s.length() - 1));
  }
  
  private static int lps(String s, int i, int j) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      return 1;
    }
    int equals = 0;
    if (s.charAt(i) == s.charAt(j)) {
      int remaining = j - i - 1;
      if (remaining == lps(s, i + 1, j - 1)) {
        equals = remaining + 2;
      }
    }
    int last = lps(s, i +1, j);
    int second = lps(s, i, j - 1);
    return Math.max(equals, Math.max(last, second));
  }
}