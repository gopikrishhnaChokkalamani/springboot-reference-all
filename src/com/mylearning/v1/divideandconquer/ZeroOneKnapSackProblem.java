package com.mylearning.v1.divideandconquer;

public class ZeroOneKnapSackProblem {
  
  public static void main(String[] args) {
    int capacity = 7;
    int[] profits = {31, 26, 72, 17};
    int[] weights = {3, 1, 5, 2};
    System.out.println(maxProfit(profits, weights, capacity,  0));
  }
  
  private static int maxProfit(int[] profits, int[] weights, int capacity, int i) {
    if (i >= profits.length - 1 || i >= weights.length - 1) {
      return 0;
    }
    int startFromZero = 0;
    if (capacity >= weights[i]) {
       startFromZero = profits[i] + maxProfit(profits, weights, capacity - weights[i], i + 1);
    }
    int startFromOne = maxProfit(profits, weights, capacity, i + 1);
    return Math.max(startFromZero, startFromOne);
  }
}
