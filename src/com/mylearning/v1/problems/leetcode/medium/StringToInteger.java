package com.mylearning.v1.problems.leetcode.medium;

public class StringToInteger {
  
  public static void main(String[] args) {
    int[] a = {2, 5, 1, 3, 4};
    int bribes = 0;
    for (int i = 0; i < a.length;i++) {
      if (a[i] - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = 0; j < i;j++) {
        if (a[j] > a[i]) {
          bribes++;
        }
      }
    }
    System.out.println(bribes);
  }
}
