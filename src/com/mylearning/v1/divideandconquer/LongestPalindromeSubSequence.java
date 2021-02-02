package com.mylearning.v1.divideandconquer;

public class LongestPalindromeSubSequence {
  
  public static void main(String[] args) {
    String s = "ELRMENMET";
    System.out.println(lps(s, 0, s.length() - 1));
  }
  
  private static int lps(String s, int i, int j) {
    if (i > s.length() - 1) {
      return 0;
    }
    if (j < 0) {
      return 0;
    }
    int match = 0;
    if (s.charAt(i) == s.charAt(j)) {
      match = 1 + lps(s, i + 1, j - 1);
    }
    return Math.max(match, Math.max(lps(s, i, j - 1), lps(s, i + 1, j)));
  }
}