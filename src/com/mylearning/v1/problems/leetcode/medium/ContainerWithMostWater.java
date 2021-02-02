package com.mylearning.v1.problems.leetcode.medium;

public class ContainerWithMostWater {
  
  public static void main(String[] args) {
    //int[] heights = {1,8,6,2,5,4,8,3,7};
    //int[] heights = {1,2,1};
    int[] heights = {4, 3, 2, 1, 4};
    int max = 0;
    int i = 0, j = heights.length - 1;
    while (i < j) {
      int area = (j - i) * Math.min(heights[i], heights[j]);
      if (max < area) {
        max = area;
      }
      if (heights[i] < heights[j]) {
        i++;
      } else {
        j--;
      }
    }
    System.out.println(max);
  }
}
