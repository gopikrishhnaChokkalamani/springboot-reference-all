package com.mylearning.v1.problems.leetcode.easy;

public class ReverseInteger {
  
  public static void main(String[] args) {
    int i = 1534236469;
    System.out.println(reverse(i));
  }
  
  public static int reverse(int i) {
    int rev = 0;
    while (i != 0) {
      if (rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10) {
        return 0;
      }
      rev = rev * 10 + i % 10;;
      i /= 10;
    }
    return rev;
  }
}
