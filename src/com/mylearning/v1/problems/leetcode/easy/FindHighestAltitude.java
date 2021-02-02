package com.mylearning.v1.problems.leetcode.easy;

import java.util.Arrays;

public class FindHighestAltitude {
  
  public static void main(String[] args) {
    int[] g = {-5,1,5,0,-7};
    int[] a = new int[g.length + 1];
    int k = 0, j = 1;
    a[0] = k;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < g.length; i++) {
      int t = a[i] + g[i];
      a[j++] = t;
      max = Math.max(max, Math.max(a[i], t));
    }
    System.out.println(Arrays.toString(g));
    System.out.println(Arrays.toString(a));
    System.out.println(max);
  }
}
