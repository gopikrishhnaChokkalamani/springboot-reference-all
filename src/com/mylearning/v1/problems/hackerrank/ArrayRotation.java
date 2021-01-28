package com.mylearning.v1.problems.hackerrank;

import java.util.Arrays;

public class ArrayRotation {
  
  public static void main(String[] args) {
    int d = 4;
    int[] a = {1, 2, 3, 4, 5};
    int l = a.length;
    
    while (d > 0) {
      int first = a[0];
      for (int i = 0; i  < a.length - 1; i++) {
        int tmp = a[i + 1];
        a[i] = tmp;
      }
      a[l - 1] = first;
      d--;
    }
    
    System.out.println(Arrays.toString(a));
  }
}
