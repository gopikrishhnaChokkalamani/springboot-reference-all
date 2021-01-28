package com.mylearning.v1.divideandconquer;

public class HouseThiefProblem {
  
  //cant steal from two adjacent houses, try to max the total netwroth stolen
  public static void main(String[] args) {
    int[] arr = {6, 7, 1, 30, 8, 2, 4};
    System.out.println(maxNetWorth(arr, 0));
  }
  
  private static int maxNetWorth(int[] arr, int i) {
    if (i > arr.length - 1) {
      return 0;
    }
    System.out.println(arr[i]);
    return Math.max(arr[i] + maxNetWorth(arr, i + 2), maxNetWorth(arr, i + 1));
  }
}
