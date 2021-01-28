package com.mylearning.v1.problems.leetcode.easy;

import java.util.Arrays;

public class MergeTwoSortedArrays {
  
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 0, 0, 0};
    int[] b = {2, 5, 6};
    int m = 3, n = 3;
  
  
    int[] c = new int[m + n];
    int i = 0, j = 0, k = 0;
    while (i != m && j != n) {
      if (a[i] < b[j]) {
        c[k] = a[i];
        i++;
      } else {
        c[k] = b[j];
        j++;
      }
      k++;
    }
    for (int l = i; l < m; l++) {
      c[k] = a[l];
      k++;
    }
    for (int l = j; l < n; l++) {
      c[k] = b[l];
      k++;
    }
  
    System.arraycopy(c, 0, a, 0, a.length);
  
    System.out.println(Arrays.toString(a));
  }
}
