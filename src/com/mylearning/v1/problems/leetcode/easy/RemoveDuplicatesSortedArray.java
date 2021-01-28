package com.mylearning.v1.problems.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
  
  //sorted Array
  
  public static void main(String[] args) {
    //int[] a = {1, 1, 2};
    int[] a = {0,0,1,1,1,2,2,3,3,4};
    
    int j = 0;
    int n = a.length;
    for (int i = 0; i < n; i++) {
      if (i < n - 1 && a[i] == a[i + 1]) {
        continue;
      }
      a[j] = a[i];
      j++;
    }
    

    System.out.println(j);
    System.out.println(Arrays.toString(a));
  }
}
