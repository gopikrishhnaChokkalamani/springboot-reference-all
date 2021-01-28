package com.mylearning.v1.problems.leetcode.easy;

public class PalindromeInteger {
  
  public static void main(String[] args) {
    int i = 10;
    int x = i;
    int rev = 0;
    while (i != 0) {
      int rem = i % 10;
      rev = rev * 10 + rem;
      i /= 10;
    }
    System.out.println((rev == x) ? true : false);
    System.out.println((i < 0) ? false : isPalindrome(i, i, 0));
  }
  
  private static boolean isPalindrome(int i, int num, int rev) {
    if (num == rev) {
      return true;
    }
    if (i != 0) {
      int rem = i % 10;
      rev = rev * 10 + rem;
      i /= 10;
    } else {
      return false;
    }
    return isPalindrome(i, num, rev);
  }
}
