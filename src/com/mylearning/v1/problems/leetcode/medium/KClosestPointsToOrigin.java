package com.mylearning.v1.problems.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
  
  //Euclidean Formula - Sqrt((x2 - x1)^2 + (y2 - y1)^2)
  
  public static void main(String[] args) {
    int[][] arr = {
        {1, 3},
        {-2, 2}
    };
    int k = 1;
//    Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//      @Override
//      public int compare(int[] a, int[] b) {
//        return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
//      }
//    });
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
    
    for (int[] a : arr) {
      queue.add(a);
      if (queue.size() > k) {
        queue.remove();
      }
    }
    int[][] res = new int[k][2];
    int i = 0;
    while (!queue.isEmpty()) {
      res[i] = queue.remove();
      i++;
    }
    
    for (int j = 0; j < res.length; j++) {
      for (int m = 0; m < res[j].length; m++) {
        System.out.print(res[j][m] + " ");
      }
      System.out.println();
    }
  }
}
