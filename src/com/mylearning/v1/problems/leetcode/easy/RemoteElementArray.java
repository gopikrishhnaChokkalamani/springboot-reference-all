package com.mylearning.v1.problems.leetcode.easy;

import java.util.Arrays;

public class RemoteElementArray {
  
  public static void main(String[] args) {
    int[] a = {0,1,2,2,3,0,4,2};
    int d = 2, n = a.length, j = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == d) {
        continue;
      }
      a[j] = a[i];
      j++;
    }
    System.out.println(j);
    System.out.println(Arrays.toString(a));
  }
}
