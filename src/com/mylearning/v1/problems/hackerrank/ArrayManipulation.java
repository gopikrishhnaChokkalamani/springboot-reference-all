package com.mylearning.v1.problems.hackerrank;

public class ArrayManipulation {
  
  public static void main(String[] args) {
    int n = 5;
    int[][] q = {
        {1, 2, 100},
        {2, 5, 100},
        {3, 4, 100}
    };
    
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int prev = 0;
    for (int i = 0; i < q.length; i++) {
      arr[q[i][0] - 1] += q[i][2];
      arr[q[i][1] - 1] += q[i][2];
      
//      int[] r = q[i];
//      int a = r[0] - 1;
//      int b = r[1] - 1;
//      int c = r[2];
//
//      for (int j = a; j <= b; j++) {
//        arr[j] += c;
//        if (arr[j] > max) {
//          max = arr[j];
//        }
//      }
//      prev = b;
    }
    int k = 0;
    System.out.println(max);
  }
}
