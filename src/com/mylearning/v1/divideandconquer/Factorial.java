package com.mylearning.v1.divideandconquer;

public class Factorial {
  
  public static void main(String[] args) {
    int n = 5;
    System.out.println(factorial(n));
  }
  
  private static int factorial(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    return n * factorial(n - 1);
  }
}
