package com.mylearning.v1.problems.leetcode.hard;

public class MedianOfTwoArrays {
  
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] b = {11, 12, 13, 14, 15, 16, 17, 18, 19};
    int j = a.length - 1, l = b.length - 1;
    int m = 0;
    if (j < l) {
      m = findMedian(a, 0, j, b, 0, l);
    } else {
      m = findMedian(b, 0, l, a, 0, j);
    }
  }
  
  private static int findMedian(int[] a, int i, int j, int[] b, int k, int l) {
    
    int aMid = (i + j) / 2;
    int bMid = (k + l) / 2;
    int m = 0;
    if (a[aMid] < b[bMid]) {
      j = aMid + j;
      l = k + bMid;
      if (j < l) {
        m = findMedian(a, aMid, j, b, k, bMid);
      } else {
        m = findMedian(b, k, bMid, a, aMid, j);
      }
    }
    return m;
  }
}