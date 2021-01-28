package com.mylearning.v1.divideandconquer;

public class MinCostToReachEndOf2DArray {
  
  public static void main(String[] args) {
    int[][] arr =
        {
            {4, 7, 8, 6, 4},
            {6, 7, 3, 9, 2},
            {3, 8, 1, 2, 4},
            {7, 1, 7, 3, 7},
            {2, 9, 8, 9, 3}
        };
    System.out.println(minCost(arr,  arr.length - 1, arr[0].length - 1));
  }
  
  private static int minCost(int[][] arr, int row, int column) {
    if (row == -1 || column == -1) {
      return 0;
    }
    if (row == 0 && column == 0) {
      return arr[0][0];
    }
    
    int min1 = minCost(arr, row - 1, column);
    int min2 = minCost(arr, row, column - 1);
    
    return arr[row][column] + Math.min(min2, min1);
  }
}