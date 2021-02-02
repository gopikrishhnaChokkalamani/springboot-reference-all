package com.mylearning.v1.problems.leetcode.easy;

public class BestTimeToBuyStock {
  
  public static void main(String[] args) {
    int[] arr = {71, 1, 5, 3, 6, 4};
    
    int min = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      } else if (arr[i] - min > profit) {
        profit = arr[i] - min;
      }
    }
    System.out.println(profit);
  }
}
