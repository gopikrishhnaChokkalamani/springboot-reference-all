package com.mylearning.v1.problems.leetcode.easy;

public class SearchInsertPosition {
  
  public static void main(String[] args) {
    int[] a = {1};
    int t = 0;
    
    for (int i = 0; i < a.length; i++) {
      if (a[i] == t) {
        System.out.println(i);
        return;
      }
      if (a[i] > t) {
        System.out.println(i);
        return;
      }
    }
    System.out.println(a.length);
  }
}
