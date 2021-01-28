package com.mylearning.v1.divideandconquer;

public class FibonacciSeries {
  
  public static void main(String[] args) {
    int n = 6;
    System.out.println(fibonacciNumberAt(n));
  }
  
  private static int fibonacciNumberAt(int n) {
    if (n < 1) {
      return 0;
    } else if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    }
    return fibonacciNumberAt(n - 1) + fibonacciNumberAt(n - 2);
  }
}