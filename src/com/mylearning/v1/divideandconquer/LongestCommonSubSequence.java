package com.mylearning.v1.divideandconquer;

public class LongestCommonSubSequence {
  
  public static void main(String[] args) {
    System.out.println(lcs("elephant", "eretpat", 0, 0));
  }
  
  private static int lcs(String s1, String s2, int i, int j) {
    if (i > s1.length() - 1 || j > s2.length() - 1) {
      return 0;
    }
    int match = 0;
    if (s1.charAt(i) == s2.charAt(j)) {
      match = 1 + lcs(s1, s2, i + 1, j + 1);
    }
    return Math.max(match, Math.max(lcs(s1, s2, i, j + 1), lcs(s1, s2, i + 1, j)));
  }
}